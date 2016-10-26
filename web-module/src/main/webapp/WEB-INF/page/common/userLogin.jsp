<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/23
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
  <%--<meta charset="UTF-8">--%>
  <%--<title>登录页面</title>--%>

  <%--<link rel="stylesheet" type="text/css" href="/asset/css/commons/userLogin.css"/>--%>

<%--</head>--%>

<%--<body>--%>

<%--<!--登录页面-->--%>
  <%--<div class="lay" id="loginwrap">--%>
    <%--<div class="loginwrap">--%>
      <%--<h2>登录<span class="close"></span></h2>--%>
      <%--<ul>--%>
        <%--<li>--%>
          <%--<input type="text" id="login_name" name="phone" placeholder="手机号" maxlength="11" datatype="m" errormsg="错误的手机格式" sucmsg="&nbsp;"/>--%>
          <%--<label class="error_info error_info_tel"></label>--%>
        <%--</li>--%>
        <%--<li>--%>
          <%--<input type="password" id="login_pwd" name="password" placeholder="密码" datatype="*5-18" errormsg="请输入5-18位密码" sucmsg="&nbsp;"/>--%>
          <%--<label class="error_info error_info_pwd"></label>--%>
        <%--</li>--%>
        <%--<li>--%>
          <%--<input type="button" id="log_submit" value="登录" class="btn-green">--%>
        <%--</li>--%>
        <%--<li class="find"><a href="javascript:void(0);" id="pass"> 找回密码</a>/<a href="javascript:void(0);" class="col-72 reg_btn"> 快速注册</a></li>--%>
      <%--</ul>--%>
    <%--</div>--%>
  <%--</div>--%>

<%--</body>--%>
<%--<script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>--%>
<%--<script type="text/javascript" src="/asset/js/globalUtil.js"></script>--%>
<%--<script type="text/javascript" src="/asset/js/mw/loginRegister.js"></script>--%>
<%--</html>--%>
<!DOCTYPE html>
<%--<%@page import="java.net.URLDecoder"%>--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
  <%--String login_name = "";--%>
  <%--String login_pwd = "";--%>
  <%--String remember_me = "";--%>
  <%--Cookie[]cookies = request.getCookies();--%>
  <%--//判断cookie是否为null，且长度是否小于1--%>
  <%--if(cookies!=null && cookies.length>0){--%>
    <%--for(int i=0;i<cookies.length;i++){--%>
      <%--Cookie cookie = cookies[i];--%>
      <%--if("login_name".equals(cookie.getName())){--%>
        <%--login_name = URLDecoder.decode(cookie.getValue(), "UTF-8");--%>
        <%--remember_me = "checked";--%>
      <%--}--%>
      <%--if("login_pwd".equals(cookie.getName())){--%>
        <%--login_pwd = cookie.getValue();--%>
      <%--}--%>
    <%--}--%>
  <%--}else{--%>
    <%--remember_me = "";--%>
  <%--}--%>
<%--%>--%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="Miaojie Zhang">
  <meta name="description" content="Mr Water 登陆页面">
  <title>登陆兴趣金融</title>
  <!--<link rel="stylesheet" type="text/css" media="screen" href="../plugs/bootstrap-3.3.5-dist/css/bootstrap.min.css">-->
  <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/mrwater.css">
  <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/login.css">
  <link rel="stylesheet" type="text/css" media="screen" href="/plugs/vegas/vegas.min.css">
  <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/common.css"/>
  <link rel="stylesheet" type="text/css" media="screen" href="/asset/css/commons/common.css"/>
  <style>
    body {
      background: url("/asset/img/login/login-bg.svg");
      background-repeat: no-repeat;
      background-position: center center;
      background-color: #1B162F;
    }
  </style>
</head>

<body>
<!-- navigation bar -->
<div class="mw-login-topbar">
  <div class="login-topbar-nav">
    <div class="topbar-nav-inner">
      <div class="container">
        <!-- navigator -->
        <ul class="nav">
          <li class="nav-home">
            <a href="#">
              <span class="mr-logo">兴趣金融</span>
              <%--<span>主页</span>--%>
            </a>
          </li>
          <li style="float: right">
            <a href="#">
              <span>关于我们</span>
            </a>
          </li>
        </ul>
        <%--<ul>--%>
          <%--<li><a href="#"><span>关于我们</span></a></li>--%>
        <%--</ul>--%>
      </div>
    </div>
  </div>
</div>
<!-- main body -->
<div class="mw-login-wrap">
  <div class="mw-login-wrap-inner">
    <div class="login-wrap-container">
      <div class="login-wrap-left">
        <div class="login-poster">
          <!--<h1>耐得住寂寞,才能守得住繁华!</h1>-->
          <h1>欢迎来到兴趣金融！</h1>
          <!--<p>耐得住寂寞,才能守得住繁华!</p>-->
          <p>
            但凡成功之人，往往都要经历一段没人支持、没人帮助的黑暗岁月，
            而这段时光，恰恰是沉淀自我的关键阶段。犹如黎明前的黑暗，捱过去，天也就亮了。
          </p>
        </div>
      </div>
      <div class="login-wrap-right">
        <!-- signin -->
        <div class="login-frame">
          <%--<form action="" method="post" class="login-form">--%>
          <div class="login-form">
            <div class="username-field">
              <input id="login_name" type="text" placeholder="手机、邮件地址或用户名" class="text-input">
            </div>
            <table class="fixed-table">
              <tbody>
              <tr>
                <td class="flex-table-primary"><input id="login_pwd" class="login-password" placeholder="密码" type="password"></td>
                <td class="flex-table-secondary"><button class="mr-btn mr-primary-btn" id="log_submit" >登陆</button></td>
              </tr>
              </tbody>
            </table>
            <div class="remember-forgot">
              <label class="remember">
                <input type="checkbox" value="no" name="remember_me" id="remember_me" >
                <span>记住我</span>
              </label>
              <span class="separator">.</span>
              <a class="forgot" href="#">忘记密码</a>
            </div>
            <%--${redirect_after_login }--%>
            <input type="hidden" value="" name="redirect_after_login" id="redirect_after_login">
            <input type="hidden" value="xxx" name="authenticity_token">
            <%--<input type="hidden" value="<%=login_name%>" id="jq_login_name">--%>
            <%--<input type="hidden" value="<%=login_pwd%>" id="jq_login_pwd">--%>
            <%--<input type="hidden" value="<%=remember_me%>" id="jq_remember_me">--%>
          </div>
        </div>
        <!-- signup -->
        <div class="signup-frame">
          <h2><strong>新来访客?</strong> 注册</h2>
          <form action="" method="post">
            <div class="field">
              <input type="text" placeholder="全名" class="text-input">
            </div>
            <div class="field">
              <input type="text" placeholder="邮件" class="text-input">
            </div>
            <div class="field">
              <input type="password" placeholder="密码" class="text-input">
            </div>
            <button type="submit" class="mr-btn signup-btn mr-pull-right">注册兴趣金融</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- footer -->
<div class="footer">
  <div class="copyright">
    <div class="aboutus" style="float: right;">
      <p class="ab">公司简介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 使用帮助</p>
      <div class="aboutus_logo">logo</div>
      <p class="ab">客服电话：4000-xxx-xxx</p>
    </div>
    <div class="aboutus">
      <p>备案号：粤ICP备16049915号</p>
      <p>copyright@2015深圳前海艾德信科技有限公司 版权所有</p>
    </div>

  </div>
</div>
<!-- background image qzone-css -->
<!-- <div class="mw-login-bg" style="overflow: auto">-->
<!-- <img src="../asset/img/login/mw-login-bg.jpg" class="mr-img-responsive" width="1273" height="auto" alt="背景图片" id="mw-login-bg-img" />-->
<!-- &lt;!&ndash;<img src="../asset/img/login/mw-login-bg01.jpg" class="mr-img-responsive" width="1273" height="auto" alt="背景图片" id="mw-login-bg-img" />&ndash;&gt;-->
<!-- </div> -->
<!-- Here introduce the js file -->
<script src="/asset/js/jquery.js"></script>
<script src="/asset/js/zepto.js"></script>
<script src="/plugs/vegas/vegas.min.js"></script>

<%--<script src="/asset/js/mw/loginRegister.js"></script>--%>
<script>
//  $(document).ready(function(){
//    $('body').vegas({
//      delay: 7000,
//      color:"#1b95e0",
//      transitionDuration: 2000,
//      overlay: true,
//      slides:[
//        {src:"../asset/content/bottom5.jpg",color:"#1b95e0"},
//        {src:"../asset/content/wildsee-pizol3.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg01.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg02.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg03.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg04.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg05.jpg",color:"#1b95e0"},
//        {src:"../asset/content/bg06.jpg",color:"#1b95e0"}
//      ]
//    });
//  });
  $(document).ready(function(){


    $('#log_submit').click(function(){
      var login_name = $('#login_name').val();
      var login_pwd  = $('#login_pwd').val();
      console.log(login_name+login_pwd);
      $.ajax({
        type:"POST",
        url: "/user/login",
        dataType:"json",
        data:{login_name:login_name,login_pwd:login_pwd},
        success: function(data){
          var login_status = data['login-status'];
          if (login_status == 2) {
            //登录成功
            location.href = "/";
          }
          if (login_status == 1) {
            //登录失败
            $('.error_info_pwd').text("用户名或者密码错误！");
          }
          if (login_status == 0) {
            //用户名不存在
            $('.error_info_tel').text("手机号码未注册");
          }
        }
      });
    });
  });
</script>
</body>
</html>