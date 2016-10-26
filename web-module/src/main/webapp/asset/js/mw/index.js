/**
 * Created by mrwater on 16/8/29.
 */
$(document).ready(function(){

    //$(function(){
    //    $('.loginwrap').slideUp();
    //});
    $('#login').click(function () {
        $('#loginwrap').show();
        $('.loginwrap').slideDown();
        //location.href = "/user/login.action";
    });
    $('#reg').click(function () {
        $('#regwrap').show();
        $('.loginwrap').slideDown();
        //location.href = "/user/register.action";
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

    /**回车方式实现登录*/
    $('body').keydown(function() {
        if (event.keyCode==13) {      //回车键的键值为13
            $("#log_submit").click(); //调用登录按钮的登录事件
        }
    });
});