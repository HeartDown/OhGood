package manager.web.controller;

import core.constant.MainConstant;
import core.util.FileUtil;
import core.web.controller.BaseController;
import manager.dto.ResultCode;
import manager.entity.Knowledge;
import manager.entity.KnowledgeType;
import manager.entity.Think;
import manager.entity.User;
import manager.service.KnowledgeService;
import manager.service.KnowledgeTypeService;
import manager.service.KnowledgeUpLoadService;
import manager.service.ThinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhangheng on 2017/3/3.
 */
@Controller
@RequestMapping("/knowledge")
public class KnowledgeController extends BaseController{

    @Resource
    KnowledgeService knowledgeService;
    @Resource
    KnowledgeUpLoadService knowledgeUpLoadService;
    @Resource
    KnowledgeTypeService knowledgeTypeService;
    @Resource
    ThinkService thinkService;
    @RequestMapping("source")
    public String source(HttpServletRequest request){
        List<Knowledge> knowledges = knowledgeService.listEntity();
        request.getSession().setAttribute("knowledges",knowledges);
        request.getSession().setAttribute("curtype",null);
        return "knowledgesource";
    }



    @RequestMapping("uploadknowledge")
    public String uploadknowledge(){
        return "uploadknowledge";
    }

    @RequestMapping(value = "uploadknowledge",method = RequestMethod.POST)
    @ResponseBody
    public void source(HttpServletResponse httpServletResponse, HttpServletRequest request,@RequestParam String title,
                       @RequestParam String content,@RequestParam String knowledgetype) throws IOException {
        Knowledge knowledge = new Knowledge(UUID.randomUUID().toString(),title,content, MainConstant.KNOWLEDGE_SOURCE,knowledgetype);
        String path=MainConstant.FILE_PATH+knowledge.getTitle()+MainConstant.PDF_SUFFIX;
        //上传文件到指定目录
        FileUtil.transferTo(path,request);

        User user = (User) request.getSession().getAttribute("CurrentUser");
        if (null == user){
            writeJSON(httpServletResponse,new ResultCode(-1,"上传失败"));
            return;
        }
        knowledge.setImgpath("ep1.jpg");
        knowledgeService.sava(knowledge);
        knowledgeUpLoadService.uploadKnowledge(user,knowledge);
        writeJSON(httpServletResponse,new ResultCode(1,"上传成功"));
    }

    @RequestMapping("think")
    public String think(HttpServletRequest request,@RequestParam String title) throws Exception {
        Knowledge knowledge = knowledgeService.getOneKnowledge("title",title);
        request.getSession().setAttribute("curknowledge",knowledge);
        //在request中设置评论内容list
        setThinkAttribute(request,knowledge);
        return "knowledgeinfo";
    }

    public void setThinkAttribute(HttpServletRequest request,Knowledge knowledge) throws Exception {
        List<Think> list = thinkService.get("knowledgeid",knowledge.getId());
        request.setAttribute("thinks",list);
    }

    @RequestMapping(value = "think",method = RequestMethod.POST)
    public String uploadthink(HttpServletRequest request,@RequestParam String myword) throws Exception {
        User user = (User) request.getSession().getAttribute("CurrentUser");
        Knowledge knowledge = (Knowledge) request.getSession().getAttribute("curknowledge");
        //上传评论
        thinkService.uploadThink(user,knowledge,myword);
        //在request中设置评论内容list
        setThinkAttribute(request,knowledge);
        return "knowledgeinfo";
    }

    @RequestMapping("type")
    public String type(){
        return "knowledgetype";
    }

    @RequestMapping("sourceWithType")
    public String sourceWithType(HttpServletRequest request,@RequestParam String type) throws Exception {
        List<KnowledgeType> type1 = (List<KnowledgeType>) knowledgeTypeService.get("typename",type);
        if (type1.isEmpty())
            return "knowledgesource";
        request.getSession().setAttribute("curtype",type1.get(0));
        return "knowledgesource";
    }
}
