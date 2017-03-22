package manager.web.controller;

import com.alibaba.fastjson.JSONObject;
import core.web.controller.BaseController;
import manager.dto.ResultCode;
import manager.entity.Knowledge;
import manager.entity.KnowledgeType;
import manager.entity.User;
import manager.service.KnowledgeService;
import manager.service.KnowledgeTypeService;
import manager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhangheng on 2017/3/1.
 */
@Controller
public class MainController extends BaseController{

    @Resource
    UserService userService;
    @Resource
    KnowledgeTypeService knowledgeTypeService;
    @Resource
    KnowledgeService knowledgeService;
    private User user = null;
    @RequestMapping(value = "register")
    public String goRegister(){
        return "register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register( @RequestParam String name, @RequestParam String password, @RequestParam String email
            , @RequestParam String phone,HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        try {
            userService.sava(user);
            writeJSON(response,new ResultCode(1,"注册成功"));
            return "login";
        }catch (Exception e){
            writeJSON(response,new ResultCode(-1,"用户名已存在"));
            return "register";
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = "loginUser")
    public void login(@RequestParam("username") String username, @RequestParam("password") String password,
                      @RequestParam("rememberMe") boolean rememberMe,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultCode resultCode;
        JSONObject jsonObject =  new JSONObject();
        try {
            user = userService.login(username,password);
            resultCode = new ResultCode(1,"登陆成功");
            jsonObject.put("code","1");
            jsonObject.put("message","登录成功");
        }
        catch (UnknownAccountException ua){
            resultCode = new ResultCode(-1,"用户名错误");
        }
        catch (Exception e) {
            request.setAttribute("loginStatus",e.getMessage());
            resultCode = new ResultCode(2,"登陆失败");
        }
        if (Objects.equals("null", user)){
            resultCode = new ResultCode(3,"用户不存在或密码错误");
        }else if (rememberMe){
            response.addCookie(new Cookie("lastUser",user.getUsername()));
        }
        request.setAttribute("CurrentUser",user);
        request.getSession().setAttribute("CurrentUser",user);

        //知识类型放入session
        List<KnowledgeType> list = knowledgeTypeService.listEntity();
        request.getSession().setAttribute("knowledgetype",list);

        writeJSON(response,jsonObject.toString());
    }
    @RequestMapping(value = "loginUser")
    public String login(HttpServletRequest request,HttpServletResponse response) throws Exception {
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals("lastUser")){
                user = userService.getByUserName(request.getCookies()[i].getValue());
                request.setAttribute("CurrentUser",user);
                request.getSession().setAttribute("CurrentUser",user);

                List<KnowledgeType> list = knowledgeTypeService.listEntity();
                request.getSession().setAttribute("knowledgetype",list);

                List<Knowledge> knowledges = knowledgeService.listEntity();
                request.getSession().setAttribute("knowledges",knowledges);
            }
        }
        return "login";
    }

    @RequestMapping(value = "welcome")
    public String welcome(){
        return "welcom";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletResponse response){
        response.addCookie(new Cookie("lastUser",null));
        return "login";
    }
}
