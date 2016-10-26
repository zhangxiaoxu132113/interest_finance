package com.water.tools.lang;

import java.util.Random;

/**
 * Created by Administrator on 2016/8/16.
 */
public final class RandomUtils {

    private RandomUtils(){}
    /**
     * 获取随机的验证码
     * @param charCount 要获取的验证数的长度
     * @return
     */
    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    public static void main(String[]args) {
        String randomCode = getRandNum(6);
        System.out.println("randomCode : "+randomCode);
    }

}
