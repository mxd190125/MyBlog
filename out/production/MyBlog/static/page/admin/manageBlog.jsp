<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理端</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <link rel="stylesheet" href="/static/css/home.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/home.css">
<%--    <link rel="stylesheet" href="/static/css/manageBlog.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/manageBlog.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <script src="/static/js/manageBlog.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/manageBlog.js"></script>
</head>
<body>
<%@include file="../head.jsp"%>
<%@include file="menuAdmin.jsp"%>
<div class="manageBlog-page">
    <div class="manageBlog-div">
        <table class="table table-bordered" style="text-align: center;">
            <caption class="center table-head" style="font-size: 25px; color: #90000a;">~ ~ ~ 帖子如下 ~ ~ ~</caption>
            <thead class="thead-head">
            <tr>
                <th class="center">序号</th>
                <th class="center">用户名</th>
                <th class="center">标题</th>
                <th class="center">发布时间</th>
                <th colspan="4" class="center">操作</th>
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
                            <!--                            <span><img class="photo3" src='${path}${user.getPhotoUrl()}'></span>-->
                            <span><label class="author-name"></label></span>
                            <span class="good-span"><a style="color: #FFB333"><img class="good-discuss" src="../../images/icon/good.png"><label class="good-num"></label></a></span>
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

</body>
</html>
