<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/info.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/info.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/info.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/info.js"></script>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="menu.jsp"%>
<div class="info-page">
    <div class="photo-div">
        <div id="imgPreview">
            <img src="../images/icon/upload-images.png" id="preViewImg" />
            <input type="file" id="myfile" onchange="preView(this)" accept="image/*">
        </div>
        <button type="submit" class="subPhoto" onclick="subPhoto()">上传头像</button>
    </div>
    <div class="info-div">
        <label class="str">用户名：</label><input class="form-control input" type="text" value="mxd190125" disabled>
        <label class="str">密码：</label><input class="form-control input" id="password" type="text" value="">
        <button type="submit" onclick="modify()" class="btn subBtn">重置密码</button>
    </div>
</div>
</body>
</html>
