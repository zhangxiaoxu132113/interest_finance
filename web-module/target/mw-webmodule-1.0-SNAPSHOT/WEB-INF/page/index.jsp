<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>爱德信理财平台</title>

    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/commons/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/index.css"/>
    <script type="text/javascript" src="/asset/js/jquery-1.9.0.min.js"></script>
</head>

<body>
<jsp:include page="common/header.jsp"></jsp:include>
<!--banner-->
<div id="banner">
    <a href="#">banner</a>
</div>
<div class="icon-box">
    <ul class="icon">
        <li><a href=""><img src="/asset/img/p1_03.jpg"/></a></li>
        <li><a href=""><img src="/asset/img/p1_05.jpg"/></a></li>
        <li><a href=""><img src="/asset/img/p1_07.jpg"/></a></li>
    </ul>
</div>
<!--hot activity-->
<div class="act-box">
    <div class="act">
        <div class="sign">
            <p class="hot">热门活动</p>
            <a href=""><p class="more">更多&gt;&gt;</p></a>
        </div>
        <ul class="con">
            <li>
                <h3>精选计划</h3>
                <ul class="packet">
                    <li class="f22 col-red">抢30元红包</li>
                    <li class="f14 col-999">（每天12：00-14：00开抢）</li>
                    <li class="f16 col-666">艾金融加息：<em class="f18">3</em><em class="f12"> %</em> ~ <em class="f18">10</em><em class="f12"> %</em></li>
                    <li><p class="bro f12 col-999">抢购倒计时：<b class="col-red">17时04分46秒</b></p></li>
                </ul>
                <a>查看</a>
            </li>
            <li>
                <h3>精选计划</h3>
                <ul class="packet">
                    <li class="f22 col-red">加倍收益</li>
                    <li class="f14 col-999">（名额有限 预约从速）</li>
                    <li class="f16 col-666">艾金融加息：<em class="f18">3</em><em class="f12"> %</em> ~ <em class="f18">10</em><em class="f12"> %</em></li>
                </ul>
                <a>查看</a>
            </li>
            <li>
                <h3>精选计划</h3>
                <ul class="packet">
                    <li class="f22 col-red">神秘惊喜大奖</li>
                    <li class="f14 col-999">（每天12：00-14：00开抢）</li>
                    <li class="f16 col-666">艾金融加息：<em class="f18">3</em><em class="f12"> %</em> ~ <em class="f18">10</em><em class="f12"> %</em></li>
                </ul>
                <a>查看</a>
            </li>
        </ul>
    </div>
</div>

<!--new-->
<div class="new-box">
    <div class="new">
        <div class="sign">
            <p class="hot">新手专区</p>
            <a href=""><p class="more">更多&gt;&gt;</p></a>
        </div>
        <ul class="con">
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_01.png"></span></div>
                <div class="info">
                    <span>期限<em class="f18">3</em> 个月</span>
                    <span class="txt-c">年化收益<em class="f24">12<i class="f12"> %</i></em></span>
                    <span class="txt-r">艾金融再加年化</span>
                </div>
                <div class="rate">+6<span class="f12"> %</span></div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_04.png"></span></div>
                <div class="info">
                    <span>期限<em class="f18">3</em> 个月</span>
                    <span class="txt-c">年化收益<em class="f24">12<i class="f12"> %</i></em></span>
                    <span class="txt-r">艾金融再加年化</span>
                </div>
                <div class="rate">+6<span class="f12"> %</span></div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_11.png"></span></div>
                <div class="info">
                    <span>期限<em class="f18">3</em> 个月</span>
                    <span class="txt-c">年化收益<em class="f24">12<i class="f12"> %</i></em></span>
                    <span class="txt-r">艾金融再加年化</span>
                </div>
                <div class="rate">+6<span class="f12"> %</span></div>
                <a href="">查看</a>
            </li>
        </ul>
    </div>
</div>
<!--quality-->
<div class="quality-box">
    <div class="quality">
        <div class="sign">
            <p class="hot">优质平台</p>
            <a href="/borrow/list"><p class="more">更多&gt;&gt;</p></a>
        </div>
        <ul class="con">
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
            <li>
                <div class="logolist"><span><img src="/asset/img/aidexin_19.jpg"/></span></div>
                <div class="info">
                    <span>3个月</span>
                    <span class="txt-c col-red"><em class="f30">12</em><em class="f12"> %</em></span>
                    <span class="txt-c col-orange"><em class="f30">+6</em><em class="f12"> %</em></span>
                </div>
                <div class="num">
                    <span>期限</span>
                    <span class="txt-c">年化收益</span>
                    <span class="txt-c">艾金融再加年化</span>
                </div>
                <a href="">查看</a>
            </li>
        </ul>
    </div>
</div>
<!--middle banner-->
<div class="mid-banner">
    <img src="/asset/img/aidexin_15.png" width="100%"/>
</div>
<!--info-->
<div class="info-box">
    <div class="info">
        <div class="sidebar">
            <div class="sign">
                <p class="hot">行业资讯</p>
                <a href=""><p class="more">更多&gt;&gt;</p></a>
            </div>
            <ul class="type">
                <li>行业资讯</li>
                <li>公司公告</li>
            </ul>
        </div>
        <div class="con">
            <a href="">
                <div class="left">
                    <img src="/asset/img/aidexin_21.jpg" width="100%">
                    <div>教你学会P2P</div>
                </div>
            </a>
            <div class="right">
                <a href=""><h3>基金子公司加速蜕变 “资管新军”的全新挑战</h3></a>
                <ul>
                    <li><a href="">基金子公司加速蜕变 “资管新军”的全新挑战</a><span>2016-07-07</span></li>
                    <li><a href="">基金经理也扛不住黑色星期一 15只股基单日跌逾6%</a><span>2016-07-07</span></li>
                    <li><a href="">基金子公司加速蜕变 “资管新军”的全新挑战</a><span>2016-07-07</span></li>
                    <li><a href="">基金经理也扛不住黑色星期一 15只股基单日跌逾6%</a><span>2016-07-07</span></li>
                    <li><a href="">基金子公司加速蜕变 “资管新军”的全新挑战</a><span>2016-07-07</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>


<%--<script type="text/javascript" src="/asset/js/validform/Validform_v5.3.2_min.js"></script>--%>


<script>

    $(function(){
        $('.loginwrap').slideUp();
    });
    $('#login').click(function () {
        $('#loginwrap').show();
        $('.loginwrap').slideDown();
    });
    $('#reg').click(function () {
        $('#regwrap').show();
        $('.loginwrap').slideDown();
    });
    $('#pass').click(function () {
        $('#passwrap').show();
        $('.loginwrap').slideDown();
    });
    $('.close').click(function () {
        $('.loginwrap').slideUp();
        $('.lay').hide();
    });
    $('.login_btn').bind("click",function() {
        $('#regwrap').hide();
        $('#loginwrap').show();
        $('.loginwrap').slideDown();
    });
    $('.reg_btn').bind("click",function() {
        $('#loginwrap').hide();
        $('#regwrap').show();
        $('.regwrap').slideDown();
    });

</script>
</body>
</html>
