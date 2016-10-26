package com.water.tools.lang;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by mrwater on 16/6/4.
 */
public class MWStringUtils {

    /**
     * 判断字符是否为空
     * @param params
     * @return
     */
    public static boolean isBlank(Object ... params){
        if (params == null) {
            throwNullPoint();
        }
        for (Object param : params) {
            if (param instanceof String) {
                if (StringUtils.isBlank((String)param)) {
                    throwContentEmpty();
                }
            }

        }
        return true;
    }

    /*常见的抛出错误抛出信息*/
    public static void throwWrongfulParams(){
        throw new RuntimeException("参数不合法!");
    }

    public static void throwContentEmpty(){
        throw new RuntimeException("参数内容为空!");
    }

    public static void throwNullPoint() {
        throw new RuntimeException("参数对象为空!");
    }

    /**
     * java转换数字以万为单位
     * @param num 要转化的数字
     * @param digit 保留的位数 可传null
     * @return
     */
    public static String conversion(int num, Integer digit) {

        if(num < 10000){
            return num +"";
        }
        String unit = "万";
        double newNum = num / 10000.0;
        if(digit != null){
            String numStr = String.format("%." +digit +"f", newNum);
            return numStr + unit;
        }
        return newNum + unit;
    }

    /**
     * 解决获取参数乱码的问题
     * @param request
     * @param parameterName
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getParameterByRequest(HttpServletRequest request, String parameterName, String encoding) {

        String value = "";
        try {
            value = new String(request.getParameter(parameterName).getBytes("ISO-8859-1"),encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**解决获取参数乱码的问题*/
    public static String getParameterByRequest(HttpServletRequest request, String parameterName) {

        return getParameterByRequest(request,parameterName,"UTF-8");
    }
    /*Test*/
    public static void main(String[]args) {
        System.out.println("转换过后 = " + conversion(9999,0));
    }
}
