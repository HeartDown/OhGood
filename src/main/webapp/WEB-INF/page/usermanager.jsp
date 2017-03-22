<%@ page import="java.util.List" %>
<%@ page import="manager.entity.KnowledgeType" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: zhangheng
  Date: 2017/3/19
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Document</title>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <title>类型维护</title>
</head>
<body>
<table class="table table-bordered">
    <tr>
        <th>用户名</th>
        <th>父类型名称</th>
        <th>操作</th>
    </tr>
    <%
        List<KnowledgeType> list = (List<KnowledgeType>) request.getAttribute("alltype");
        if (!list.isEmpty()){
            Iterator<KnowledgeType> iterator=list.iterator();
            while (iterator.hasNext()){
                KnowledgeType type =iterator.next();
    %>

    <tr>
        <td><%=type.getTypename() %></td>
        <td><%=type.getParentid() %></td>
        <td><a href="deletetype?curdeletetype=<%=type.getId() %>">删除</a></td>
    </tr>
    <%
            }}
    %>
</table>

</body>
</html>
