package com.water.db.dao;

import com.water.db.entry.EmpInfo;
import com.water.db.entry.User2BidInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
public interface IUserDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.dao.impl.UserDaoImpl";

    /**保存用户信息*/
    int saveUser(final Map<String, Object> userMap);

    /**根据账号和密码查询用户信息*/
    Map<String,Object> findUserByNameAndPwd(String username, String pwd);

    /**根据用户ID查询用户信息*/
    Map<String,Object> findUserByUserId(int userId);

    /**记录用户登录时间*/
    void recordLoginLog(int userId);

    /**根据电话号码删除验证码保存表的记录*/
    void deleteCodeData(String tel_phone);

    /**根据用户名更新用户的密码*/
    int updatePwdByTelphone(String tel_phone, String pwd);

    /**根据手机号码查找用户的信息*/
    Map<String,Object> findUserByTelphone(String tel_phone);

    /**根据用户名和密码查找员工的信息*/
    Map<String, Object> findEmpInfoByUserNameAndPwd(String username, String password);

    /**添加员工信息*/
    int addEmpInfo(EmpInfo empInfo);

    /**查询员工列表信息*/
    List<Map<String,Object>> findEmpInfoList();

    /**删除员工信息*/
    int deleteEmpInfoById(int itemId);

    /**添加用户组*/
    int addPopem(String role_name,String role_flag);

    /**根据条件来查询*/
    List<Map<String,Object>> findTelphoneByCondition(String telPhone);

    /**添加投标记录*/
    int addRebate(User2BidInfo user2BidInfo);

    /**修改账号总额*/
    int modifyUserCapital(int userId, BigDecimal money);

    /**修改账号总额*/
    Map<String,Object> findUserLogByUid(int userId);

    /**添加用户邀请码*/
    int updateUserInviteCodeByUid(String inviteCode, int userId);
}
