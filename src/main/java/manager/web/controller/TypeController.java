package manager.web.controller;

import manager.entity.KnowledgeType;
import manager.entity.User;
import manager.service.KnowledgeTypeService;
import manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangheng on 2017/3/19.
 */
@Controller
public class TypeController {

    @Resource
    KnowledgeTypeService knowledgeTypeService;
    @Resource
    UserService userService;
    @RequestMapping("typemanager")
    public String typemanmger(HttpServletRequest request){
        List<KnowledgeType> list = knowledgeTypeService.listEntity();
        if (!list.isEmpty())
            request.setAttribute("alltype",list);
        return "typemanager";
    }
    @RequestMapping("usermanager")
    public String usermanager(HttpServletRequest request){
        List<User> list = userService.listEntity();
        if (!list.isEmpty())
            request.setAttribute("alluser",list);
        return "usermanager";
    }
    @RequestMapping("deletetype")
    public String deletetype(HttpServletRequest request, @RequestParam String curdeletetype){
        KnowledgeType knowledgeType = knowledgeTypeService.getEntity(curdeletetype);
        if (knowledgeType!=null){
            knowledgeTypeService.delete(knowledgeType);
        }
        return "typemanager";
    }
}
