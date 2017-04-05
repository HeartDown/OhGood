<%@ page import="manager.entity.KnowledgeType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="manager.entity.Knowledge" %>
<%@page contentType="text/html;" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    //    String staticPath = DPUtil.getDynamicProperty(MainConstant.DP_STATIC_PATH);
    String staticPath = request.getContextPath();
    request.setAttribute("staticPath", staticPath);
%>
<c:set var="staticPath" value="${staticPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>知识源</title>
    <!-- Custom Theme files -->
    <link href="${staticPath}/static/css/patterns/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Konstructs Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<%
    HttpSession httpSession = request.getSession();
    List<KnowledgeType> list = (List<KnowledgeType>) httpSession.getAttribute("knowledgetype");
    KnowledgeType curtype = (KnowledgeType) httpSession.getAttribute("curtype");
    List<Knowledge> knowledges = (List<Knowledge>) httpSession.getAttribute("knowledges");
    Iterator<KnowledgeType> iterators = list.iterator();
    Iterator<Knowledge> knowledgesIterators = knowledges.iterator();
%>
<body>
<!-- header-section-starts -->
<div class="header">
    <div class="container">
        <div class="logo">
            <a href="#"><h1>知识库</h1></a>
        </div>
        <div class="pages">
            <ul>
                <li><a class="active" href="#">知识专家</a></li>
                <li><a href="3dprinting.html">知识小组</a></li>
            </ul>
        </div>
        <div class="navigation">
            <ul>
                <li><a href="#">关于系统</a></li>
                <li><a class="active" href="#">个人关注</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--  中间标签 -->
<div class="container">
    <div class="header-bottom">
        <div class="type">

            <h5>所有分类</h5>
        </div>
        <span class="menu"></span>
        <div class="list-nav">
            <ul>
                <%
                    iterators = list.iterator();
                    while (iterators.hasNext()){
                        KnowledgeType k = iterators.next();
                %>
                <li><a href="#"><%=k.getTypename()%></a></li>|
                <% }%>
            </ul>
        </div>
        <!-- script for menu -->
        <script>
            $( "span.menu" ).click(function() {
                $( ".list-nav" ).slideToggle( "slow", function() {
                    // Animation complete.
                });
            });
        </script>
        <!-- script for menu -->

        <div class="clearfix"></div>
    </div>
</div>
<!--  中间内容 -->
<div class="container">
    <div class="content">
        <!-- 左侧知识内容显示 -->
        <div class="col-md-7 content" style="width: 100%">
            <%
                Iterator<KnowledgeType> iterator2 = list.iterator();
                if (curtype!=null){
                    knowledgesIterators = knowledges.iterator();
                    while (knowledgesIterators.hasNext()){
                        Knowledge knowledge = knowledgesIterators.next();
                        if (knowledge.getType().equals(curtype.getTypename())){
            %>
            <div class="article">
                <h5 class="head"><%=null!=curtype.getTypename()? curtype.getTypename():"其他"%></h5>
                <a class="title" style="height:80px;font-size:4em" href="/knowledge/think?title=<%=knowledge.getTitle()%>">title:<%=knowledge.getTitle()%></a>
                <a href="single.html"><img src="${staticPath}/static/img/images/<%=knowledge.getImgpath()%>" alt="" /></a>
                <p style="height:80px;font-size:2em">content:<%=knowledge.getContent()%></p>
                <p></p>
            </div>
            <%}}}
                else {
                while (iterator2.hasNext()){
                    knowledgesIterators = knowledges.iterator();
                    KnowledgeType knowledgeType = iterator2.next();
                    while (knowledgesIterators.hasNext()){
                        Knowledge knowledge = knowledgesIterators.next();
                        if (knowledge.getType().equals(knowledgeType.getTypename())){
            %>
            <div class="article">
                <h5 class="head"><%=null!=knowledgeType.getTypename()? knowledgeType.getTypename():"其他"%></h5>
                <a class="title" style="height:80px;font-size:4em" href="/knowledge/think?title=<%=knowledge.getTitle()%>">title:<%=knowledge.getTitle()%></a>
                <a href="single.html"><img src="${staticPath}/static/img/images/<%=knowledge.getImgpath()%>" alt="" /></a>
                <p style="height:80px;font-size:2em">content:<%=knowledge.getContent()%></p>
                <p></p>
            </div>
            <%}}}}%>
        </div>
    </div>
</div>
<!--  底部注释 -->
<div class="footer">
    <div class="footer-top">
        <div class="container">
            <div class="col-md-3 footer-links">
                <h4>其他信息</h4>
                <a href="#">Design a creative Blog</a>
            </div>
            <div class="col-md-3 footer-links span_66">
                <a href="#">Flat product website in Photoshop</a>
                <a href="#">Design a creative Blog</a>
                <a href="#">Design a iPad Website </a>
            </div>
            <div class="col-md-3 footer-links">
                <h4>Relevant Articles</h4>
                <a href="#">Design a creative Blog</a>
                <a href="#">Design a iPad Website</a>
                <a href="#">Single Page sales portfolio </a>
                <a href="#">Flat product website</a>
                <a href="#">Design a creative Blog</a>
            </div>
            <div class="col-md-3 footer-links">
                <h4>Other pages and things</h4>
                <a href="#">Blaz Robar</a>
                <a href="#">Nick Toranto</a>
                <a href="#">Joisp Kelava</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <div class="copyrights">
                <p>Konstructs © 2015 All rights reserved | Template by  <a href="http://w3layouts.com">  W3layouts</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>