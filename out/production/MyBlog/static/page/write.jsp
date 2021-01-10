<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/write.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/write.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/write.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/write.js"></script>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="menu.jsp"%>
<div class="write-div">
    <div><button class="btn write-btn" style="background-color: #90000a;color: white;margin-bottom: 5px;" onclick="subBlog()" type="submit">发布</button></div>
    <label class="write-lable">您的标题</label>
    <input class="form-control write-title-input" id="title" style="width: 400px" placeholder="请输入标题...">
    <label class="write-lable">正文</label>
    <textarea class="form-control write-content-text" id="content" style="width: 400px;height: 300px" placeholder="请输入内容..."></textarea>
    <label class="write-lable">请选择配图：</label>
    <div class="upImage-div">
        <span class="upImage-span">
<!--            <img src="../images/icon/default-head.png" class="upImage-image">-->
        </span>
        <span class="upImage-span2">
            <img src="../images/icon/upload-images.png" class="upImage-upload">
            <input type="file" multiple="multiple" id="upload-images" onchange="upload()" accept="image/*">
        </span>
    </div>

</div>
</body>
</html>
