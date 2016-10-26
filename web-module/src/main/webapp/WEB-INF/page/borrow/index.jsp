<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="produceListApp">
<head>
    <meta charset="UTF-8">
    <title>艾德信理财平台</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/borrow.css">

    <script src="/asset/js/jquery-1.9.0.min.js"></script>
</head>

<body ng-controller="produceListCtrl">
<!--header-->
<jsp:include page="../common/header.jsp"></jsp:include>
<!--select condition-->
<div class="selectbox">
    <div class="left">
        <a href="javascript:void(0);" ng-click="selectZone('comerZone')">新手专区</a>
        <a href="javascript:void(0);" ng-click="selectZone('selectZone')">理财专区</a>
    </div>
    <div class="right">
        <ul>
            <li>
                <span><i class="bg"></i>平台背景：</span>
                <em class="active" ng-click="selectPBackground(-1)">全部</em>
                <em ng-repeat="item in platformBackgroundList" ng-click="selectPBackground(item.DDLCODE,$event.target)" >{{item.DDLNAME}}</em>

            </li>
            <li>
                <span><i class="proj"></i>项目收益：</span>
                <em class="active" ng-click="selectReturnRate('')">全部</em>
                <em ng-click="selectReturnRate('16-20')">20%~16%</em>
                <em ng-click="selectReturnRate('12-16')">16%~12%</em>
                <em ng-click="selectReturnRate('8-12')">12%~8%</em>
            </li>
            <li>
                <span><i class="cycle"></i>项目周期：</span>
                <em class="active" ng-click="selectRetuenDate('')">全部</em>
                <em ng-click="selectRetuenDate('0-1')">30天以内</em>
                <em ng-click="selectRetuenDate('1-6')">1~6个月</em>
                <em ng-click="selectRetuenDate('6-12')">6~12个月</em>
                <em ng-click="selectRetuenDate('12-24')">12个月以上</em>
            </li>
            <li>
                <span><i class="start"></i>起投金额：</span>
                <em class="active" ng-click="queryStartAmount(-1)">全部</em>
                <em ng-click="queryStartAmount(100)">100元</em>
                <em ng-click="queryStartAmount(500)">500元</em>
                <em ng-click="queryStartAmount(1000)">1000元</em>
            </li>
        </ul>
    </div>
</div>
<!--investlist-->
<div class="listbox">
    <div class="head">
        <ul class="item">
            <li class="act">活动</li>
            <li class="total">项目总额<i id="test"></i></li>
            <li class="cycle">期限<i></i></li>
            <li class="rate">年化收益<i></i></li>
            <li class="add">平台加息<i></i></li>
            <li class="trate">合计收益<i></i></li>
        </ul>
        <div class="line"></div>
    </div>
    <ul class="borrowlist">
        <li ng-repeat="item in produceList" class="ng-cloak">
            <div class="left"><span ng-bind="item.pBackgroundName"></span></div>
            <div class="right">
                <span class="logo"><em><img ng-src="/{{item.LOGO_IMG}}" width="110"></em></span>
                <span class="act"><em><img src="/asset/img/extra_03.png"></em></span>
                <span class="total">{{item.TOTALCAPITAL}}元</span>
                <span class="cycle"><em class="f18">{{item.TERM_F}}</em></span>
                <span class="rate"><strong><em class="f18" ng-bind="item.ANNUALRATE"></em>.00 %</strong></span>
                <span class="add"><strong>+<em class="f18" ng-bind="item.SELF_ANNUALRATE"></em>.00 %</strong></span>
                <span class="trate"><em class="f30" ng-bind="item.ANNUALRATE + item.SELF_ANNUALRATE"></em>.00 %</span>
            </div>
            <div class="btn"><a href="/borrow/produce/{{item.ID}}">查看</a><span>（起投金额：{{item.STARTAMOUNT}}元）</span></div>
        </li>
        <li ng-if="produceList.length == 0" style="text-align: center;font-size: 20px;color:#686766;">
            <div>
                找不到你要的数据！
            </div>
        </li>
    </ul>
    <div class="page">
        <span><</span>
        <a class="current" href="">1</a>
        <a href="">2</a>
        <a href="">3</a>
        <span>></span>
    </div>
</div>
<!--footer-->
<jsp:include page="../common/footer.jsp"></jsp:include>

<!-- angularjs -->
<script src="/plugs/angularjs/angular-1.2.22.min.js"></script>
<script src="/plugs/angularjs/angular-route.js"></script>
<script src="/plugs/angularjs/angular-ui-router.js"></script>
<script src="/asset/js/mw/produceList.js"></script>
<script src="/asset/js/angular/controller/produceList-ang.js"></script>

<!-- 设置登录注册找回密码的显示隐藏 -->
<script src="/asset/js/mw/index.js"></script>

</body>
</html>

