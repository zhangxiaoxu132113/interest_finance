package com.water.tools.msgUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/10/10.
 */
public class HttpSenderTest {
    public static void main(String[] args) {
        String url = "http://sapi.253.com/msg/";// 应用地址
        String account = "vip-fjl168";// 账号
        String pswd = "Tch88888";// 密码
        String phone = "18124016607";// 手机号码，多个号码使用","分割
        String msg = "【艾德信】您的注册验证码为1234，该验证码10分钟内有效。如非本人操作请忽略此短信！";// 短信内容
        boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
        String extno = null;// 扩展码

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
            System.out.println("resultMap:"+resultMap);

            // TODO 处理返回值,参见HTTP协议文档
        } catch (Exception e) {
            // TODO 处理异常
            e.printStackTrace();
        }
    }
}

