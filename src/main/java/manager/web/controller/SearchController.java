package manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangheng on 2017/3/3.
 */
@Controller
public class SearchController {

    //查询知识
    @RequestMapping(name = "search", method = RequestMethod.POST)
    public String search(HttpServletResponse httpServletResponse, @RequestParam String filterCondition){


        return "#";
    }
}
