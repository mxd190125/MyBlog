<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <meta http-equiv="Content-Typecontent=text/html"; charset="UTF-8" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/head.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/head.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="headPage">
    <div>
        <label class="role-name sname">
<%--            <c:out value="${role}"></c:out>--%>
            <c:if test="${role eq 'user'} ">
                用户端
            </c:if>
            <c:if test="${role eq 'admin'}">
                管理员端
            </c:if>
        </label>
        <label class="title sname">
            欢迎来到623贴吧
        </label>
        <a class="out-label sname" href="${path}logOut"><label>注销</label></a>
    </div>
</div>
</body>
</html>
