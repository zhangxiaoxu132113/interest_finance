package com.water.db.service;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
public interface ISafeService {

    String SERVICE_NAME = "com.water.db.service.impl.SafeServiceImpl";

    /**
     * @author      MengSheng
     * @descrition  手机认证，更新手机号码
     * @time        2016-09-22
     * @param phone
     * @param userId
     */
    boolean updateRzTellPhoneByUid(String phone, int userId);

    /**
     * @author      MengSheng
     * @descrition  实名认证，插入真实姓名
     * @time        2016-09-22
     * @param realname
     * @param userId
     */
    boolean updateRealNameByUid(String realname, int userId);

    /**
     * @author      MengSheng
     * @descrition  修改登录密码
     * @time        2016/8/17
     */
    boolean updatePwdByUid(String password, int userId);

    /**
     * @author      MengSheng
     * @descrition  修改支付密码
     * @time        2016/8/17
     */
    boolean upadatePayPwdByUid(String payPassword, int userId);

    /**
     * @author      MengSheng
     * @descrition  验证登录密码
     * @time        2016/8/17
     * @param password
     * @param userId
     */
    boolean findPwdByUid(String password, int userId);
    /**
     * @author      MengSheng
     * @descrition  验证支付密码
     * @time        2016/8/17
     * @param payPassword
     * @param userId
     */
    boolean findPayPwdByUid(String payPassword, int userId);
}
