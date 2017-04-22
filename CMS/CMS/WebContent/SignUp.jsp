<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<title>注册页面</title>

<meta name="description" content="冷知识">
<meta name="keywords" content="">
<meta name="robots" content="noodp">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script>
(function(docs) {
  if(navigator.userAgent.indexOf('iPad') != -1) {
    docs.getElementById("viewport").setAttribute("content", "width=1100");
  } else {
    docs.getElementById("viewport").setAttribute("content", "width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no");
  }
}(document));
</script>


<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="css/login.css">
<!-- <link rel="stylesheet" href="css/style.css"> -->
</head>
<body calss="top">
<div id="wrapper">
<div class="login">
  <div class="login-navs">
    <div class="login-navs-logo"><a href="index.html">
    <img src="asset/img/common/login-logo.png" alt="97gun"></a>
    <h3 class="login-title">CMS&nbsp;Sign&nbsp;Up</h3>
    </div>
    <ul class="login-tab">
      <li><a href="Login.jsp"  >登&nbsp;录</a></li>
      <li><a href="" class="active" >注&nbsp;册</a></li>
    </ul>
  </div>
  <form action="Sign" class="login-form" method="post">
    <input class="login-input login-username" type="text" name="username" id="" placeholder="账户">
    <input class="login-input login-code" type="text" name="role" id="" placeholder="权限号，默认2">
    <input class="login-input login-password" type="password" name="password" id="" placeholder="密码">
   <!-- <input class="login-input login-confirm-password" type="password" name="" id="" placeholder="确认密码">
      -->
    <div class="login-check">
      <div class="login-check-sub">
        <input type="checkbox" name="" id="">
        <label for="">我已阅读并同意<a href="">《XX条款》</a></label>
        <input class="login-button  login-button-commit" type="submit" name="" id="" value="注&nbsp;册">
        <div class="">
              <a href="Login.jsp" class="toggle-form">
              <div class="">
              </div>
              已有帐户？点击登录</a>
            </div>
      </div>
    </div>
  </form>

</div>

<footer class="footer">
  <div class="copyright">COPYRIGHT &copy; SAKUZAN. ALL RIGHTS RESERVED.</div>
</footer>

</div>


<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="asset/lib/jquery/jquery.lib.js"></script>
<script src="asset/lib/velocity/velocity.min.js"></script>
<script src="asset/lib/jquery.browser.min.js"></script>
<script src="asset/lib/bxslider/jquery.bxslider.min.js"></script>
<script src="asset/js/base.js"></script>
<script src="js/index.js"></script>
<script src="asset/js/ga.js"></script>
</body>
</html>