<%@page contentType="text/html;" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    //    String staticPath = DPUtil.getDynamicProperty(MainConstant.DP_STATIC_PATH);
    String staticPath = request.getContextPath();
    request.setAttribute("staticPath", staticPath);
%>
<c:set var="staticPath" value="${staticPath}"/>
<html lang="en">
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
    <link href="//fonts.googleapis.com/css?family=Muli:300,400" rel="stylesheet">
    <!-- /fonts -->
    <!-- css -->
    <link href="${staticPath}/static/css/demo/style.css" rel="stylesheet" type='text/css' media="all" />
    </head>
<body>
<script src="${staticPath}/static/js/validator.min.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-camera"></span>
                <span class="icon-barcode"></span>
            </button>
            <a class="navbar-brand" href="#">知识管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">注册</a></li>
                <li><a href="/loginUser">已有账号？点击登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<h1 class="w3ls">Register Knowledge System Form</h1>
<div class="content-agileits">
    <form action="#" method="post" data-toggle="validator" role="form" id="validationRegisterFrom">
        <div class="form-group agileits w3layouts w3">
            <label for="name" class="control-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name" data-error="Enter Your Name" required>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group w3l agileinfo wthree w3-agileits">
            <label for="email" class="control-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email" data-error="This email address is invalid" required>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group agileinfo wthree w3-agileits agile">
            <label for="Phone" class="control-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" data-error="Enter Your Phone Number" required>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group agile agileits-w3layouts w3-agile">
            <label for="password" class="control-label">Password</label>
            <div class="form-inline row">
                <div class="form-group col-sm-6 agileits-w3layouts">
                    <input type="password" data-minlength="6" class="form-control" id="password" name="password" placeholder="Password" required>
                    <div class="help-block">Minimum of 6 characters</div>
                </div>
                <div class="form-group col-sm-6 w3-agile">
                    <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" data-match="#password" data-match-error="Whoops, these don't match" placeholder="Confirm Password" required>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-lg" id="registButton">Submit</button>
        </div>
    </form>
</div>
<p class="copyright-w3ls"> 知识管理系统用户注册 </p>

</body>
</html>