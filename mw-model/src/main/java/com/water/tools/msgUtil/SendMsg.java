package com.water.tools.msgUtil;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/10/10.
 */
public class SendMsg {

    //参数信息
    private static String url = "http://sapi.253.com/msg/";// 应用地址
    private static String account = "vip-fjl168";// 账号
    private static String pswd = "Tch88888";// 密码
    private static boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
    private static String extno = null;// 扩展码

    /**
     *
     * 发送手机验证码
     * @author Zhang Miaojie
     * @param phone      手机号码
     * @param msg_code    短信验证码
     */
    public static Map<String,Object> sendMsgCode(String phone,  String msg_code){
        String msg = "【艾德信】您的验证码为"+msg_code+"，该验证码10分钟内有效。如非本人操作请忽略此短信！";// 短信内容
        try {
            Map<String,Object> resultMap = new HashMap<>();
            String returnStr = HttpSender.batchSend(url, account, pswd, phone, msg, needstatus, extno);
            System.out.println("returnStr:"+returnStr);
            int n = returnStr.indexOf("\n");
            if(n != -1){
                String resptime = returnStr.substring(0,returnStr.indexOf(",")).trim();//resptime
                String respstatus = returnStr.substring(returnStr.indexOf(",")+1,returnStr.indexOf("\n")).trim();//respstatus
                String msgid = returnStr.substring(returnStr.indexOf("\n")+1);//msgid
                resultMap.put("resptime",resptime);
                resultMap.put("respstatus",respstatus);
                resultMap.put("msgid",msgid);
            }else{
                String resptime = returnStr.substring(0,returnStr.indexOf(",")).trim();//resptime
                String respstatus = returnStr.substring(returnStr.indexOf(",")+1).trim();//respstatus
                resultMap.put("resptime",resptime);
                resultMap.put("respstatus",respstatus);
            }
            System.out.println("resultMap:" + resultMap);

            // TODO 处理返回值,参见HTTP协议文档
            return resultMap;
        } catch (Exception e) {
            // TODO 处理异常
            e.printStackTrace();
            return null;
        }
    }


}
