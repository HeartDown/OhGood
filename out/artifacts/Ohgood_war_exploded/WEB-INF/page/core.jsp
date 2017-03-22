<%--
  User: yongjie.teng
  Date: 16-11-15
  Time: 下午5:32
  主要用来定义和引用一些通用的数据
--%>
<%@ page import="core.constant.MainConstant" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//    String staticPath = DPUtil.getDynamicProperty(MainConstant.DP_STATIC_PATH);
    String staticPath = request.getContextPath();
    request.setAttribute("staticPath", staticPath);
%>
<c:set var="staticPath" value="${staticPath}"/>