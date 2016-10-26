//package com.water.tools.lang;
//
//import java.util.Random;
//
///**
// * Created by Meng Sheng on 2016/9/20.
// * 工具类
// */
//public final class Utility {
//
//    private Utility(){}
//
//    /**
//     * 设置用户的专属邀请码
//     * @return
//     */
//    public static String getUserInviteCode(){
//        String code_source="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ0123456789";
//        Random random = new Random();
//        String random_code="";
//        //获取随机的5位数的验证码
//        for(int i=0;i<5;i++){
//            String ch=String.valueOf(code_source.charAt(random.nextInt(code_source.length())));
//            random_code+=ch;
//        }
//        //获取一个当前系统时间毫秒数
//        String current_time = Long.toString(System.currentTimeMillis());
//        //截取后3位
//        String time_Code = current_time.substring(current_time.length() - 3, current_time.length());
//        //邀请码(8位)为后5位+随机3位数字
//        String inviteCode = time_Code + random_code;
//        return inviteCode;
//    }
//
//    public static void main(String[]args) {
//        String inviteCode = getUserInviteCode();
//        System.out.println("inviteCode : "+inviteCode);
//    }
//
//}
//
