<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

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
    <h3 class="login-title">CMS&nbsp;Login</h3>
    </div>
    <ul class="login-tab">
      <li><a href="" class="active" >登&nbsp;录</a></li>
      <li><a href="SignUp.jsp" >注&nbsp;册</a></li>
    </ul>
  </div>
  <form action="Login" class="login-form">
    <input class="login-input login-username" type="text" name="username" id="" placeholder="账户">
    
    <input class="login-input login-password" type="password" name="password" id="" placeholder="密码">
    <div class="login-check">
      <div class="login-check-sub">
        <input type="checkbox" name="" id="">
        <label for="">记住密码<a href=""></a></label>
        <input class="login-button  login-login" type="submit" name="" id="" value="登&nbsp;录">
        <div class="">
              <a href="SignUp.jsp" class="toggle-form">
              <div class="">
              </div>
              还没注册帐户？点击注册</a>
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
<script type="text/javascript">
var wait=60;
function time(o) {
  if (wait == 0) {
      o.removeAttribute("disabled");
      o.value="免费获取验证码";
      wait = 60;
  } else {
      o.setAttribute("disabled", true);
      o.value="重新发送(" + wait + ")";
      wait--;
      setTimeout(function() {
          time(o)
      },
      1000)
  }
}
document.getElementById("btn").onclick=function(){time(this);}
</script>

</body>
</html>