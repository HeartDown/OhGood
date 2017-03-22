<%@ page import="manager.entity.User" %>
<%@ page import="manager.entity.KnowledgeType" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>welcom</title>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="${staticPath}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${staticPath}/static/css/animate.css" rel="stylesheet">
    <link href="${staticPath}/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link rel="shortcut icon" href="${staticPath}/static/favicon.ico">
    <link rel="bookmark" href="${staticPath}/static/favicon.ico"/>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<script type="javascript" src="${staticPath}/static/js/welcome.js"></script>
<script src="${staticPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${staticPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${staticPath}/static/js/plugins/layer/layer.min.js"></script>
<script src="${staticPath}/static/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="${staticPath}/static/js/contabs.js"></script>
<!-- 第三方插件 -->
<script src="${staticPath}/static/js/plugins/pace/pace.min.js"></script>
<%
    HttpSession httpSession = request.getSession();
    List<KnowledgeType> list = (List<KnowledgeType>) httpSession.getAttribute("knowledgetype");
    User curuser = (User)httpSession.getAttribute("CurrentUser");
    Iterator<KnowledgeType> iterators = list.iterator();
%>
<div id="wrapper">
<!-- 顶部导航-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active" id="up-menu"><a href="/knowledge/source">知识源 <span class="sr-only">(current)</span></a></li>
                <li ><a class="active" href="/knowledge/think">知识评价</a></li>
                <li class="dropdown">
                    <a href="/knowledge/type" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">知识分类 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <%     while (iterators.hasNext()){
                            KnowledgeType k = iterators.next();
                        %>
                        <li><a href="/knowledge/sourceWithType?type=<%=k.getTypename()%>"><%=k.getTypename()%></a></li>
                        <li role="separator" class="divider"></li>
                        <% }%>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" action="/search" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="filterCondition" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-primary" data-loading-text="正在查询" autocomplete="off" id="search-btn">查询</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">关注</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">我的收藏</a></li>
                        <li><a href="#" class="J_menuItem">我的资料</a></li>
                        <li><a href="#">更改用户</a></li>
                        <li role="separator" class="divider"></li>
                        <li><button type="button" class="btn btn-label" id="quitLogin-btn">退出登录</button></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- 左侧导航-->
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <span><img alt="image" class="img-circle" src="${staticPath}/static/img/profile_small.jpg" /></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear">
                                <span class="block m-t-xs"><strong class="font-bold">${CurrentUser.username}</strong></span>
                                <%--<span class="text-muted text-xs block"><c:forEach var="role" items="${CurrentUser.roles}" begin="0" end="0" >${role.roleValue}</c:forEach><b class="caret"></b></span>--%>
                            </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="user/profile">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                        </li>
                        <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/logout">安全退出</a>
                        </li>
                    </ul>
                </div>
                <div class="logo-element">T</div>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">主页</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a class="J_menuItem" href="/welcome" data-index="0">全部知识</a>
                    </li>
                </ul>
                <%if (curuser.getUsername().equals("zhangheng")){%>
                <ul class="nav nav-second-level">
                    <li>
                        <a class="J_menuItem" href="/typemanager" data-index="0">管理知识类型</a>
                    </li>
                </ul>
                <ul class="nav nav-second-level">
                    <li>
                        <a class="J_menuItem" href="/usermanager" data-index="0">管理用户</a>
                    </li>
                </ul>
                <%}%>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">全部分类</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <%
                        iterators = list.iterator();
                        while (iterators.hasNext()){
                        KnowledgeType k = iterators.next();
                    %>
                    <li>
                        <a class="J_menuItem" href="/knowledge/sourceWithType?type=<%=k.getTypename()%>" data-index="0"><%=k.getTypename()%></a>
                    </li>
                    <% }%>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-home"></i>
                    <span class="nav-label">更多</span>
                    <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a class="J_menuItem" href="dashboard" data-index="0">我的关注</a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="dashboard" data-index="0">经典知识</a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="/knowledge/uploadknowledge" data-index="0">上传知识</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

    <!-- 右侧导航 -->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="${ctx}/dashboard">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${ctx}/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>

        <!-- 第一栏导航-->
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${staticPath}/knowledge/source" frameborder="0" data-id="${ctx}/dashboard" seamless></iframe>
        </div>

        <div class="footer">
            <div class="pull-right">&copy; 张恒- <a href="#" target="_blank">知识管理系统</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>