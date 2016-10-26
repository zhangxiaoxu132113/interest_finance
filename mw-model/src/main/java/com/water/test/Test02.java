package com.water.test;

/**
 * Created by Administrator on 2016/10/14.
 */
public class Test02 {

    public static void main(String[]args) {
//        String osName = System.getProperties().getProperty("os.name");
//        if (osName.contains("Windows"))
//            System.out.println(osName);
        int term = 7;
        if (term % 30 == 0) {
            int time = term / 30 ;
            System.out.println(time + "个月");
        } else {

            System.out.println(term+"天");
        }
    }
}
