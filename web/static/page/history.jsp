<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>软萌龙窝 | 博客</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/home.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/home.css">
<%--    <link rel="stylesheet" href="/static/css/history.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/history.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/history.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/history.js"></script>
    <style type="text/css">
        body{
            background-color: #FFEEABD1;
        }
        #history-page{
            float: left;
            margin-top: 20px;
            margin-left: 20px;
        }
        .history-div{
            width: 800px;
            /*width: 400px;*/
        }
        .center{
            text-align: center;
            vert-align: middle;
        }
        .thead-head{
            background-color: #90000a;
            color: white;
            font-size: 20px;
        }
        .opt-btn{
            width: 80px;
            height: 30px;
        }
        .content-body{
            color: #90000a;
            font-size: 18px;
        }
    </style>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="menu.jsp"%>
<label id="userId" style="display: none;">${user.getId()}</label>
<div id="history-page">
    <div class="history-div">
        <table class="table table-bordered" style="text-align: center;">
            <caption class="center table-head" style="font-size: 25px; color: #90000a;">~ ~ ~ 您的博客 ~ ~ ~</caption>
            <thead class="thead-head">
            <tr>
                <th class="center">序号</th>
                <th class="center">标题</th>
                <th class="center">发布时间</th>
                <th colspan="2" class="center">操作</th>
            </tr>
            </thead>
            <tbody class="content-body">

            </tbody>
        </table>
    </div>

    <!-- 模态弹出窗内容 -->
    <div class="modal" id="mymodal">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 800px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <div class="invitation">
                        <div class="baseInfo">
                            <span><img class="photo3" src='http://121.196.145.152:8080/${user.getPhotoUrl()}'></span>
                            <span><label class="author-name"></label></span>
                            <span class="good-span"><a style="color: #FFB333"><img class="good-discuss" src="../images/icon/good.png"><label class="good-num"></label></a></span>
                        </div>
                        <div class='content'></div>
                        <div class="images"></div>
                        <label class="sub-time" style="color: #27c85e"></label>
                        <div class="discuss">
                            <div class="pl-div2">
                                <p><label class="dis-name"></label></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
