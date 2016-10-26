package com.water.tools.implUtil;

/**
 * Created by Meng Sheng on 2016/10/17.
 * 简单HttpClient实例
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    /**
     * @param url       资源地址
     * @param map   参数列表
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, Map<String,Object> map) throws ParseException, IOException{
        String res = "";
        String encoding = "utf-8";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), (String)entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            res = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return res;
    }

    public static void main(String[] args) throws ParseException, IOException {

        String url="http://www.fujinli.com/api/customer/isExists.html";
        String phone  = "15017916946";
        String requester  = "579eecd3d5a36";//邀请码（固定）
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        //邀请码（固定）
        map.put("requester", requester);
        String res = send(url, map);
        System.out.println("交易响应结果：");
        System.out.println(res);


        //将json格式转换为Map对象
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resultJson = mapper.readValue(res,Map.class);
        System.out.println(resultJson);

    }
}
