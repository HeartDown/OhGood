<%@ page import="manager.entity.KnowledgeType" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: zhangheng
  Date: 2017/3/6
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>upload knowledge</title>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="${staticPath}/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${staticPath}/static/css/animate.css" rel="stylesheet">
    <link href="${staticPath}/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link rel="shortcut icon" href="${staticPath}/static/favicon.ico">
    <link rel="bookmark" href="${staticPath}/static/favicon.ico"/>
</head>
<body>
<script type="javascript" src="${staticPath}/static/js/welcome.js"></script>
<script src="${staticPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${staticPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${staticPath}/static/js/plugins/layer/layer.min.js"></script>
<script src="${staticPath}/static/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="${staticPath}/static/js/contabs.js"></script>
<!-- 第三方插件 -->
<script src="${staticPath}/static/js/plugins/pace/pace.min.js"></script>
<script>
    $().ready(function(){
        //按回车时事件
        $(document).keydown(function(event){
            var key = window.event? event.keyCode:event.which;
            if(key == 13){
                $("#validationFrom").submit();
            }
        });

        $("#upload-btn").bind("click",function(){
            $("#validationFrom").submit();
        });

        $("#validationFrom").validate({
            rules: {
                title: {
                        required : true,
                        minlength : 2,
                        maxlength : 32
                },
                content: {
                    required : true,
                    minlength : 2,
                }
            },
            messages : {
                title : {
                    required : "请输入标题",
                    minlength : "标题长度至少为{0}个字符",
                    maxlength : "标题长度至多为{0}个字符"
                },
                content : {
                    required : "请输入密码",
                    minlength : "内容长度至少多于{0}个字符",
                }
            },
            submitHandler : function(form) {
                var formData = new FormData($("#validationFrom")[0])
                $.ajax({
                    dataType : "json",
                    url : getContextPath() + "/uploadknowledge",
                    type : "post",
                    contentType: false,
                    processData: false,
                    data : {
                        title : $('#title').val(),
                        content : $('#content').val(),
                        knowledgetype:$('#type-div input[name="knowledgetype"]:checked ').val()
                    },
                    complete : function(response) {
                        var result = response.responseJSON;
                        if (result.code == 1) {
                            alert(result.message);
                            document.location.href = getContextPath() + "/welcom";
                        } else if (result.code == -1) {
                            parent.layer.msg(result.message);
                        } else if (result.code == -2) {
                            parent.layer.msg(result.message);
                        } else if (result.code == -3) {
                            parent.layer.msg(result.message);
                        } else {
                            parent.layer.msg(result.message);
                        }
                    }
                });
            },
        })


    })
</script>
<%
    HttpSession httpSession = request.getSession();
    List<KnowledgeType> list = (List<KnowledgeType>) httpSession.getAttribute("knowledgetype");
    Iterator<KnowledgeType> iterators = list.iterator();
%>
<form class="form-horizontal" action="#" method="post" id="validationFrom" enctype="multipart/form-data">
    <div class="form-group">
        <label for="title" class="col-sm-2 control-label" >title</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="title" name="title">
        </div>
    </div>
    <div class="form-group">
        <label for="textarea" class="col-sm-2 control-label">content</label>
        <div class="col-sm-10">
            <textarea class="form-control" rows="4" id="textarea" name="content"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="type-div" class="col-sm-2 control-label">content</label>
        <div class="btn-group" data-toggle="buttons" id="type-div">
            <%
                iterators = list.iterator();
                while (iterators.hasNext()){
                    KnowledgeType k = iterators.next();
            %>
            <label class="btn btn-primary">
                <input type="radio" autocomplete="off" name="knowledgetype" value="<%=k.getTypename()%>">
                <%=k.getTypename()%>
            </label>
            <% }%>
        </div>
    </div>
    <div class="form-group">
        <label for="type-div" class="col-sm-2 control-label">图片</label>
        <div class="col-sm-10">
            <input id="img" name="upload" type="file">
        </div>
    </div>
    <div class="form-group">
        <label for="type-div" class="col-sm-2 control-label">知识附件</label>
        <div class="col-sm-10">
            <input id="fujian" name="upload" type="file">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" id="upload-btn">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>
