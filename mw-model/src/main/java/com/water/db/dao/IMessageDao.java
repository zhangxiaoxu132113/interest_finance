package com.water.db.dao;

import java.util.Map;

/**
 * Created by Administrator on 2016/8/16.
 */

public interface IMessageDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.dao.impl.MessageDaoImpl";

    /**根据手机号码查找用户信息*/
    Map<String,Object> findUserByPhoneNum(String tel_phone);

    /**保存验证码信息*/
    int saveVerificationCode(String tel_phone, String randomCode);

    /**检查验证码是否存在*/
    Map<String,Object> checkVericationCode(String tel_phone, String randomCode);

    /**删除验证码*/
    void deleteCodeData(String tel_phone);
}
