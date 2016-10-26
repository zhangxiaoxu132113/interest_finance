<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>爱德信理财平台</title>
    <link rel="stylesheet" type="text/css" href="/asset/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/user/common.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/user/tradlog.css">
</head>

<body>
<!--header-->
<div class="header">
    <div class="logo">logo</div>
    <div class="nav-wrap">
        <div class="nav">
            <div class="left">
                <!--未登录-->
                <!--<a id="login" href="javascript:void(0);">登录</a>-->
                <!--<a id="reg" href="javascript:void(0);">注册</a>-->
                <!--已登录-->
                <div class="avatar">
                    <span><img src="/asset/img/avatar.png" width="84"></span>
                </div>
                <div class="userinfo">
                    <a class="col-blue" href="../User/index.html">username</a>
                    <p><a href="">退出</a></p>
                </div>
            </div>
            <div class="right">
                <ul>
                    <li><a href="../Index/index.html">首页</a></li>
                    <li><a href="../Borrow/index.html">平台列表</a></li>
                    <li class="active"><a href="../User/index.html">我的账户</a></li>
                    <li><a href="../About/index.html">关于我们</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--userhead-->
<div class="userhead">
    <div class="portrait"><img src="../../image/portrait_03.jpg" width="120"></div>
    <div class="infobox">
        <div class="info">
            176****2130<a href="../User/userdata.html">个人资料</a>
            <a href=""><i class="phone"></i></a>
            <a href=""><i class="idcard"></i></a>
            <a href=""><i class="email"></i></a>
        </div>
    </div>
    <div class="moneylist">
        <ul>
            <li>账户总额：<span class="col-red">12,000,000.00元</span></li>
            <li>可用金额：<span class="col-333">0元</span></li>
            <li>账户总额：<span class="col-333">0元</span></li>
        </ul>
        <a class="withdraw btn" href="../User/withdraw.html">提现</a>
    </div>
</div>

<div class="usermain">
    <!-- userleft-->
    <div class="sidebox">
        <ul>
            <li>
                <a href="/user/accountInfo">
                    <div><span>账户总览</span></div>
                </a>
            </li>
            <li>
                <a href="/user/redPacket">
                    <div><span>我的红包</span></div>
                </a>
            </li>
            <li class="active">
                <a href="/user/tradLog">
                    <div><span>交易记录</span></div>
                </a>
            </li>
            <li>
                <a href="/user/integral">
                    <div><span>我的积分</span></div>
                </a>
            </li>
            <li>
                <a href="/user/member">
                    <div><span>会员权益</span></div>
                </a>
            </li>
            <li>
                <a href="/user/invite">
                    <div><span>我的推广</span></div>
                </a>
            </li>
            <li>
                <a href="/user/safe">
                    <div><span>账户安全</span></div>
                </a>
            </li>
        </ul>
    </div>
    <!-- usercontent-->
    <div class="usercon">
        <div class="tradlog">
            <div class="itemtitle"><span>交易记录</span></div>
            <table>
                <tr>
                    <th>交易类型</th>
                    <th>交易金额</th>
                    <th>资金总额</th>
                    <th>可用余额</th>
                    <th>冻结总额</th>
                    <th>待收总额</th>
                    <th>时间</th>
                </tr>
                <tr>
                    <td>提现</td>
                    <td>200</td>
                    <td>88800</td>
                    <td>4440065</td>
                    <td>4440065</td>
                    <td>460</td>
                    <td>2016.07.06</td>
                </tr>
            </table>
            <p class="unit">以上金额单位（元）</p>
        </div>
    </div>
</div>

<!--footer-->
<div class="footer">
    <div class="copyright">
        <div class="footer_logo">
            <i><img src="/asset/img/logo_03.png" width="100%"/></i>
            <i><img src="/asset/img/logo_03.png" width="100%"/></i>
            <i><img src="/asset/img/logo_03.png" width="100%"/></i>
            <i><img src="/asset/img/logo_03.png" width="100%"/></i>
            <i><img src="/asset/img/logo_03.png" width="100%"/></i>
        </div>
        <div class="aboutus">
            <p>备案号：粤ICP备XXXXXXX号 ICP证粤XXXXXX</p>
            <p>copyright@2015深圳XXXXX有限公司 版权所有</p>
        </div>
        <div class="aboutus">
            <p class="ab">公司简介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 使用帮助</p>
            <div class="aboutus_logo">logo</div>
            <p class="ab">客服电话：4000-xxx-xxx</p>
        </div>
    </div>
</div>
</body>
</html>
