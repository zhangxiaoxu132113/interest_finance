<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- usercontent-->
<div class="usercon"  ng-controller="safeCtrl">
    <div class="safe">
        <div class="itemtitle"><span>账户安全</span></div>
        <ul class="info">
            <input type="hidden" class="safe_userId" value="${global_user.USERID}">

            <li class="phone">
                <div class="data">
                    <i class="tel"></i>
                    <div class="box">
                        <label>手机认证</label>
                        <label class="bind_tel_phone"></label>
                        <label class="change_bind_tel_phone"></label>
                        <em></em>
                        <!-- 未认证 -->
                        <a class="setUp" href="javascript:void(0);">立即认证</a>
                        <!-- 已认证 -->
                        <a class="already_set_tel" href="javascript:void(0);" style="display: none">已认证</a>
                    </div>
                </div>
                <!-- 认证手机号码 -->
                <div class="reset" style="display:none;">
                    <i class="tel"></i>
                    <h2 class="title">手机认证</h2>
                    <ul>
                        <li><label>手机号码：</label><input type="text" class="rzTel_text" maxlength="11" placeholder="请输入认证手机号码"></li>
                        <li class="code"><label>短信验证码：</label><input type="text" maxlength="4" class="safe_rzTel_code" placeholder="短信验证码"><button class="safe_rzTel_code_btn">发送验证码</button></li>
                        <li class="err error_info_rzTel"></li>
                        <li><a href="javascript:void(0);" class="rzTelBtn">保存</a></li>
                    </ul>
                    <em class="close"></em>
                </div>
            </li>

            <li class="realName">
                <div class="data">
                    <i class="name"></i>
                    <div class="box">
                        <label>实名认证</label>
                        <label class="realNames"></label>
                        <em></em>
                        <!-- 未认证 -->
                        <a class="setUp" href="javascript:void(0);">立即实名</a>
                        <!-- 已认证 -->
                        <a class="already_realName" href="javascript:void(0);" style="display: none">已实名</a>
                    </div>
                </div>
                <!-- 实名认证 -->
                <div class="reset" style="display:none;">
                    <i class="name"></i>
                    <h2 class="title">实名认证</h2>
                    <ul>
                        <li><label>姓名：</label><input type="text" class="rzName_text" maxlength="11" placeholder="请输入姓名"></li>
                        <li><label>身份证：</label><input type="text" class="rzName_cardID_text" maxlength="18" placeholder="请输入身份证"></li>
                        <li class="err error_info_rzName"></li>
                        <li><a href="javascript:void(0);" class="rzNameBtn">保存</a></li>
                    </ul>
                    <em class="close"></em>
                </div>
            </li>


            <li class="password">
                <!-- 已认证-->
                <div class="data">
                    <i class="pw"></i>
                    <div class="box">
                        <label>登录密码</label>
                        <label class="login_time_log">登陆时间：{{user_log | date:'yyyy-MM-dd HH:mm:ss'}}</label>
                        <em></em>
                        <a class="change" href="javascript:void(0);">修改</a>
                    </div>
                </div>
                <!-- 修改-->
                <div class="reset" style="display:none;">
                    <i class="pw"></i>
                    <h2 class="title">登录密码</h2>
                    <ul>
                        <li><label>当前密码：</label><input type="text" class="safe_pwd" placeholder="请输入原登录密码"></li>
                        <li><label>新密码：</label><input type="text" class="safe_new_pwd" placeholder="请输入新登录密码"></li>
                        <li><label>确认新密码：</label><input type="text" class="safe_new_pwd1" placeholder="请再次输入新登录密码"></li>
                        <li class="err error_info_pwd"></li>
                        <li><a href="javascript:void(0);" class="pwdBtn">保存</a></li>
                    </ul>
                    <em class="close"></em>
                </div>
            </li>
            <li class="payword">
                <div class="data">
                    <i class="pay"></i>
                    <div class="box">
                        <label>交易密码</label><label class="set_pay_pass">请设置初始交易密码</label>
                        <em></em>
                        <!-- 未设置-->
                        <a class="set" href="javascript:void(0);">设置密码</a>
                        <!-- 已设置-->
                        <a class="change" href="javascript:void(0);" style="display: none">修改</a>
                    </div>
                </div>
                <!-- 设置密码 -->
                <div class="setPay" style="display:none;">
                    <i class="pay"></i>
                    <h2 class="title">交易密码</h2>
                    <ul>
                        <li><label>支付密码：</label><input type="text" class="safe_set_payPwd" placeholder="请输入您的支付密码"></li>
                        <li><label>确认支付密码：</label><input type="text" class="safe_set_payPwd1" placeholder="请再次输入您的支付密码"></li>
                        <li class="err error_info_setPayPwd"></li>
                        <li><a href="javascript:void(0);" class="setPayPwdBtn">保存</a></li>
                    </ul>
                    <em class="close"></em>
                </div>
                <!-- 修改 -->
                <div class="reset" style="display:none;">
                    <i class="pay"></i>
                    <h2 class="title">交易密码</h2>
                    <ul>
                        <li><label>当前密码：</label><input type="text" class="safe_payPwd" placeholder="请输入原支付密码"></li>
                        <li><label>新密码：</label><input type="text" class="safe_new_payPwd" placeholder="请输入新支付密码"></li>
                        <li><label>确认新密码：</label><input type="text" class="safe_new_payPwd1" placeholder="请再次输入新支付密码"></li>
                        <li class="err error_info_payPwd"></li>
                        <li><a href="javascript:void(0);" class="payPwdBtn">保存</a></li>
                    </ul>
                    <em class="close"></em>
                </div>
            </li>
            <li class="card">
                <div class="data">
                    <i class="cd"></i>
                    <div class="box">
                        <label>银行卡号</label><label class="bind_bank_card">绑定银行卡</label>
                        <em></em>
                        <!-- 未设置-->
                        <a class="set" href="javascript:void(0);">绑定银行卡</a>
                        <!-- 已设置-->
                        <a class="change" href="javascript:void(0);" style="display: none">修改</a>
                    </div>
                </div>
                <!-- 修改-->
                <div class="reset" style="display:none;">
                    <i class="cd"></i>
                    <h2 class="title">银行卡号</h2>
                    <ul class="left">
                        <li><label>姓名：</label><input type="text" class="safe_username" placeholder="姓名"></li>
                        <li><label>身份证号码：</label><input type="text" maxlength="18" class="safe_cardId" placeholder="身份证号码"></li>
                        <li><label>开户银行：</label><input type="text" class="safe_bankName" placeholder="开户银行"></li>
                        <li><label>银行卡号：</label><input type="text" maxlength="20" class="card_num" placeholder="银行卡号"></li>
                    </ul>
                    <ul class="right">
                        <li><label>银行预留手机号：</label><input type="text" maxlength="11" class="safe_tel_phone" placeholder="银行预留手机号"></li>
                        <li class="code"><label>短信验证码：</label><input type="text" maxlength="4" class="safe_tel_phone_code" placeholder="短信验证码"><button class="safe_tel_phone_code_btn">发送验证码</button></li>
                        <li><a href="javascript:void(0);" class="bindBtn">绑定</a></li>
                    </ul>
                    <ul>
                        <li class="err error_info_reset_card"></li>
                    </ul>
                    <em class="close"></em>
                </div>
                <div class="bankInfo" style="display: none">
                    <table>
                        <tr>
                            <th>银行名称</th>
                            <th>卡号尾数</th>
                        </tr>
                        <tr ng-repeat="item in bankInfos">
                            <td>{{item.BANK_BRANCH}}</td>
                            <td>{{item.BANK_CARD_NO}}</td>
                        </tr>
                    </table>
                </div>
            </li>
        </ul>
    </div>
</div>
<script src="/asset/js/globalUtil.js"></script>
<script src="/asset/js/mw/personhome/safe.js"></script>
<script>

    //    立即手机认证
    $('.phone .setUp').click(function(){
        $('.phone .data').slideUp(200,function(){
            $('.phone .reset').slideDown();
        });
        $('.phone').siblings().children('.reset').slideUp();
        $('.phone').siblings().children('.data').slideDown();
    });
    //    立即实名认证
    $('.realName .setUp').click(function(){
        $('.realName .data').slideUp(200,function(){
            $('.realName .reset').slideDown();
        });
        $('.realName').siblings().children('.reset').slideUp();
        $('.realName').siblings().children('.data').slideDown();
    });
    $('.realName .close').click(function(){
        $('.realName .reset').slideUp(300,function(){
            $('.realName .data').slideDown(200);
            $('.realName .bankInfo').show();
        });
    });
    //    修改手机认证号码
    $('.phone .change_bind_tel_phone').click(function(){
        $('.phone .data').slideUp(200,function(){
            $('.phone .reset').slideDown();
        });
        $('.phone').siblings().children('.reset').slideUp();
        $('.phone').siblings().children('.data').slideDown();
    });
    $('.phone .close').click(function(){
        $('.phone .reset').slideUp(300,function(){
            $('.phone .data').slideDown(200);
        });
    });
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
    //    修改交易密码
    $('.payword .data .box a.change').click(function(){
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
    //    设置交易密码
    $('.payword .data .box a.set').click(function(){
        $('.payword .data').slideUp(200,function(){
            $('.payword .setPay').slideDown();
        });
        $('.payword').siblings().children('.setPay').slideUp();
        $('.payword').siblings().children('.data').slideDown();
    });
    $('.payword .close').click(function(){
        $('.payword .setPay').slideUp(300,function(){
            $('.payword .data').slideDown(200);
        });
    });


    //     绑定银行卡
    $('.card .change').click(function(){
        $('.card .data').slideUp(200,function(){
            $('.card .reset').slideDown();
            $('.card .bankInfo').hide();
        });
        $('.card').siblings().children('.reset').slideUp();
        $('.card').siblings().children('.data').slideDown();
    });
    //     修改银行卡
    $('.card .set').click(function(){
        $('.card .data').slideUp(200,function(){
            $('.card .reset').slideDown();
            $('.card .bankInfo').hide();
        });
        $('.card').siblings().children('.reset').slideUp();
        $('.card').siblings().children('.data').slideDown();
    });

    $('.card .close').click(function(){
        $('.card .reset').slideUp(300,function(){
            $('.card .data').slideDown(200);
            $('.card .bankInfo').show();
        });
    });
</script>
