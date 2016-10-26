<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/9
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="personHomeApp" ng-init="userId=${global_user.USERID}">
<head>
    <meta charset="UTF-8">
    <title>爱德信理财平台</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/user/common.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/index.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/redpacket.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/tradlog.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/integral.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/member.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/invite.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/safe.css">
    <script src="/asset/js/jquery.js"></script>
    <script src="/plugs/angularjs/angular-1.2.22.min.js"></script>
    <script src="/plugs/angularjs/angular-route.js"></script>
    <script src="/plugs/angularjs/angular-ui-router.js"></script>
    <script src="/asset/js/angular/controller/personHome.js"></script>
</head>

<body ng-controller="personHomeCtrl">
<!--header-->
<jsp:include page="../common/header.jsp"></jsp:include>

<!--userhead-->
<div class="userhead">
    <div class="portrait"><img src="{{userInfo.headerImg}}" width="120" height="120"></div>
    <div class="infobox">
        <div class="info">
            ${global_user.USERNAME}<a href="../User/userdata.html">个人资料</a>
            <a href=""><i class="phone"></i></a>
            <a href=""><i class="idcard"></i></a>
            <a href=""><i class="email"></i></a>
        </div>
    </div>
    <input name="userId" class="global_user_id" type="hidden" value="${global_user.USERID}" />
    <div class="moneylist">
        <ul>
            <li>账户总额：<span class="col-red">${global_user.TOTALACCOUNT} 元</span></li>
            <li>可用金额：<span class="col-333">${global_user.AVAILABLEBALANCE}元</span></li>
            <li>提现冻结：<span class="col-333">${global_user.FREEZEWITHDRAWALS}元</span></li>
        </ul>
        <a class="withdraw btn" href="/User/withdraw.html">提现</a>
    </div>
</div>

<div class="usermain">
    <!-- userleft-->
    <div class="sidebox">
        <ul>
            <li class="active">
                <a href="#accountInfo">
                    <div><span>账户总览</span></div>
                </a>
            </li>
            <li>
                <a href="#redPacket">
                    <div><span>我的红包</span></div>
                </a>
            </li>
            <li>
                <a href="#tradLog">
                    <div><span>交易记录</span></div>
                </a>
            </li>
            <li>
                <a href="#integral">
                    <div><span>我的积分</span></div>
                </a>
            </li>
            <li>
                <a href="#member">
                    <div><span>会员权益</span></div>
                </a>
            </li>
            <li>
                <a href="#invite">
                    <div><span>我的推广</span></div>
                </a>
            </li>
            <li>
                <a href="#safe">
                    <div><span>账户安全</span></div>
                </a>
            </li>
        </ul>
    </div>
    <div ui-view>

    </div>
</div>

<script>
    $(document).ready(function(){
        //左侧边栏
        $('.sidebox ul li').click(function(){
            $('.sidebox ul li').removeClass("active");
            $(this).addClass("active");
        });
    });
</script>

<!--footer-->
<jsp:include page="../common/footer.jsp"></jsp:include>

</body>

