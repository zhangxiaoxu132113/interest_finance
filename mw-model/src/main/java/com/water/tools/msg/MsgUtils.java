package com.water.tools.msg;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/16.
 * 调用第三方短信接口API地址：http://www.lanz.com.cn/jiekou_24_68.html
 * 可以看接口说明
 */
public final class MsgUtils {

    //参数信息
    private static String SEND_MESSAGE_URL = "http://www.lanz.net.cn/LANZGateway/DirectSendSMSs.asp";
    private static String UserID = "792753";
    private static String Account = "15017916946";
    private static String Password = "453EE8EE4211E382676CA7D26F75671B312B8F79";
    private static String phone = "15017916946";

    /**
     *
     * 发送手机验证码
     * @author Zhang Miaojie
     * @param phone      手机号码
     * @param randomCode 手机号码随机数
     * @param Content    短信内容，传入null，默认短信内容模板
     * @return 第三方接口回调信息JSON格式
     * @throws IOException
     */
    public static String sendVerificationCode(String phone, String randomCode, String Content) throws IOException
    {


        URL url = new URL(SEND_MESSAGE_URL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GB2312");

        String urlString = "UserID="+UserID+"&Account="+Account+
                "&Password=" + Password +
        "&Content=您的注册验证码为"+randomCode+"，该验证码10分钟内有效。如非本人操作请忽略此短信！【浪驰软件】" +
        "&Phones="+phone+"&ReturnXJ=1";

        urlString = urlString.replace("%","％");
        urlString = urlString.replace("+","＋");
        urlString = urlString.replace(" ","+");


        out.write(urlString);
        out.flush();
        out.close();

        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        //返回的JSON格式
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();

        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null)
        {
            sTotalString += sCurrentLine + "\r\n";
        }
        System.out.println(sTotalString);

        //将json格式转换为Map对象
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultJson = mapper.readValue(sTotalString,Map.class);
        Map<String,Object> json1 = (Map<String,Object>)resultJson.get("LANZ_ROOT");
        String response_status = (String) json1.get("ErrorNum");

        return response_status;
    }

}
