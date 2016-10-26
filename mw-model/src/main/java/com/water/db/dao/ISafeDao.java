package com.water.db.dao;

import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
public interface ISafeDao extends IBaseDao {
    String SERVICE_NAME = "com.water.db.dao.impl.SafeDaoImpl";

    /**
     * @author      MengSheng
     * @descrition  实名认证，插入真实姓名
     * @time        2016-09-22
     * @param realname
     * @param userId
     */
    int updateRealNameByUid(String realname, int userId);

    /**
     * @author      MengSheng
     * @descrition  手机认证，更新手机号码
     * @time        2016-09-22
     * @param phone
     * @param userId
     */
    int updateRzTellPhoneByUid(String phone, int userId);

    /**
     * @author      MengSheng
     * @descrition  修改登录密码
     * @time        2016/8/17
     * @param password
     * @param userId
     */
    int updatePwdByUid(String password, int userId);

    /**
     * @author      MengSheng
     * @descrition  修改支付密码
     * @time        2016/8/17
     * @param payPassword
     * @param userId
     */
    int updatePayPwdByUid(String payPassword, int userId);

    /**
     * @author      MengSheng
     * @descrition  验证登录密码
     * @time        2016/8/17
     * @param password
     * @param userId
     */
    Map<String,Object> findPwdByUid(String password, int userId);

    /**
     * @author      MengSheng
     * @descrition  验证支付密码
     * @time        2016/8/17
     * @param payPassword
     * @param userId
     */
    Map<String,Object> findPayPwdByUid(String payPassword, int userId);
}
