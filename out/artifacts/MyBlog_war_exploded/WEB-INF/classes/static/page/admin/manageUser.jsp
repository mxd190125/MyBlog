<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理端</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/manageUser.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/manageUser.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/manageUser.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/manageUser.js"></script>
</head>
<body>
<%@include file="../head.jsp"%>
<%@include file="menuAdmin.jsp"%>
<div class="manageUser-div">
    <table class="table table-bordered" style="text-align: center;">
        <caption class="center table-head" style="font-size: 25px; color: #90000a;">~ ~ ~ 用户如下 ~ ~ ~</caption>
        <thead class="thead-head">
        <tr>
            <th class="center">序号</th>
            <th class="center">用户名</th>
            <th class="center">密码</th>
            <th class="center">邮箱</th>
            <th class="center">注册时间</th>
            <th class="center">操作</th>
        </tr>
        </thead>
        <tbody class="content-body">

        </tbody>
    </table>
</div>
</body>
</html>
