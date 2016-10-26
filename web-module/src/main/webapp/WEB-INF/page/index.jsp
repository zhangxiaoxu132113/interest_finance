<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>艾德信理财平台</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/commons/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/plugs/Nivo-Slider/css/nivo-slider.css"/>
    <link rel="stylesheet" type="text/css" href="/plugs/skippr/skippr.css"/>
    <script src="/asset/js/jquery-1.11.0.min.js" type="text/javascript"></script>

</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<!--banner-->
<div id="banner">
    <div id="slider" class="nivoSlider">
        <c:forEach var="carouseImg" items="${resultJson.carouseImgs}">
            <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
            <a href="http://${carouseImg.URL}"><img src="${carouseImg.IMGURL}" alt=""/></a>
        </c:forEach>
    </div>
    <%--<div id="htmlcaption" class="nivo-html-caption">--%>
        <%--<strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.--%>

    <%--</div>--%>
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
            <c:forEach var="item" items="${resultJson.bidByNewComers}">
                <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
                <li>
                    <div class="logolist"><span><img src="/${item.LOGO_IMG}" width="180" height="71"></span></div>
                    <div class="info">
                        <span>期限<em class="f18"></em> ${item.TERM_F}</span>
                        <span class="txt-c">年化收益<em class="f24">${item.ANNUALRATE_}<i class="f12"> %</i></em></span>
                        <span class="txt-r">艾金融再加年化</span>
                    </div>
                    <div class="rate">+${item.SELF_ANNUALRATE_}<span class="f12"> %</span></div>
                    <a href="/borrow/produce/${item.ID}">查看</a>
                </li>
            </c:forEach>
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
            <c:forEach var="item" items="${resultJson.bidByCuratons}">
                <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
                <li>
                    <div class="logolist"><span><img src="/${item.LOGO_IMG}" width="180" height="71"/></span></div>
                    <div class="info">
                        <span>${item.TERM_F}</span>
                        <span class="txt-c col-red"><em class="f30">${item.ANNUALRATE}<i class="f12"> %</i></em></span>
                        <span class="txt-c col-orange"><em class="f30">+${item.SELF_ANNUALRATE}<i class="f12"> %</i></em></span>
                    </div>
                    <div class="num">
                        <span>期限</span>
                        <span class="txt-c">年化收益</span>
                        <span class="txt-c">艾金融再加年化</span>
                    </div>
                    <a href="/borrow/produce/${item.ID}">查看</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<!--middle banner-->
<%--<div class="mid-banner">--%>
    <%--<img src="/asset/img/aidexin_15.png" width="100%"/>--%>
<%--</div>--%>
<!--info-->
<div class="info-box">
    <div class="info">
        <div class="sidebar">
            <ul class="type">
                <li class="sign" style="margin-top: 0!important;">
                    <p class="hot">行业资讯</p>
                    <a href=""><p class="more">更多&gt;&gt;</p></a>
                </li>
                <li>
                    <p class="hot">公司公告</p>
                    <a href="" style="display: none;"><p class="more">更多&gt;&gt;</p></a>
                </li>
            </ul>
        </div>

        <!-- 行业资讯 -->
        <div class="con tab_show" id="industry_information">
            <a href="">
                <div class="left">
                    <img src="/asset/img/aidexin_21.jpg" width="100%">
                    <div>教你学会P2P</div>
                </div>
            </a>
            <div class="right">
                <a href=""><h3>${resultJson.industryArticles[0].TITLE}</h3></a>
                <ul>
                    <c:forEach var="item" items="${resultJson.industryArticles}">
                        <li><a href="">${item.TITLE}</a><span>${item.CREATEDON}</span></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!-- 公司公告 -->
        <div class="con tab_hidden" id="company_announcement">
            <a href="">
                <div class="left">
                    <img src="/asset/img/aidexin_21.jpg" width="100%">
                    <div>公司平台上线通知</div>
                </div>
            </a>
            <div class="right">
                <a href=""><h3>${resultJson.companyInfos[0].TITLE}</h3></a>
                <ul>
                    <c:forEach var="item" items="${resultJson.companyInfos}">
                        <li><a href="">${item.TITLE}</a><span>${item.CREATEDON}</span></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>

<script src="/plugs/Nivo-Slider/js/jquery.nivo.slider.js" type="text/javascript"></script>
<script src="/plugs/skippr/skippr.min.js" type="text/javascript"></script>
<script src="/asset/js/mw/index.js"></script>
<script>
    $(window).load(function() {
        /**slider图片轮播器的播放调用方法*/
        $('#slider').nivoSlider({
            effect:'slideInLeft',
            controlNav:true,
            controlNavThumbs:true,
            directionNav:false
        });

        $("#theTarget").skippr();

        /**文章模块切换选项卡*/
        $('.sidebar .type li').hover(
                function(){
                    //鼠标悬停触发事件
                    //去除样式，隐藏显示内容
                    $('.sidebar .type li').each(function(){
                        if ($(this).hasClass('sign')) {
                            $(this).removeClass('sign');
                            $(this).find('a').css('display','none');
                        }
                    });

                    //添加样式，显示隐藏内容
                    $(this).addClass('sign');
                    $(this).find('a').css('display','block');
                    var tab_name = $(this).find('p').html();
//                    alert(tab_name);
                    if (tab_name == "行业资讯") {
                        $('.con').each(function(){
                           if ($(this).hasClass('tab_show')) {
                               $(this).removeClass('tab_show');
                               $(this).addClass('tab_hidden');
                           }
                        });
                        if (!$('#industry_information').hasClass('tab_show')) {
                            $('#industry_information').addClass('tab_show');
                        }

                    } else if (tab_name == "公司公告") {
                        $('.con').each(function(){
                            if ($(this).hasClass('tab_show')) {
                                $(this).removeClass('tab_show');
                                $(this).addClass('tab_hidden');
                            }
                        });
                        if (!$('#company_announcement').hasClass('tab_show')) {
                            $('#company_announcement').addClass('tab_show');
                        }
                    }
                },function(){
                    //鼠标移开
//                    alert("鼠标移开");
                }
        );
    });

</script>
</body>
</html>
