<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/home.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/home.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/home.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/home.js"></script>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="menu.jsp"%>
<%--保存我的ID和名字--%>
<label class="my-userId" style="display: none;">${user.getId()}</label>
<label class="my-name" style="display: none;">${username}</label>
<div class="homePage">
    <c:if test="${!empty blogs}">
        <c:forEach items="${blogs}" var="blog" varStatus="index">
            <div class="invitation">
                <div class="baseInfo">
<%--                    <span><img class="photo3" src="${path}${blog.getBlogerPhotoUrl()}"></span>--%>
                    <span><img class="photo3" src="http://121.196.145.152:8080/${blog.getBlogerPhotoUrl()}"></span>
                    <%--保存博客ID--%>
                    <label class="blog-id" style="display: none;">${blog.getId()}</label>
                    <span><label class="author-name">${blog.getBlogerName()}</label>&nbsp;&nbsp;&nbsp;<label class="blog-title">${blog.getTitle()}</label></span>
                    <!--精华-->
                    <c:if test="${blog.getIsGood() == 1}">
                        <span><img src="${path}static/images/icon/goodBlog3.png"></span>
                    </c:if>
                    <span class="good-span"><a style="color: #FFB333"><img class="good-discuss" src="${path}static/images/icon/good.png"><label class="good-num">${blog.getGoodNum()}</label></a></span>
                    <!--置顶-->
                    <c:if test="${blog.getIsTop() == 1}">
                        <span class="good-blog" style="float: right;"><img style="margin-right: 80px;" src="${path}static/images/icon/top2.png"></span>
                    </c:if>
                </div>
                <div class="content">
                    ${blog.getContent()}
                </div>
                <div class="images">
                    <c:set var="imageList" value="${blog.getImages()}"/>
                    <c:forEach var="img" items="${fn:split(imageList, '#')}" >
<%--                        <img class="upImage" src="${path}${img}">--%>
                        <img class="upImage" src="http://121.196.145.152:8080/${img}">
                    </c:forEach>
                </div>
                <label style="color: #27c85e">${blog.getSubTime()}</label>
                <div class="discuss">
                    <div class="pl-div">
                        <img style="width: 35px" src="${path}static/images/icon/pl-2.png">
                        <input class="form-control pl-input" style="width: 870px;display: inline;" type="text" placeholder="您想说点什么？">
                        <button type="submit" class="btn sure-btn">确定</button>
                    </div>
                    <div class="pl-div2">
                        <c:forEach var="discuss" items="${blog.getDiscusses()}">
                            <p><label class="dis-name">${discuss.getSubTime()} ${discuss.getDiscusserName()}：</label>${discuss.getContent()}</p>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty blogs}">
        <h1>抱歉！ 暂无博客！</h1>
    </c:if>
</div>
</body>
</html>