<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--登录页面-->
<form class="login_form">
    <div class="lay" id="loginwrap" style="display:none;">
        <div class="loginwrap">
            <h2>登录<span class="close"><img src="/asset/img/logo_08.png" width="24"></span></h2>
            <ul>
                <li>
                    <input type="text" id="login_name" name="phone" placeholder="手机号" autocomplete="off" maxlength="11" datatype="m" errormsg="错误的手机格式" sucmsg="&nbsp;"/>
                    <label class="error_info error_info_tel">请输入正确的手机号码</label>
                </li>
                <li>
                    <input type="password" id="login_pwd" name="password" placeholder="密码" autocomplete="off" datatype="*5-18" errormsg="请输入5-18位密码" sucmsg="&nbsp;"/>
                    <label class="error_info error_info_pwd">密码输入不正确！</label>
                </li>
                <li>
                    <input type="button" id="log_submit" value="登录" class="btn-green">
                    <input type="hidden" name="submit" value="submit">
                </li>
                <li class="find"><a href="#" id="pass"> 找回密码</a>/<a href="#" class="col-72 reg_btn"> 快速注册</a></li>
            </ul>
        </div>
    </div>
</form>

