package core.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import core.support.CustomDateEditor;
import manager.dto.ResultCode;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhangheng on 2017/3/2.
 */
public class BaseController {
    public void writeJSON(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
    }
    protected void writeJSON(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        System.out.println("已写入response"+json);
    }

    protected void writeToJSON(HttpServletResponse response,Object obj) throws IOException {
        response.getWriter().write(JSON.toJSONString(obj,SerializerFeature.WriteMapNullValue));
    }
}
