<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/10
  Time: 10:17
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
    <link rel="stylesheet" type="text/css" href="/asset/css/user/safe.css">
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
    <div class="portrait"><img src="/asset/img/portrait_03.jpg" width="120"></div>
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
            <li>
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
            <li class="active">
                <a href="/user/safe">
                    <div><span>账户安全</span></div>
                </a>
            </li>
        </ul>
    </div>
    <!-- usercontent-->
    <div class="usercon">
        <div class="safe">
            <div class="itemtitle"><span>账户安全</span></div>
            <ul class="info">
                <li class="password">
                    <!-- 已认证-->
                    <div class="data">
                        <i class="pw"></i>
                        <div class="box">
                            <label>登录密码</label>
                            <em></em>
                            <a class="change" href="javascript:void(0);">修改</a>
                        </div>
                    </div>
                    <!-- 修改-->
                    <div class="reset" style="display:none;">
                        <i class="pw"></i>
                        <h2 class="title">登录密码</h2>
                        <ul>
                            <li><label>当前密码：</label><input type="text"></li>
                            <li><label>新密码：</label><input type="text"></li>
                            <li><label>确认新密码：</label><input type="text"><a href="javascript:void(0);">绑定</a></li>
                        </ul>
                        <em class="close"></em>
                    </div>
                </li>
                <li class="payword">
                    <div class="data">
                        <i class="pay"></i>
                        <div class="box">
                            <label>交易密码</label>
                            <!-- 已设置-->
                            <em></em>
                            <a class="change" href="javascript:void(0);">修改</a>
                            <!-- 未设置-->
                            <!--<a class="set" href="javascript:void(0);">设置密码</a>-->
                        </div>
                    </div>
                    <!-- 修改-->
                    <div class="reset" style="display:none;">
                        <i class="pay"></i>
                        <h2 class="title">交易密码</h2>
                        <ul>
                            <li><label>当前密码：</label><input type="text"></li>
                            <li><label>新密码：</label><input type="text"></li>
                            <li><label>确认新密码：</label><input type="text"><a href="javascript:void(0);">绑定</a></li>
                        </ul>
                        <em class="close"></em>
                    </div>
                </li>
                <li class="card">
                    <div class="data">
                        <i class="cd"></i>
                        <div class="box">
                            <label>银行卡号</label>
                            <!-- 已设置-->
                            <!--<em></em>-->
                            <!-- 未设置-->
                            <a class="set" href="javascript:void(0);">绑定银行卡</a>
                        </div>
                    </div>
                    <!-- 修改-->
                    <div class="reset" style="display:none;">
                        <i class="cd"></i>
                        <h2 class="title">银行卡号</h2>
                        <ul class="left">
                            <li><label>姓名：</label><input type="text"></li>
                            <li><label>身份证号码：</label><input type="text"></li>
                            <li><label>开户银行：</label><input type="text"></li>
                            <li><label>银行卡号：</label><input type="text"></li>
                        </ul>
                        <ul class="right">
                            <li><label>银行预留手机号：</label><input type="text"></li>
                            <li class="code"><label>短信验证码：</label><input type="text"><button>发送验证码</button></li>
                            <li><a href="javascript:void(0);">绑定</a></li>
                        </ul>
                        <em class="close"></em>
                    </div>
                </li>
            </ul>
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
<script src="/asset/js/jquery-1.9.0.min.js"></script>
<script>
    //    登录密码
    $('.password .change').click(function(){
        $('.password .data').slideUp(200,function(){
            $('.password .reset').slideDown();
        });
        $('.password').siblings().children('.reset').slideUp();
        $('.password').siblings().children('.data').slideDown();
    });
    $('.password .close').click(function(){
        $('.password .reset').slideUp(300,function(){
            $('.password .data').slideDown(200);
        });
    });
    //    交易密码
    $('.payword .change').click(function(){
        $('.payword .data').slideUp(200,function(){
            $('.payword .reset').slideDown();
        });
        $('.payword').siblings().children('.reset').slideUp();
        $('.payword').siblings().children('.data').slideDown();
    });
    $('.payword .close').click(function(){
        $('.payword .reset').slideUp(300,function(){
            $('.payword .data').slideDown(200);
        });
    });
    //     银行卡
    $('.card .set').click(function(){
        $('.card .data').slideUp(200,function(){
            $('.card .reset').slideDown();
        });
        $('.card').siblings().children('.reset').slideUp();
        $('.card').siblings().children('.data').slideDown();
    });
    $('.card .close').click(function(){
        $('.card .reset').slideUp(300,function(){
            $('.card .data').slideDown(200);
        });
    });
</script>
</body>
</html>
