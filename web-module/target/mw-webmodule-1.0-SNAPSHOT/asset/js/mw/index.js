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




});