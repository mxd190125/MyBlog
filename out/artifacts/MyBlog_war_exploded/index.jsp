<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%--    <link rel="stylesheet" href="/static/css/index.css">--%>
    <link rel="stylesheet" href="http://121.196.145.152:8080/MyBlog/static/css/index.css">
<%--    <script src="/static/js/index.js"></script>--%>
    <script src="http://121.196.145.152:8080/MyBlog/static/js/index.js"></script>
  </head>

  <div id="root">
    <button style="margin-bottom: 12px; font-size: 15px;font-weight: bold" class="btn btn-info" id="loginChange">登录</button>
    <button style="margin-bottom: 12px; font-size: 15px;font-weight: bold" class="btn" id="registerChange">注册</button>
    <div class="change" id="loginDiv">
      <form action="${path}login" id="login" method="post">
        <input type="text" name="username" placeholder="请输入账号" class="form-control input1"><br>
        <input type="password" name="password" placeholder="请输入密码" class="form-control input1"><br>
        <input type="text" name="code" placeholder="请输入验证码" class="form-control input2">
        <span class="code"><img src="${path}validCode"></span>
        <br>
        <div class="forgetPass"><a style="color: white">忘记密码</a></div>
        <button type="submit" class="btn btn-success subBtn" >登录</button>
      </form>
    </div>
    <div class="change" id="registerDiv">
      <form action="${path}register" id="register" method="post">
        <input type="text" name="username" placeholder="请输入账号" class="form-control input1"><br>
        <input type="password" name="password" placeholder="请输入密码" class="form-control input1"><br>
        <input type="text" name="email" placeholder="请输入邮箱" class="form-control input1"><br>
        <button type="submit" class="btn btn-success subBtn" >注册</button>
      </form>
    </div>
    <div>
      <p class="message">${error}</p>
    </div>
  </div>
  </body>
</html>
