package manager.web.controller;

import manager.entity.User;
import manager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangheng on 2017/2/23.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "profile",method = RequestMethod.GET)
    public String profile(){
        return "admin/user/profile";
    }



}
