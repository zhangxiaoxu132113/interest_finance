<%--
  Created by IntelliJ IDEA.
  User: mrwater
  Date: 16/6/29
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
  description:页面的头部
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--header-->
<link rel="stylesheet" type="text/css" href="/asset/css/commons/login_register.css"/>
<script src="/asset/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="/asset/js/mw/login.js"></script>
<div class="header Grid Grid-withGutter">
    <div class="Grid-cell">
        <div class="logo">logo</div>
        <div class="nav-wrap">
            <div class="nav">
                <div class="left">
                    <c:choose>
                        <c:when test="${global_user != null}">
                            <!--已登录-->
                            <div class="avatar">
                                <span><a href="/user/accountInfo/${global_user.USERID}"><img src="${global_user.headerImg}" width="84" height="84"></a></span>
                            </div>
                            <div class="userinfo">
                                <a class="col-blue" href="/user/accountInfo/${global_user.USERID}">${global_user.USERNAME}</a>
                                <p><a href="/user/logout">退出</a></p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <!--未登录-->
                            <a id="login" href="javascript:void(0);">登录</a>
                            <a id="reg" href="javascript:void(0);">注册</a>
                        </c:otherwise>
                    </c:choose>

                </div>
                <div class="right">
                    <ul>
                        <li class="active"><a href="/">首页</a></li>
                        <li><a href="/borrow/list">平台列表</a></li>
                        <li><a href="/user/accountInfo/${global_user.USERID}">我的账户</a></li>
                        <li><a href="../About/index.html">关于我们</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        //导航栏
        $('.right ul li').click(function(){
            $('.right ul li').removeClass("active");
            $(this).addClass("active");
        });

    });


</script>
<!--用户登录界面-->
<jsp:include page="login.jsp"></jsp:include>
<!--用户找回密码界面-->
<jsp:include page="retrievePwd.jsp"></jsp:include>
<!--用户注册界面-->
<jsp:include page="register.jsp"></jsp:include>

