<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>

    <link rel="stylesheet" type="text/css" href="/asset/css/commons/register.css"/>
    <script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="/asset/js/mw/register.js"></script>
</head>

<body>
<!--账户注册-->
    <div class="lay" id="regwrap"  style="display:none;">
        <div class="loginwrap">
            <h2>注册<span class="close"><img src="/asset/img/logo_08.png" width="24"></span></h2>
            <ul>
                <li>
                    <input type="text" name="username" id="tel_phone" placeholder="手机号" datatype="m" maxlength="11" errormsg="请输入正确的手机号" sucmsg="&nbsp;">
                    <label class="error_info error_info_tel">请输入正确的手机号码</label>

                </li>
                <li class="code">
                    <input type="text" name="verification_code" id="verification_code" placeholder="短信验证码" maxlength="4" datatype="*" errormsg="请输入4位验证码" sucmsg="&nbsp;"/>
                    <div class="btn-code" id="reg_btn_code">
                        <img src="/asset/img/logo_07.png"/><label class="send_code_label" style="cursor: pointer;">发送验证码</label>
                    </div>
                    <label class="error_info error_info_code" style="margin-left: 20px">请输入正确的短信验证码</label>
                </li>
                <li>
                    <input type="password" name="password" id="password" placeholder="新密码" class="inp" maxlength="16" datatype="*5-18" errormsg="请输入5-18位密码" sucmsg="&nbsp;">
                    <label class="error_info error_info_pwd">密码输入不正确！</label>
                </li>
                <li class="newword">
                    <input type="password" name="repassword" id="reg_pwd_re" placeholder="新密码确认" class="inp" maxlength="16" datatype="*5-18" recheck="password" errormsg="两次密码不一致" sucmsg="&nbsp;">
                    <label class="error_info error_info_pwd_re">密码输入不一致</label>
                </li>
                <li class="invite">
                    <input type="text" name="code" id="code" placeholder="使用推荐码">
                    <label class="error_info error_info_inviteCode">邀请码输入不正确</label>
                    <div class="protocol"><p>点击注册即同意XXX<a href="#" class="col-blue">《用户协议》</a></p></div>
                </li>
                <li>
                    <input  type="button" id="reg_submit" value="立即注册" class="btn-green">
                    <input  type="hidden" name="submit" value="submit">
                </li>
                <li class="login">已有账号，<a href="#" class="col-blue login_btn">登录</a></li>
            </ul>
        </div>
    </div>
</body>
