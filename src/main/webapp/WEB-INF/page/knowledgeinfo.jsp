<%@ page import="manager.entity.Think" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhangheng
  Date: 2017/3/16
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>more information of the knowledge</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${staticPath}/static/css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript">
        function clearText(field)
        {
            if (field.defaultValue == field.value) field.value = '';
            else if (field.value == '') field.value = field.defaultValue;
        }
    </script>
</head>
<body>
<div id="templatemo_content">

    <h1>${curknowledge.title}</h1>

    <p>${curknowledge.content} </p>

    <div class="cleaner_h20"></div>

    <h2>the image of the knowledge</h2>

    <div class="content_two_col margin_r10">

        <div class="image_wrapper_01">
            <span></span>
            <img src="${staticPath}/static/img/images/${curknowledge.imgpath}" alt="image" />
        </div>

        <h5>I have some word about the knowledge</h5>
        <ul>
            <% List<Think> list = (List<Think>) request.getAttribute("thinks");
                if (!list.isEmpty()){
                for (int i = 0; i < list.size(); i++) {
                    Think think = list.get(i);
            %>
            <li><%=think.getWord()%> date:<%=think.getThinkKey().getDate()%></li>
            <%}}%>
        </ul>
        <form action="/knowledge/think" method="post">
            <textarea rows="3" cols="3" name="myword" id="myword"></textarea>
            <input type="submit" id="submit_btn"/>
        </form>

        <p><a href="#">Details</a></p>
    </div>
    <div class="cleaner"></div>
</div> <!-- end of content -->
</body>
</html>