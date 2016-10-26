/**
 * Created by Meng Sheng on 2016/9/28.
 */

$(document).ready(function(){

    $('input:first').focus();


    /**
     * 用户登录部分
     * */
    /**
     * 用户登录输入框绑定事件
     */
    $('#login_name').on('blur',function(){
        var result = check_TellPhone($(this).val());
        $('.error_info_tel').text(result.msg);
    });
    $('#login_pwd').on('blur',function(){
        var result = check_PassWord($(this).val());
        $('.error_info_pwd').text(result.msg);
    });

    /**点击注册跳转至注册页面*/
    $('.reg_btn').click(function(){
        location.href = "/user/register.html";
    });

    /**点击找回密码跳转至注册页面*/
    $('#pass').click(function(){
        location.href = "/user/forgotPass.html";
    });

    /**
     * 找回密码输入框绑定事件
     */
        //手机号码
    $('#recover_tel_phone').blur(function() {
        var result = check_TellPhone($(this).val());
        $('.error_info_tel').text(result.msg);
    });
    //短信验证码
    $('#recover_code').blur(function() {
        var result = check_MsgCode($(this).val());
        $('.error_info_code').text(result.msg);
    });
    //密码
    $('#recover_pwd').blur(function() {
        var result = check_PassWord($(this).val());
        $('.error_info_pwd').text(result.msg);
    });
    //再次密码
    $('#recover_re_pwd').blur(function() {
        var result = check_PassWord_Rep($('#password').val(),$(this).val());
        $('.error_info_pwd_re').text(result.msg);
    });

    /**点击登录，切换到登录页面*/
    $('.login').click(function () {
        location.href = "/user/login.html";
    });


    /**
     * 用户注册输入框绑定事件
     */
        //用户名
    $('#tel_phone').blur(function() {
        var result = check_TellPhone($(this).val());
        $('.error_info_tel').text(result.msg);
    });
    //短信验证码
    $('#verification_code').blur(function() {
        var result = check_MsgCode($(this).val());
        $('.error_info_code').text(result.msg);
    });
    //登录密码
    $('#password').blur(function() {
        var result = check_PassWord($(this).val());
        $('.error_info_pwd').text(result.msg);
    });
    //再次登录密码
    $('#reg_pwd_re').blur(function() {
        var result = check_PassWord_Rep($('#password').val(),$(this).val());
        $('.error_info_pwd_re').text(result.msg);
    });

    /**点击登录，切换到登录页面*/
    $('.login').click(function () {
        location.href = "/user/login.html";
    });


    /**
     * 邀请注册输入框绑定事件
     */
        //用户名
    $('#invi_tel_phone').blur(function() {
        var result = check_TellPhone($(this).val());
        $('.error_info_tel').text(result.msg);
    });
    //短信验证码
    $('#invi_verification_code').blur(function() {
        var result = check_MsgCode($(this).val());
        $('.error_info_code').text(result.msg);
    });
    //登录密码
    $('#password').blur(function() {
        var result = check_PassWord($(this).val());
        $('.error_info_pwd').text(result.msg);
    });
    //再次登录密码
    $('#invi_reg_pwd_re').blur(function() {
        var result = check_PassWord_Rep($('#invi_password').val(),$(this).val());
        $('.error_info_pwd_re').text(result.msg);
    });
    //邀请码
    $('#invi_code').blur(function(){
        var result = check_inviteCode($(this).val());
        $('.error_info_pwd_re').text(result.msg);
    });

    /**点击登录，切换到登录页面*/
    $('.login').click(function () {
        location.href = "/user/login.html";
    });



    //登录点击事件
    $('#log_submit').bind('click',function(){
        var login_name = $('#login_name').val();
        var login_pwd = $('#login_pwd').val();
        var result_name = check_TellPhone(login_name);//校验用户名
        var result_pwd = check_PassWord(login_pwd);//校验登录密码
        if(!result_name.flag){
            $('.error_info_tel').text(result_name.msg);
            return;
        }
        if(!result_pwd.flag){
            $('.error_info_pwd').text(result_pwd.msg);
            return;
        }
        //登录
        console.log("click login_bnt");
        user_Login(login_name,login_pwd);
    });

    //用户登录方法
    function user_Login(name,pass){
        $.ajax({
            type:"POST",
            url: "/user/login",
            dataType:"json",
            data:{login_name:name,login_pwd:pass},
            success: function(data){
                var login_status = data['login-status'];
                if (login_status == 2) {
                    //登录成功
                    location.href = "/";
                }
                if (login_status == 1) {
                    //登录失败
                    $('.error_info_pwd').text("用户名或者密码错误！");
                }
                if (login_status == 0) {
                    //用户名不存在
                    $('.error_info_tel').text("手机号码未注册");
                }
            }
        });
    }


    /**
     * 用户注册部分
     * */

    /**
     * 用户注册，发送手机验证码
     */
    var reg_send_code_time = 120;//注册手机发送验证码有效时间
    $('#reg_btn_code').bind('click',function() {
        if (reg_send_code_time != 120) return;
        var tel_phone = $('#tel_phone').val();

        //校验用户输入的手机号码
        if(check_TellPhone(tel_phone).flag){
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
            //检查手机号码是否已注册(已注册：true，未注册：false)
            if(check_Tell_reg(tel_phone).flag){
                $('.error_info_tel').text(check_Tell_reg(tel_phone).msg);
                return;
            }else{
                //修改按钮的样式
                setSendRegCodeBtn($(this));
                //手机注册对象验证对应controller的地址

                var reg_url = "/msg/sendCodeWithRegister";
                reg_sendMsgCode_AJAX(tel_phone,reg_url);
            }
        }else{
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
            return;
        }
    });

    //设置发送手机注册验证码的按钮样式
    var setSendRegCodeBtn = function(obj) {
        if (reg_send_code_time == 0) {
            $(".send_reg_code_label").text("发送验证码");
            $(obj).css("background","#72c706");
            reg_send_code_time = 120;
            return;
        } else {
            $(obj).css("background","#c3c3c3");
            $(obj).css("cursor","default");
            $(".send_reg_code_label").text("重新发送(" + reg_send_code_time + ")");
            reg_send_code_time--;
        }

        setTimeout(function() {
                setSendRegCodeBtn(obj) }
            ,1000)
    }


    //用户注册点击事件
    $('#reg_submit').bind('click',function(){
        var tel_phone = $('#tel_phone').val();
        var verification_code = $('#verification_code').val();//短信验证码
        var pwd = $('#password').val();
        var pwd_rep = $('#reg_pwd_re').val();
        var invite_code = $('#code').val();//邀请码
        if(invite_code == null || invite_code == ""){
            invite_code = "null";//邀请码为空
        }

        var result1 = check_TellPhone(tel_phone);//校验手机号码
        var result2 = check_MsgCode(verification_code);//校验短信验证码
        var result3 = check_PassWord(pwd);//校验密码
        var result4 = check_PassWord_Rep(pwd,pwd_rep);//再次校验密码
        if(!result1.flag){
            $('.error_info_tel').text(result1.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_code').text(result2.msg);
            return;
        }
        if(!result3.flag){
            $('.error_info_pwd').text(result3.msg);
            return;
        }
        if(!result4.flag){
            $('.error_info_pwd_re').text(result4.msg);
            return;
        }
        console.log("click reg_submit...");
        //注册
        user_register(tel_phone,verification_code,pwd,invite_code);
    });


    //用户注册方法
    function user_register(name,veri_code,pass,invite_code) {
        $.ajax({
            type: "POST",
            url: "/user/register",
            dataType: "json",
            data: {
                //is_code: is_code,
                invite_code: invite_code,
                username: name,
                password: pass,
                verification_code: veri_code
            },
            success: function (data) {
                var register_status = data["register_status"];
                if (register_status == 0) {
                    //注册成功
                    console.log("注册成功");
                    alert("注册成功！");
                    location.href = "/user/login.action";
                    /**跳转至登录界面*/
                } else if (register_status == 1) {
                    //验证码验证失败
                    alert("验证码验证失败！");
                } else if (register_status == 2) {
                    //注册失败
                    alert("注册失败！");
                }
            }
        });
    }


    /**
     * 邀请用户注册部分
     */


    //设置发送用户邀请注册验证码的按钮样式
    var invi_reg_send_code_time = 120;
    var setSendInviRegCodeBtn = function(obj) {
        if (invi_reg_send_code_time == 0) {
            $(".send_invi_code_label").text("发送验证码");
            $(obj).css("background","#72c706");
            invi_reg_send_code_time = 120;
            return;
        } else {
            $(obj).css("background","#c3c3c3");
            $(obj).css("cursor","default");
            $(".send_invi_code_label").text("重新发送(" + invi_reg_send_code_time + ")");
            invi_reg_send_code_time--;
        }

        setTimeout(function() {
                setSendInviRegCodeBtn(obj) }
            ,1000)
    }
    /**
     * 用户邀请注册，发送手机验证码
     */
    $('#invi_reg_btn_code').bind('click',function() {
        var tel_phone = $('#invi_tel_phone').val();
        if (invi_reg_send_code_time != 120) return;

        //校验用户输入的手机号码
        if(check_TellPhone(tel_phone).flag){
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
            //检查手机号码是否已注册(已注册：true，未注册：false)
            if(check_Tell_reg(tel_phone).flag){
                $('.error_info_tel').text(check_Tell_reg(tel_phone).msg);
                return;
            }

            //修改按钮的样式
            setSendInviRegCodeBtn($(this));
            //手机注册对象验证对应controller的地址
            var reg_url = "/msg/sendCodeWithRegister";
            reg_sendMsgCode_AJAX(tel_phone,reg_url);
        }else{
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
        }
    });


    //用户邀请注册点击事件
    $('#invi_reg_submit').bind('click',function(){
        var tel_phone = $('#invi_tel_phone').val();
        var verification_code = $('#invi_verification_code').val();//短信验证码
        var pwd = $('#invi_password').val();
        var pwd_rep = $('#invi_reg_pwd_re').val();
        var invite_code = $('#invi_code').val();//邀请码
        if(invite_code == null || invite_code == ""){
            invite_code = "null";//邀请码为空
        }

        console.log("click invi_reg_submit...");
        var result1 = check_TellPhone(tel_phone);//校验手机号码
        var result2 = check_MsgCode(verification_code);//校验短信验证码
        var result3 = check_PassWord(pwd);//校验密码
        var result4 = check_PassWord_Rep(pwd,pwd_rep);//再次校验密码
        if(!result1.flag){
            $('.error_info_tel').text(result1.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_code').text(result2.msg);
            return;
        }
        if(!result3.flag){
            $('.error_info_pwd').text(result3.msg);
            return;
        }
        if(!result4.flag){
            $('.error_info_pwd_re').text(result4.msg);
            return;
        }
        //邀请注册
        user_register_invite(tel_phone,verification_code,pwd,invite_code);
    });


    //邀请用户注册方法
    function user_register_invite(name,veri_code,pass,invite_code) {
        $.ajax({
            type: "POST",
            url: "/user/register",
            dataType: "json",
            data: {
                invite_code: invite_code,
                username: name,
                password: pass,
                verification_code: veri_code
            },
            success: function (data) {
                var register_status = data["register_status"];
                if (register_status == 0) {
                    //注册成功
                    console.log("注册成功");
                    alert("注册成功！");
                    location.href = "/user/login.action";
                    /**跳转至登录界面*/
                } else if (register_status == 1) {
                    //验证码验证失败
                    alert("验证码验证失败！");
                } else if (register_status == 2) {
                    //注册失败
                    alert("注册失败！");
                }
            }
        });
    }

    /**
     * 找回密码部分
     */

    //设置发送手机找回密码验证码的按钮样式
    var rec_send_code_time = 120;
    var setSendRecCodeBtn = function(obj) {
        if (rec_send_code_time == 0) {
            $(".send_recover_code_label").text("发送验证码");
            $(obj).css("background","#72c706");
            rec_send_code_time = 120;
            return;
        } else {
            $(obj).css("background","#c3c3c3");
            $(obj).css("cursor","default");
            $(".send_recover_code_label").text("重新发送(" + rec_send_code_time + ")");
            rec_send_code_time--;
        }

        setTimeout(function() {
                setSendRecCodeBtn(obj) }
            ,1000)
    }
    /**
     * 用户找回密码，发送手机验证码
     */
    $('#recover_btn-code').bind('click',function(){
        var tel_phone = $('#recover_tel_phone').val()
        if (rec_send_code_time != 120) return;

        //校验用户输入的手机号码
        if(check_TellPhone(tel_phone).flag){
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
            //检查手机号码是否已注册(已注册：true，未注册：false)
            if(check_Tell_reg(tel_phone).flag){
                $('.error_info_tel').text("");
                //修改按钮的样式
                setSendRecCodeBtn($(this));
                //手机找回密码对象验证对应controller的地址
                var cec_url = "/msg/sendCodeWithRecoverPwd";
                sendMsgCode_AJAX(tel_phone,cec_url);
            }else{
                $('.error_info_tel').text("请输入注册时的手机号码");
                return;
            }


        }else{
            $('.error_info_tel').text(check_TellPhone(tel_phone).msg);
        }
    });

    //用户找回点击保存事件
    $('#recover_submit').bind('click',function(){
        var tel_phone = $('#recover_tel_phone').val()
        var verification_code = $("#recover_code").val();//短信验证码
        var pwd = $("#recover_pwd").val();
        var pwd_rep = $('#recover_re_pwd').val();

        console.log("click recover_btn...");
        var result1 = check_TellPhone(tel_phone);//校验手机号码
        var result2 = check_MsgCode(verification_code);//校验短信验证码
        var result3 = check_PassWord(pwd);//校验密码
        var result4 = check_PassWord_Rep(pwd,pwd_rep);//再次校验密码
        if(!result1.flag){
            $('.error_info_tel').text(result1.msg);
            return;
        }
        if(!result2.flag){
            $('.error_info_code').text(result2.msg);
            return;
        }
        if(!result3.flag){
            $('.error_info_pwd').text(result3.msg);
            return;
        }
        if(!result4.flag){
            $('.error_info_pwd_re').text(result4.msg);
            return;
        }
        //找回密码方法
        user_recover_pwd(tel_phone,verification_code,pwd);

    });

    //找回密码方法
    function user_recover_pwd(name,recover_code,pass) {
        $.ajax({
            type:"POST",
            url: "/user/recoverPwd",
            dataType: "json",
            data:{
                recover_tel_phone:name,
                recover_code:recover_code,
                recover_pwd:pass
            },
            success: function(data){
                var status = data["status"];
                if (status == 0) {
                    //找回密码成功
                    console.log("找回密码成功");
                    alert("找回密码成功！");
                    window.location.href = "/user/login.action"; /**跳转至登录页面*/
                } else if(status == 2) {
                    //验证码验证失败
                    alert("验证码验证失败！");
                }
            }
        });
    }


});
