/**
 * Created by Administrator on 2016/9/2.
 */
$(document).ready(function() {
    $('.selectbox li em').click(function(){
        $(this).addClass('active').siblings().removeClass('active')
    });

    $( ".listbox li" ).click(function(){
        var iclass=$(this).children('i');
        if(iclass.hasClass('up')){
            iclass.removeClass('up').addClass('down');
        }else if(iclass.hasClass('down')){
            iclass.removeClass('down').addClass('up');
        }else{
            iclass.addClass('up');
        }
    });

    /**新手专区，理财专区，点击事件*/
    $(".selectbox .left").find("a").each(function() {
        $(this).bind("click",function() {
            //添加,移除样式
            $(this).addClass('active').siblings().removeClass('active');
        });
    });
});