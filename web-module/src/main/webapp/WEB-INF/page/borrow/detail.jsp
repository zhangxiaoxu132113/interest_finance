<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>爱德信理财平台</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/detail.css">
</head>

<body>
<!--header-->
<jsp:include page="../common/header.jsp"></jsp:include>

<!-- 弹出投资项目 start -->
<div class="addPlat"  style="display:none;">
    <div class="paltwrap">
        <h2>投资项目<span class="close"><img src="/asset/img/logo_08.png" width="24"></span></h2>
        <ul>
            <li class="plat_Content">
                <div>${resultJson.bidInfo.NAME}</div>
                <div class="detail">
                    年化收益<span class="red"> ${resultJson.bidInfo.ANNUALRATE_}<em class="f14"> %</em></span> 再加年化&nbsp;&nbsp;
                    <span class="orange">+${resultJson.bidInfo.SELF_ANNUALRATE_}<em class="f14"> %</em></span>
                </div>
            </li>
            <li>
                <input type="button" class="btn-green" id="open_plat_submit" value="开通x平台账户" style="display: none">
                <input type="button" class="btn-green" id="to_plat_submit" value="立即前往" style="display: none">
            </li>
        </ul>
    </div>
</div><!-- 弹出投资项目 end -->

<div class="head">
    <div class="left">
        <ul class="data">
            <li>${resultJson.bidInfo.STARTAMOUNT}元</li>
            <li>${resultJson.bidInfo.SAFEGUARD_WAY}</li>
            <li>${resultJson.bidInfo.REPAYMENT_WAY}</li>
            <li>${resultJson.bidInfo.BEARING_WAY}</li>
            <li>${resultJson.bidInfo.TERM}个月</li>
        </ul>
        <ul class="title">
            <li>起投金额</li>
            <li>保障方式</li>
            <li>还款方式</li>
            <li>计息方式</li>
            <li>期限</li>
        </ul>
        <div class="type"><i></i>${resultJson.platformInfo.P_BACKGROUND}</div>
    </div>
    <div class="middle">
        <div class="rate"><span>${resultJson.bidInfo.ANNUALRATE_ + resultJson.bidInfo.SELF_ANNUALRATE_}</span><em class="f30"> % </em>&nbsp;&nbsp;&nbsp;&nbsp;合计收益</div>
        <div class="detail">
            年化收益<span class="red"> ${resultJson.bidInfo.ANNUALRATE_}<em class="f14"> %</em></span> 再加年化&nbsp;&nbsp;
            <span class="orange">+${resultJson.bidInfo.SELF_ANNUALRATE_}<em class="f14"> %</em></span>
        </div>
    </div>
    <div class="right">
        <div class="logo">
            <span><img src="/${resultJson.platformInfo.LOGO_IMG}"></span>
        </div>
        <a href="javascript:void(0);" id="toPlatform" class="addPlat_btn">前往查看</a>
    </div>
</div>

<div class="describe">
    <div class="title"><span>项目介绍</span></div>
    <ul class="data">
        <li><i class="local"></i><p>实地考察</p></li>
        <li><i class="paper"></i><p>证件存档</p></li>
        <li><i class="money"></i><p>资金托管</p></li>
        <li><i class="debt"></i><p>债权转让</p></li>
    </ul>
    <div class="list">
        <div class="top">
            <span></span>
            <ul>
                <li><span>公司名称：</span>${resultJson.platformInfo.P_NAME}</li>
                <li>
                    <span>上线时间：</span>
                    <fmt:formatDate value="${resultJson.platformInfo.UPTIME}" pattern="yyyy-MM-dd"/>
                </li>
                <li><span>注册资本：</span>${resultJson.platformInfo.REGISTERED_CAPITAL}</li>
                <li><span>联系电话：</span>400-8477-677</li>
                <li><i></i>${resultJson.platformInfo.C_ADDRESS}</li>
            </ul>
        </div>
        <div class="bottom">
            <span></span>
            <ul>
                <li><span>管理费用：</span>${resultJson.platformInfo.MANAGEMENT_COST}</li>
                <li><span>项目类型：</span>${resultJson.platformInfo.PROJECT_TYPE}</li>
                <li><span>充值费用：</span>${resultJson.platformInfo.PREPAID_COST}</li>
                <li><span>保障方式：</span>${resultJson.platformInfo.SAFEGUARD_WAY}</li>
                <li><span>提现费用：</span>${resultJson.platformInfo.WITHDRAWAL_COST}</li>
                <li><span>担保机构：</span>${resultJson.platformInfo.GUARANTEDD_INSTITUTION}</li>
            </ul>
        </div>
    </div>
    <h3>平台介绍</h3>
    <p>${resultJson.platformInfo.PLATFORM_INTRODUCTION}</p>
    <h3>风控情况</h3>
    <p>${resultJson.platformInfo.WIND_CONTROL_SITUATION}</p>
    <h3>推荐理由</h3>
    <p>${resultJson.platformInfo.RECOMMENDED_REASON}</p>

    <a href="javascript:void(0);" class="addPlat_btn">前往查看</a>
</div>

<script src="/asset/js/jquery-1.9.0.min.js"></script>
<script>
    $(document).ready(function() {
        var userId = ${global_user.USERID};
        /** 点击前往查看弹框事件*/
        console.log("前往查看........");
        $('.addPlat_btn').click(function () {

            /**查询是否已开通X平台账户*/
            $.ajax({
                type: "GET",
                url: "/invest/queryInvest",
                dataType: "json",
                data: {
                    userId: userId,
                    platformId: ${resultJson.platformInfo.ID}
                },
                success: function (data) {
                    var open_status = data['open_status'];
                    if (open_status == 0) {
                        //未开通，显示开通x平台账户
                        console.log("未通过兴趣金融开通X平台账户........");
                        $('#open_plat_submit').show();
                        $('#to_plat_submit').hide();
                    } else if (open_status == 1) {
                        //已开通，显示立即前往按钮
                        console.log("已通过兴趣金融开通X平台账户........");
                        $('#open_plat_submit').hide();
                        $('#to_plat_submit').show();
                    }
                }
            });
            $('.addPlat').show();
            $('.paltwrap').slideDown();
        });
        //关闭
        $('.close').click(function () {
            $('.paltwrap').slideUp();
            $('.addPlat').hide();
        });

        /** 点击开通x平台账户事件*/
        $('#open_plat_submit').click(function () {
            /**调用第三方接口，查询是否已注册，若未注册就提交信息注册。若已注册则返回提示信息*/
            console.log("开通x平台账户........");
            $.ajax({
                type: "GET",
                url: "/invest/goInvest",
                dataType: "json",
                data: {
                    phone: ${global_user.USERNAME},
                    userId:userId,
                    platformId:${resultJson.platformInfo.ID}
                },
                success: function (data) {
                    var status = data['status'];
                    /** test */
                    if(status == 3){
                        console.log("测试阶段，暂时不能提交数据进行注册账户！");
                        alert("暂时不能继续操作！");
                    }
                    /** test */
                    if (status == 0) {
                        console.log("用户已在第三方注册！");
                        alert("您的手机号码已在【${resultJson.platformInfo.P_NAME}】平台注册，您不能通过本平台进行投标");
                    }else if(status == 1){
                        console.log("用户在第三方注册成功！");
                        $('#open_plat_submit').hide();
                        $('#to_plat_submit').show();
                        alert("您已成功在【${resultJson.platformInfo.P_NAME}】平台注册，默认密码为123456，请您尽快修改登录密码！");
                    }else if(status == 2){
                        console.warn("注册失败...");
                        alert("【${resultJson.platformInfo.P_NAME}】系统异常！");
                    }
                }
            });
        });


        /** 点击立即前往事件*/
        $('#to_plat_submit').click(function () {
            alert("此步骤未完善！");
            return;
            /**登录第三方平台投标*/
            console.log("跳转至第三方平台........");
            window.open ('${resultJson.platformInfo.URL_ADDRESS}');

        });

    });

</script>
<!--footer-->
<jsp:include page="../common/footer.jsp"></jsp:include>
