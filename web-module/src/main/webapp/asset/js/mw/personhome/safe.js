/**
 * Created by Meng Sheng on 2016/9/23.
 */
$(document).ready(function() {

    /**定义变量*/
    var STATUS_YES = 0;//成功
    var STATUS_NOT = 1;//失败
    var STATUS_MSG_CODE_ERROR = 2;//验证码错误

    var userId = $('.safe_userId').val();

    /**跳转到controller的地址*/
    var url_update_pwd = "/user/safe/modifyPass";//原登录密码修改的controller地址
    var url_update_payPwd = "/user/safe/modifyPayPass";//原支付密码修改和设置的controller地址
    var url_check_pwd = "/user/safe/checkLoginPass";//验证原登录密码的controller地址
    var url_check_payPwd = "/user/safe/checkPayPass";//验证原支付密码的controller地址

    /**
     * 输入框绑定事件
     */

    //手机认证
    $('.rzTel_text').on('blur',function(){
        var result = check_TellPhone($(this).val());
        $('.error_info_rzTel').text(result.msg);
    });
    $('.safe_rzTel_code').on('blur',function(){
        var result = check_MsgCode($(this).val());
        $('.error_info_rzTel').text(result.msg);
    });
    //修改登录密码
    $('.safe_pwd').on('blur',function(){
        var result = check_PassWord($(this).val());
        if(result.flag){
            var result_vali = validatePassExist($(this).val(),userId,url_check_pwd);
            $('.error_info_pwd').text(result_vali.msg);
        }else {
            $('.error_info_pwd').text(result.msg);
        }
    });
    $('.safe_new_pwd').on('blur',function(){
        var result = check_PassWord_New($('.safe_pwd').val(),$(this).val());
        $('.error_info_pwd').text(result.msg);
    });
    $('.safe_new_pwd1').on('blur',function() {
        var result = check_PassWord_Rep($('.safe_new_pwd').val(), $(this).val());
        $('.error_info_pwd').text(result.msg);
    });
    //设置支付密码
    $('.safe_set_payPwd').on('blur',function(){
        var result = check_PassWord($(this).val());
        $('.error_info_setPayPwd').text(result.msg);
    });
    $('.safe_set_payPwd1').on('blur',function(){
        var result = check_PassWord_Rep($('.safe_set_payPwd').val(),$(this).val());
        $('.error_info_setPayPwd').text(result.msg);
    });
    //修改支付密码
    $('.safe_payPwd').on('blur',function(){
        var result = check_PassWord($(this).val());
        if(result.flag){
            var result_vali = validatePassExist($(this).val(),userId,url_check_payPwd);
            $('.error_info_payPwd').text(result_vali.msg);
        }else {
            $('.error_info_payPwd').text(result.msg);
        }
    });
    $('.safe_new_payPwd').on('blur',function(){
        var result = check_PassWord_New($('.safe_payPwd').val(),$(this).val());
        $('.error_info_payPwd').text(result.msg);
    });
    $('.safe_new_payPwd1').on('blur',function(){
        var result = check_PassWord_Rep($('.safe_new_payPwd').val(),$(this).val());
        $('.error_info_payPwd').text(result.msg);
    });


    /**
     * 手机认证，发送手机验证码点击事件
     */
    var send_rzTel_code_time = 120;//认证手机发送验证码有效时间
    $('.safe_rzTel_code_btn').bind('click',function() {
        var rz_tell = $('.rzTel_text').val();
        if (send_rzTel_code_time != 120) return;

        //校验用户输入的手机号码
        if(check_TellPhone(rz_tell).flag){
            $('.error_info_rzTel').text(check_TellPhone(rz_tell).msg);
            //修改按钮的样式
            setSendRzTelCodeBtn($(this));
            //手机认证对象验证对应controller的地址
            var rzTel_url = "/msg/sendCodeWithRzTel";
            sendMsgCode_AJAX(rz_tell,rzTel_url);
        }else{
            $('.error_info_rzTel').text(check_TellPhone(rz_tell).msg);
        }
    });

    //设置发送手机认证验证码的按钮样式
    var setSendRzTelCodeBtn = function(obj) {
        if (send_rzTel_code_time == 0) {
            $(obj).text("发送验证码");
            $(obj).css("background","#72c706");
            send_rzTel_code_time = 120;
            return;
        } else {
            $(obj).css("background","#c3c3c3");
            $(obj).css("cursor","default");
            $(obj).text("重新发送(" + send_rzTel_code_time + ")");
            send_rzTel_code_time--;
        }

        setTimeout(function() {
                setSendRzTelCodeBtn(obj) }
            ,1000)
    }

    /**
     * 手机认证，点击保存事件
     */
    $('.rzTelBtn').bind('click',function() {
        var value1 = $('.rzTel_text').val();//手机号码
        var value2 = $('.safe_rzTel_code').val();//短信验证码
        var result1 = check_TellPhone(value1);//校验手机号码
        var result2 = check_MsgCode(value2);//校验验证码
        if(!result1.flag){
            $('.error_info_rzTel').text(result1.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_rzTel').text(result2.msg);
            return;
        }

        console.log("click rzTelBtn....");
        $.ajax({
            type: "POST",
            url: "/user/safe/saveRzTellPhone",
            dataType: "json",
            data: {
                tel_phone: value1,
                msg_code:value2,
                userId: userId
            },
            success: function (data) {
                var status = data['status'];
                if (status == STATUS_YES) {
                    //认证手机保存成功
                    console.log("认证手机保存成功 ");
                    $('.phone .data .box em').css({'background-position-x':'0px','background-position-y':"-107px"});
                    $('.phone .data .box a.already_set_tel').show();
                    $('.phone .data .box a.setUp').hide();
                    alert("手机认证成功");
                    window.location.reload();
                } else if (status == STATUS_NOT) {
                    //认证手机保存失败
                    console.log("认证手机保存失败 ");
                    alert("系统异常，手机认证失败");
                } else if(status == STATUS_MSG_CODE_ERROR){
                    //验证码错误
                    console.log("验证码错误 ");
                    alert("验证码错误");
                }
            }
        });
    });

    /**
     * 实名认证点击保存事件
     * */
    $('.rzNameBtn').bind('click',function() {
        var realname = $('.rzName_text').val();//真实姓名
        var cardID = $('.rzName_cardID_text').val();//身份证号码
        var result1 = check_Name(realname);//校验真实姓名
        var result2 = check_Person_cardID(cardID);//校验身份证号码
        if(!result1.flag){
            $('.error_info_rzName').text(result1.msg);
            return;
        }
        if(!result2.flag) {
            $('.error_info_rzName').text(result2.msg);
            return;
        }
        console.log("click rzNameBtn....");
        $.ajax({
            type: "POST",
            url: "/user/safe/saveRealName",
            dataType: "json",
            data: {
                real_name: realname,
                user_cardID: cardID,
                userId:userId
            },
            success: function (data) {
                var status = data['status'];
                if (status == STATUS_YES) {
                    //实名认证成功
                    console.log("实名认证成功 ");
                    window.location.reload();
                } else if (status == STATUS_NOT) {
                    //实名认证失败
                    console.log("实名认证失败 ");
                    $('.error_info_rzName').text("实名认证失败");
                }
            }
        });
    });

    /**
     * 修改登录密码点击保存事件
     * */
    $('.pwdBtn').bind('click',function() {
        var pwd1 = $('.safe_pwd').val();//原登录密码
        var pwd2 = $('.safe_new_pwd').val();//新登录密码
        var pwd3 = $('.safe_new_pwd1').val();//再次新登录密码
        var result1 = check_PassWord(pwd1);//校验原密码格式
        var result_vali = validatePassExist(pwd1,userId,url_check_pwd);//校验原密码是否正确
        var result2 = check_PassWord_New(pwd1,pwd2);//校验新密码格式
        var result3 = check_PassWord_Rep(pwd2,pwd3);//再次校验新密码格式

        if(!result1.flag){
            $('.error_info_pwd').text(result1.msg);
            return;
        }
        if(!result_vali.flag){
            $('.error_info_pwd').text(result_vali.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_pwd').text(result2.msg);
            return;
        }
        if(!result3.flag){
            $('.error_info_pwd').text(result3.msg);
            return;
        }
        console.log("click pwdBtn....");

        var updatePwd = booleanUpdatePass(pwd2,userId,url_update_pwd);
        if(updatePwd.flag){
            alert("登录密码修改成功！");
            window.location.reload();
        }else{
            alert("登录密码修改失败！");
            $('.error_info_pwd').text(updatePwd.msg);
        }
    });

    /**
     * 设置支付密码点击保存事件
     * */
    $('.setPayPwdBtn').bind('click',function() {
        var pwd1 = $('.safe_set_payPwd').val();//支付密码
        var pwd2 = $('.safe_set_payPwd1').val();//再次支付的密码
        var result1 = check_PassWord(pwd1);//校验支付密码
        var result2 = check_PassWord_Rep(pwd1,pwd2);//再次校验支付密码
        if(!result1.flag){
            $('.error_info_setPayPwd').text(result1.msg);
            return;
        }
        if(!result2.flag) {
            $('.error_info_setPayPwd').text(result2.msg);
            return;
        }
        console.log("click setPayPwdBtn....");
        var update_pwd = booleanUpdatePass(pwd2,userId,url_update_payPwd);
        if(update_pwd.flag){
            alert("支付密码设置成功！");
            window.location.reload();
        }else{
            alert("支付密码设置失败！");
            $('.error_info_setPayPwd').text(update_pwd.msg);
        }
    });

    /**
     * 修改支付密码点击保存事件
     * */
    $('.payPwdBtn').bind('click',function() {
        var pwd1 = $('.safe_payPwd').val();//原支付密码
        var pwd2 = $('.safe_new_payPwd').val();//新支付密码
        var pwd3 = $('.safe_new_payPwd1').val();//再次新支付密码
        var result1 = check_PassWord(pwd1);//校验原密码格式
        var result_vali = validatePassExist(pwd1,userId,url_check_payPwd);//校验原密码是否正确
        var result2 = check_PassWord_New(pwd1,pwd2);//校验新密码格式
        var result3 = check_PassWord_Rep(pwd2,pwd3);//再次校验新密码格式

        if(!result1.flag){
            $('.error_info_payPwd').text(result1.msg);
            return;
        }
        if(!result_vali.flag){
            $('.error_info_payPwd').text(result_vali.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_payPwd').text(result2.msg);
            return;
        }
        if(!result3.flag){
            $('.error_info_payPwd').text(result3.msg);
            return;
        }
        console.log("click payPwdBtn....");
        var updatePwd = booleanUpdatePass(pwd2,userId,url_update_payPwd);
        if(updatePwd.flag){
            alert("支付密码修改成功！");
            window.location.reload();
        }else{
            alert("支付密码修改失败！");
            $('.error_info_payPwd').text(updatePwd.msg);
        }
    });

    /**检验原密码是否正确
     * pass:密码
     * userId:用户ID
     * url:controller地址
     * return: boolean
     * */
    function validatePassExist(pass,user_Id,url){
        var result = {msg:"原密码错误", flag:false};
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            async:false,//同步刷新
            data: {pwd: pass, userId: user_Id},
            success:function(data) {
                var status = data['status'];
                if (status == STATUS_YES) {
                    //原密码正确
                    console.log("原密码正确！");
                    result = {msg:"", flag:true};
                } else if(status == STATUS_NOT){
                    //原密码错误
                    console.log("原密码错误！");
                    result = {msg:"原密码错误", flag:false};
                }
            }
        });
        return result;
    }

    /**检验修改密码是否成功
     * pass:密码
     * userId:用户ID
     * url:controller地址
     * return: boolean
     * */
    function booleanUpdatePass(pass,user_Id,url){
        var result = {msg:"密码修改不成功", flag:false};
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            async:false,//同步刷新
            data: {
                pwd: pass,
                userId: user_Id
            },
            success: function (data) {
                var status = data['status'];
                if (status == STATUS_YES) {
                    //密码修改成功
                    console.log("密码修改成功 ");
                    result = {msg:"", flag:true};
                } else if (status == STATUS_NOT) {
                    //密码修改失败
                    console.log("密码修改失败 ");
                    result = {msg:"密码修改不成功", flag:false};
                }
            }
        });
        return result;
    }

    /**
     * 绑定银行卡,点击保存事件
     * */
    $('.bindBtn').bind('click',function() {
        console.log("in bind event!");
        var card_userName = ($('.safe_username').val());
        var card_cardId = ($('.safe_cardId').val());
        var card_bankName = ($('.safe_bankName').val());
        var card_card_num = ($('.card_num').val());
        var bindCard_tell = $('.safe_tel_phone').val();
        var bindCard_msg_code = $('.safe_tel_phone_code').val();

            $.ajax({
                type:'POST',
                url:'/user/safe/bindBankCard',
                dataType: "json",
                data:{
                    userId:userId,
                    username:card_userName,
                    cardId:card_cardId,
                    bankName:card_bankName,
                    card_num:card_card_num,
                    tell_phone:bindCard_tell,
                    msg_code:bindCard_msg_code
                },
                success:function(data) {
                    var status = data['status'];
                    console.log("status = " + status);
                    if (status == STATUS_YES) {
                        console.log("绑定成功！");
                        $('.card .data .box a.change').show();
                        $('.card .data .box a.set').hide();
                        alert("绑定成功");
                        window.location.reload();
                    } else if(status == STATUS_MSG_CODE_ERROR) {
                        console.log("验证码失败！");
                        alert("验证码失败");
                    }else if(status == STATUS_NOT){
                        console.log("绑定失败！");
                        alert("绑定失败");
                    }
                }
            });
    });


});