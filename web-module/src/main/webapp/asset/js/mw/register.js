///**
// * Created by Meng Sheng on 2016/9/8.
// */
///**
// * Created by Administrator on 2016/8/24.
// */
//
//$(document).ready(function(){
//
//    //定义变量
//    var register_flag = true;
//    var recover_flag = true;
//    var login_flag = true;
//
//
//    //设置发送手机注册验证码的按钮样式
//    var reg_send_code_time = 120;
//    var setSendRegCodeBtn = function(obj) {
//        if (reg_send_code_time == 0) {
//            $(".send_code_label").text("发送验证码");
//            $(obj).css("background","#72c706");
//            reg_send_code_time = 120;
//            return;
//        } else {
//            $(obj).css("background","#c3c3c3");
//            $(obj).css("cursor","default");
//            $(".send_code_label").text("重新发送(" + reg_send_code_time + ")");
//            reg_send_code_time--;
//        }
//
//        setTimeout(function() {
//                setSendRegCodeBtn(obj) }
//            ,1000)
//    }
//
//    //设置发送手机找回密码验证码的按钮样式
//    var rec_send_code_time = 120;
//    var setSendRecCodeBtn = function(obj) {
//        if (rec_send_code_time == 0) {
//            $(".send_recover_code_label").text("发送验证码");
//            $(obj).css("background","#72c706");
//            rec_send_code_time = 120;
//            return;
//        } else {
//            $(obj).css("background","#c3c3c3");
//            $(obj).css("cursor","default");
//            $(".send_recover_code_label").text("重新发送(" + rec_send_code_time + ")");
//            rec_send_code_time--;
//        }
//
//        setTimeout(function() {
//                setSendRecCodeBtn(obj) }
//            ,1000)
//    }
//
//    /**
//     * 用户注册，发送手机验证码
//     */
//    $('#reg_btn_code').bind('click',function() {
//
//        if (reg_send_code_time != 120) return;
//
//        //验证用户的输入
//        var tel_phone = $('#tel_phone').val();
//        var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
//        if (!reg.test(tel_phone)) {
//            $('.error_info_tel').fadeIn(300,function(){
//                $('.error_info_tel').fadeOut(3000);
//            });
//            return;
//        }
//
//        //修改按钮的样式
//        console.log("reg_btn click!");
//        setSendRegCodeBtn($(this));
//
//        $.ajax({
//            type:"POST",
//            url: "/msg/sendCodeWithRegister",
//            data:{
//                tel_phone:tel_phone
//            },
//            success: function(data){
//                var status = data['status'];
//                if (status == 0) {
//                    alert("验证码已经发送！");
//                } else if (status == 1) {
//                    alert("手机号码已经被注册过！");
//                }
//            }
//        });
//    });
//
//    /**
//     * 找回密码，发送手机验证码
//     */
//    $('#recover_btn-code').bind('click',function(){
//
//        if (rec_send_code_time != 120) return;
//
//        //验证用户的输入
//        var tel_phone = $('#recover_tel_phone').val();
//        var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
//        if (!reg.test(tel_phone)) {
//            $('.error_info_tel').fadeIn(300,function(){
//                $('.error_info_tel').fadeOut(3000);
//            });
//            return;
//        }
//
//        //修改按钮的样式
//        setSendRecCodeBtn($(this));
//
//        $.ajax({
//            type:"POST",
//            url: "/msg/sendCodeWithRecoverPwd",
//            data:{
//                tel_phone:tel_phone
//            },
//            success: function(data){
//                var status = data['status'];
//                if (status == 0) {
//                    alert("验证码已经发送!");
//                } else if (status == 1) {
//                    alert("手机号码不存在!");
//                }
//            }
//        });
//    });
//
//    //注册点击事件
//    $('#reg_submit').bind('click',function(){
//        var tel_phone = $('#tel_phone').val();
//        var verification_code = $('#verification_code').val();
//        var pwd = $('#password').val();
//        var pwd_re = $('#reg_pwd_re').val();
//
//        console.log("click reg_submit...");
//
//        //检验用户的输入
//        checkTelphone(tel_phone);
//        checkPwd(pwd);
//        checkPwdRe();
//        checkCode(verification_code);
//
//        console.log("flag = "+register_flag);
//        if (register_flag) {
//            $.ajax({
//                type:"POST",
//                url: "/user/register",
//                dataType: "json",
//                data:{
//                    is_code:"0",
//                    code:$('#code').val(),
//                    username:tel_phone,
//                    password:pwd,
//                    verification_code:verification_code
//                },
//                success: function(data){
//                    var register_status = data["register_status"];
//                    if (register_status == 0) {
//                        //注册成功
//                        console.log("注册成功");
//                        alert("注册成功！");
//                        window.location.href = "/"; /**跳转至首页*/
//
//                    } else if(register_status == 1) {
//                        //验证码验证失败
//                        alert("验证码验证失败！");
//                    }else if(register_status == 2) {
//                        //注册失败
//                        alert("注册失败！");
//                    }
//                }
//            });
//        }
//
//    });
//
//    //找回密码，点击事件
//    $("#recover_submit").bind('click',function(){
//
//        var recover_tel_phone = $("#recover_tel_phone").val();
//        var recover_code = $("#recover_code").val();
//        var recover_pwd = $("#recover_pwd").val();
//        //验证用户输入
//        checkTelphone(recover_tel_phone);
//        checkCode(recover_code);
//        checkPwd(recover_pwd);
//        checkPwdReWithRecover();
//
//        if (recover_flag) {
//            $.ajax({
//                type:"POST",
//                url:"/user/recoverPwd",
//                data:{
//                    recover_tel_phone:recover_tel_phone,
//                    recover_code:recover_code,
//                    recover_pwd:recover_pwd
//                },
//                success: function(data) {
//                    console.log(data);
//                }
//            });
//        }
//    });
//
//
//    /**
//     * 输入框绑定事件
//     */
//    $('#tel_phone').blur(function() {
//        checkTelphone($(this).val());
//    });
//    $('#password').blur(function() {
//        checkPwd($(this).val());
//    });
//    $('#reg_pwd_re').blur(function() {
//        checkPwdRe();
//    });
//    $('#verification_code').blur(function() {
//        checkCode($(this).val());
//    });
//    $('#recover_tel_phone').blur(function() {
//        checkTelphone($(this).val());
//    });
//    $('#recover_pwd').blur(function() {
//        checkPwd($(this).val());
//    });
//    $('#recover_re_pwd').blur(function() {
//        console.log("ha");
//        checkPwdReWithRecover();
//        console.log("ha");
//    });
//    $('#recover_code').blur(function() {
//        checkCode($(this).val());
//    });
//    $('#login_name').blur(function() {
//        checkTelphone($(this).val());
//    });
//    $('#login_pwd').blur(function() {
//        checkPwd($(this).val());
//    });
//
//
//    //检验手机号码输入
//    var checkTelphone = function(tel_phone) {
//        var tel_phone = tel_phone;
//        var reg = /^0?1[3|4|5|7|8][0-9]\d{8}$/;
//        if (!reg.test(tel_phone)) {
//            $('.error_info_tel').fadeIn(300,function(){
//                $('.error_info_tel').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//            login_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//            login_flag = true;
//        }
//    }
//
//    //检验密码输入
//    var checkPwd = function(pwd) {
//        var password = pwd;
//        if (!password) {
//            $('.error_info_pwd').fadeIn(300,function(){
//                $('.error_info_pwd').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//            login_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//            login_flag = true;
//        }
//    }
//
//    //检验第二次密码输入
//    var checkPwdRe = function() {
//        var password = $('#password').val();
//        var reg_pwd_re = $('#reg_pwd_re').val();
//        if (!reg_pwd_re) {
//            register_flag = false;
//            recover_flag = false;
//            return;
//        }
//        if (password != reg_pwd_re) {
//            $('.error_info_pwd_re').fadeIn(300,function(){
//                $('.error_info_pwd_re').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//        }
//    }
//    var checkPwdReWithRecover = function() {
//        var password = $('#recover_pwd').val();
//        var reg_pwd_re = $('#recover_re_pwd').val();
//        debugger;
//        if (!reg_pwd_re) {
//            register_flag = false;
//            recover_flag = false;
//            return;
//        }
//        if (password != reg_pwd_re) {
//            $('.error_info_pwd_re').fadeIn(300,function(){
//                $('.error_info_pwd_re').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//        }
//    }
//
//    //检验短信验证码
//    var checkCode = function(code) {
//        var code = code;
//        console.log(code);
//        if (!code) {
//            $('.error_info_code').fadeIn(300,function(){
//                $('.error_info_code').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//        }
//    }
//
//    //检验邀请码
//    var checkInviteCode = function(inviteCode) {
//        var inviteCode = inviteCode;
//        console.log(inviteCode);
//        var reg = /^[0-9]{8}$/;
//        if (!reg.test(inviteCode)) {
//            $('.error_info_code').fadeIn(300,function(){
//                $('.error_info_code').fadeOut(3000);
//            });
//            register_flag = false;
//            recover_flag = false;
//        } else {
//            register_flag = true;
//            recover_flag = true;
//        }
//    }
//
//});
//
//
//
