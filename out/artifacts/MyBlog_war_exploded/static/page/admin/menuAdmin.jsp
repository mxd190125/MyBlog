<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理端</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/menuAdmin.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/menuAdmin.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="menuAdmin-page">
    <div class="self">
<%--        <span class="self-span"><img class="self-photo" src="${path}${photoUrl}"></span>--%>
        <span class="self-span"><img class="self-photo" src="http://121.196.145.152:8080/MyBlog/${photoUrl}"></span>
        <span><label class="name">${username}</label></span>
    </div>
    <div>
        <span id="menu-left" class="menuAdmin"><a href="${path}static/page/admin/manageUser.jsp"><img class="menuAdminIcon" src="${path}static/images/icon/manage1.png"><label class="menuAdminName">管理用户</label></a></span>
        <span id="menu-right" class="menuAdmin"><a href="${path}static/page/admin/manageBlog.jsp"><img class="menuAdminIcon" src="${path}static/images/icon/manage2.png"><label style="margin-top: 10px" class="menuAdminName">管理帖子</label></a></span>
    </div>
</div>
</body>
</html>
