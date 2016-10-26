package com.water.tools.bank;

import com.water.tools.msg.HttpRequestUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
public final class BankUtil {

    //参数信息
    private static String API_URL = "http://v.juhe.cn/verifybankcard4/query";
    private static String APP_KEY = "636a0419eb0ae1958dc2e77da2a43c55";


    /**
     * 银行卡认证、绑定验证
     * @param realName      银行开户名
     * @param idCard        身份证
     * @param bankcardno    银行卡ID
     * @param tel           银行卡预留手机号码
     * @return
     * @throws Exception
     */
    public static String checkBankInfo(String realName, String idCard, String bankcardno,String tel) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("key",APP_KEY);
//        params.put("realname",realName);
        params.put("idcard",idCard);
//        params.put("bankcard",bankcardno);
//        params.put("mobile",tel);

        String resultJson = HttpRequestUtil.postRequest(API_URL,params);

        return resultJson;
    }

    public static void main(String args[]) {
        String result = checkBankInfo("张淼洁","441522199312010638","6217007200040634571","15017916946");
        System.out.println("result = " + result);
    }
}
