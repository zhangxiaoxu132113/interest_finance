//package com.water.tools.toPlatUtil;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Meng Sheng on 2016/9/7.
// * 调用第三方接口获取相关信息
// */
//public class toPlatformUtil {
//
//
//    /**
//     * 到第三方平台注册
//     * @author  Meng Sheng
//     * @param   tellPhone  用于注册的手机号码
//     * @return  返回注册状态【注册成功（0）;账号已注册（1）;系统异常，注册失败（-1）】
//     */
//    public static Map<String,String> toPlatRegister(String tellPhone){
//        Map<String,String> result = new HashMap<String,String>();
//        //TODO
//        //调用第三方接口，注册用户
////        System.out.println("注册成功!");
//        result.put("status","0");
//
////        System.out.println("注册失败，账号已注册！");
////        result.put("status","1");
////
////        System.out.println("注册失败，系统异常！");
////        result.put("status","-1");
//        return result;
//    }
//
//    /**
//     * 查询用户在第三方平台是否有投资，若有就获取首次投资记录
//     * @author  Meng Sheng
//     * @param   userId  第三方平台用户的ID
//     * @return
//     */
//    public static List<Map<String,Object>> queryTenderByUid(int userId){
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        //TODO
//        //调用第三方接口，查询该用户是否有投资
//        Map<String,Object> result1 = new HashMap<String,Object>();
//        result1.put("ID","1");//ID
//        result1.put("USERID",userId);//用户ID
//        result1.put("ORDER_NUMBER","2016090700100");//订单号
//        result1.put("INVESTMENT_AMOUNT","20000");//投资金额
//        result1.put("INTEREST_RATE_COUPON","2%");//加息劵
//        result1.put("PLATFORM_REVENUE","15%");//平台收益
//        result1.put("CREATEDON","2016-09-07 14:05:25");//创建时间
//        result1.put("STATUS","0");//状态   0-冻结；1-返利；2-跳转
//        result1.put("FREEZING_TIME","2016-09-07 15:05:25");//冻结时间
//        result1.put("RETURN_TIME","2016-09-09 19:25:15");//返利时间
//
//        Map<String,Object> result2 = new HashMap<String,Object>();
//        result2.put("ID","2");//ID
//        result2.put("USERID",userId);//用户ID
//        result2.put("ORDER_NUMBER","2016091315246");//订单号
//        result2.put("INVESTMENT_AMOUNT","30000");//投资金额
//        result2.put("INTEREST_RATE_COUPON","3%");//加息劵
//        result2.put("PLATFORM_REVENUE","11%");//平台收益
//        result2.put("CREATEDON","2016-09-13 21:25:05");//创建时间
//        result2.put("STATUS","0");//状态   0-冻结；1-返利；2-跳转
//        result2.put("FREEZING_TIME","2016-09-14 11:45:20");//冻结时间
//        result2.put("RETURN_TIME","2016-09-18 21:12:10");//返利时间
//
//        resultList.add(result1);
//        resultList.add(result2);
//        return resultList;
//    }
//
//    /**
//     * 查询用户在第三方平台所投的标记录信息
//     * @author  Meng Sheng
//     * @param   userId  第三方平台用户的ID
//     * @param   bid     所投的标的ID
//     * @return
//     */
//    public static Map<String,Object> queryTenderByUidAndBid(int userId, int bid){
//        Map<String,Object> result = new HashMap<String,Object>();
//        //TODO
//        //调用第三方接口，查询该用户所投的标的具体记录
//        result.put("ID","1");//ID
//        result.put("USERID",userId);//用户ID
//        result.put("BIDID",bid);//标的ID
//        result.put("ORDER_NUMBER","2016090700100");//订单号
//        result.put("INVESTMENT_AMOUNT","20000");//投资金额
//        result.put("INTEREST_RATE_COUPON","2%");//加息劵
//        result.put("PLATFORM_REVENUE","15%");//平台收益
//        result.put("CREATEDON","2016-09-07 14:05:25");//创建时间
//        result.put("STATUS","0");//状态   0-冻结；1-返利；2-跳转
//        result.put("FREEZING_TIME","2016-09-07 15:05:25");//冻结时间
//        result.put("RETURN_TIME","2016-09-09 19:25:15");//返利时间
//
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//
//        List<Map<String,Object>> res_userId = queryTenderByUid(10001);
//        System.out.println("结果："+res_userId.get(0));
//
//        Map<String,Object> res = queryTenderByUidAndBid(100001,20001);
//        System.out.println("返回结果："+res);
//    }
//}
