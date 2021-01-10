<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/menu.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/menu.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="menuPage">
    <div class="self">
<%--        <span class="self-span"><img class="self-photo" src="${path}${photoUrl}"></span>--%>
        <span class="self-span"><img class="self-photo" src="http://121.196.145.152:8080/${photoUrl}"></span>
        <span><label class="name">${username}</label></span>
    </div>
    <div>
        <span class="menu"><a href="${path}static/page/info.jsp"><img class="menuIcon" src="${path}static/images/icon/self-info.png"><label class="menuName">个人信息</label></a></span>
        <span class="menu"><a href="${path}static/page/history.jsp"><img class="menuIcon" src="${path}static/images/icon/history.png"><label style="margin-top: 15px" class="menuName">历史记录</label></a></span>
        <span class="menu"><a href="${path}static/page/write.jsp"><img class="menuIcon" src="${path}static/images/icon/write.png"><label class="menuName">写作</label></a></span>
        <span class="menu"><a href="${path}requestBlog"><img class="menuIcon" src="${path}static/images/icon/invitation.png"><label class="menuName">浏览帖子</label></a></span>
    </div>
</div>
</body>
</html>
