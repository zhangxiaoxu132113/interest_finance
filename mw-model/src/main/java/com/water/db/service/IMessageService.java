package com.water.db.service;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/16.
 */
public interface IMessageService {

    String SERVICE_NAME = "com.water.db.service.impl.MessageServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 根据手机号码来查找用户
     * @time        2016-08-16
     * @return      Map<String,Object> 用户map数据
     */
    Map<String,Object> findUserByTelPhone(String tel_phone);

    /**
     * @author      Zhang Miaojie
     * @description 将用户的验证码和手机号保存到数据库中
     * @time        2016-08-17
     * @return
     */
    void saveVerificationCode(String tel_phone,String randomCode);

    /**
     * @author      Zhang Miaojie
     * @description 验证用户输入的注册验证码是否正确
     * @time        2016-08-17
     * @return
     */
    boolean checkVericationCode(String tel_phone, String verification_code);

    /**
     * @author      Zhang Miaojie
     * @description 根据电话号码删除验证码表的记录
     * @time        2016-08-18
     * @return
     */
    void deleteCodeData(String tel_phone);



}
