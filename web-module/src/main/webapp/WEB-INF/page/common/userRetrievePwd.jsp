<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>找回密码页面</title>

  <link rel="stylesheet" type="text/css" href="/asset/css/commons/userRetrievePwd.css"/>

</head>

<body>
<!--找回密码-->
<form class="pass_form">
  <div class="lay" id="passwrap">
    <div class="loginwrap">
      <h2>找回密码<span class="close"></span></h2>
      <ul>
        <li>
          <input type="text" id="recover_tel_phone" placeholder="手机号" datatype="m" maxlength="11" nullmsg="请输入手机号" errormsg="请输入正确的手机号" sucmsg="&nbsp;"/>
          <label class="error_info error_info_tel"></label>
        </li>
        <li class="code">
          <input type="text" id="recover_code" placeholder="短信验证码" maxlength="4" datatype="*" errormsg="请输入4位验证码" sucmsg="&nbsp;"/>
          <div class="btn-code" id="recover_btn-code">
            <img src="/asset/img/logo_07.png"/><label class="send_recover_code_label">发送验证码</label>
          </div>
          <label class="error_info error_info_code" style="margin-left: 20px"></label>
        </li>
        <li>
          <input type="password" id="recover_pwd" placeholder="新密码" datatype="*5-18" errormsg="请输入5-18位密码" name="password" sucmsg="&nbsp;"/>
          <label class="error_info error_info_pwd"></label>
        </li>
        <li>
          <input type="password" id="recover_re_pwd" placeholder="新密码确认" datatype="*5-18" recheck="password" errormsg="两次密码不一致"sucmsg="&nbsp;"/>
          <label class="error_info error_info_pwd_re"></label>
        </li>
        <li><input type="button" id="recover_submit" value="提交" class="btn-green"></li>
      </ul>
    </div>
  </div>
</form>
<script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="/asset/js/globalUtil.js"></script>
<script type="text/javascript" src="/asset/js/mw/loginRegister.js"></script>