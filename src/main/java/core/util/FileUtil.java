package core.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by zhangheng on 2017/3/23.
 */
public class FileUtil {
    public static void transferTo(String  path, HttpServletRequest request) throws IOException {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest httpServletRequest = (MultipartHttpServletRequest) request;
            Iterator iterable = httpServletRequest.getFileNames();
            while (iterable.hasNext()){
                MultipartFile file = httpServletRequest.getFile(iterable.next().toString());
                if (file!=null){
                    //上传附件到指定目录下
                    file.transferTo(new File(path));
                }
            }
        }
    }
}
