package com.water.tools.implUtil;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/10/17.
 */
public class SendRequestUtil {


    /**
     * @param url   资源地址
     * @param map   参数列表
     * @return  code 状态码
     */
    public static String sendRequest(String url,Map<String,Object> map){

        Map<String,Map<String,Object>> result = new HashMap<>();
        String code = "";
        try {
            String rep = HttpClientUtils.send(url, map);
            System.out.println("交易响应结果："+rep);
            //将json格式转换为Map对象
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(rep,Map.class);
            code = result.get("response").get("code").toString();/**返回的状态码*/
        } catch (Exception e) {
            // TODO 处理异常
            e.printStackTrace();
            return null;
        }
        return code;
    }


    public static Map<String,Object> mapUtil(Map<String,Object> map, String tell){


        //将参数params格式为json的转换为Map对象
        Map<String,String> params_map = new HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            params_map = mapper.readValue((String)map.get("PARAMS"),Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用第三方接口，将请求参数封装为Map对象
        Map<String,Object> request_map = new HashMap<>();

        for (String key : params_map.keySet()) {
            if(key.equals("phone")){
                request_map.put(key,tell);
            }
        }

        //邀请码(固定)
        request_map.put(params_map.get("inivte_code"),map.get("APPKEY"));

        return request_map;
    }


}
