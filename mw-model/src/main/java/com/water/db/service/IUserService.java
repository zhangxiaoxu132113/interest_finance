package com.water.db.service;

import com.water.db.entry.EmpInfo;
import com.water.db.entry.User2BidInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
public interface IUserService {

    String SERVICE_NAME = "com.water.db.service.impl.UserServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 登录授权
     * @time        2016-08-15
     */
    Map<String,Object> findUserByNameAndPwd(String username, String pwd);

    /**
     * @author      Meng Sheng
     * @description 根据用户的ID查询用户
     * @time        2016-08-25
     * @param       userId;
     */
    Map<String,Object> findUserByUserId(int userId);

    /**
     * @author      Zhang Miaojie
     * @description 根据用户的手机号码查找用户
     * @time        2016-08-16
     */
    boolean findUserByTelphone(String tel_phone);

    Map<String,Object> findUserByTel(String tel_phone);

    /**
     * @author      Zhang Miaojie
     * @description 用户注册
     * @time        2016-08-16
     */
    boolean saveUser(Map<String, Object> userMap);

    /**
     * @author      Zhang Miaojie
     * @description 记录用户登录信息
     * @time        2016-08-17
     */
    void recordLoginLog(int userId);

    /**
     * @author      Zhang Miaojie
     * @description 更新用户的密码
     * @time        2016-08-16
     * @return
     */
    boolean updatePwdByTelphone(String tel_phone, String pwd);

    /**
     * @author      Zhang Miaojie
     * @descrition  根据账号和密码查找是否存在用户
     * @time        2016/09/06
     */
    Map<String,Object> findEmpInfoByUserNameAndPwd(String username,String password);

    /**
     * @author      Zhang Miaojie
     * @descrition  添加后台管理员的信息
     * @time        2016/09/08
     */
    boolean addEmpInfo(EmpInfo empInfo);

    /**
     * @author      Zhang Miaojie
     * @descrition  查询员工列表信息
     * @time        2016/09/09
     */
    List<Map<String,Object>> findEmpInfoList();

    /**
     * @author      Zhang Miaojie
     * @descrition  删除员工信息
     * @time        2016/09/09
     */
    boolean deleteEmpInfoById(int itemId);

    /**
     * @author      Zhang Miaojie
     * @descrition  添加权限信息
     * @time        2016/09/12
     */
    boolean addPopem(String role_name, String role_flag);

    /**根据条件来查询*/
    List<Map<String,Object>> findTelphoneByCondition(String telPhone);

    /**添加投标记录*/
    boolean addRebate(User2BidInfo user2BidInfo);

    /**修改账号总额*/
    Map<String,Object> findUserLogByUid(int userId);

    /**添加用户邀请码*/
    boolean updateUserInviteCodeByUid(String inviteCode, int userId);
}
