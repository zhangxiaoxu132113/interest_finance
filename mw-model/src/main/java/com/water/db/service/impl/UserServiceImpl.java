package com.water.db.service.impl;

import com.water.db.dao.IUserDao;
import com.water.db.entry.EmpInfo;
import com.water.db.entry.User2BidInfo;
import com.water.db.service.ISystemDDLService;
import com.water.db.service.IUserService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by mrwater on 16/6/4.
 */
@Service(IUserService.SERVICE_NAME)
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

    @Resource(name = IUserDao.SERVICE_NAME)
    private IUserDao userDao;

    @Resource(name = ISystemDDLService.SERVICE_NAME)
    private ISystemDDLService systemDDLService;

    /**
     * @author      Zhang Miaojie
     * @description 登录授权
     * @time        2016-08-15
     */
    @Override
    public Map<String, Object> findUserByNameAndPwd(String username, String pwd) {
        MWStringUtils.isBlank(username,pwd);
        Map<String,Object> userMap = userDao.findUserByNameAndPwd(username,pwd);

        return userMap;
    }

    /**
     * @author      Meng Sheng
     * @description 根据用户的ID查询用户
     * @time        2016-08-25
     * @param       userId;
     */
    @Override
    public Map<String,Object> findUserByUserId(int userId){
        MWStringUtils.isBlank(userId);
        Map<String,Object> userMap = userDao.findUserByUserId(userId);
        return userMap;
    }

    @Override
    public boolean findUserByTelphone(String tel_phone) {

        MWStringUtils.isBlank(tel_phone);
        Map<String,Object> userMap = userDao.findUserByTelphone(tel_phone);
        if (userMap != null) return true;
        return false;
    }

    @Override
    public Map<String,Object> findUserByTel(String tel_phone) {

        MWStringUtils.isBlank(tel_phone);
        Map<String,Object> userMap = userDao.findUserByTelphone(tel_phone);
        return userMap;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean saveUser(Map<String, Object> userMap) {
        if (userMap == null) {
            throw new RuntimeException("对象不能为空！");
        }
        int autoIncId = userDao.saveUser(userMap);
        if (autoIncId < 0) {
            return false;
        }
        //删除数据库的验证码
        userDao.deleteCodeData((String) userMap.get("USERNAME"));
        return true;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void recordLoginLog(int userId) {
        userDao.recordLoginLog(userId);
    }


    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean updatePwdByTelphone(String tel_phone, String pwd) {

        MWStringUtils.isBlank(tel_phone,pwd);
        int resultCode = userDao.updatePwdByTelphone(tel_phone,pwd);
        System.out.println("resultCode = "+resultCode);

        return true;
    }

    @Override
    public Map<String, Object> findEmpInfoByUserNameAndPwd(String username, String password) {

        MWStringUtils.isBlank(username,password);
        Map<String,Object> empInfo =  userDao.findEmpInfoByUserNameAndPwd(username, password);
        return empInfo;
    }

    @Override
    public boolean addEmpInfo(EmpInfo empInfo) {
        if (empInfo == null) {
            throw new RuntimeException("对象不能为空！");
        }

        int effectRows = userDao.addEmpInfo(empInfo);
        if (effectRows != -1) return true;
        return false;
    }

    @Override
    public List<Map<String,Object>> findEmpInfoList() {

        List<Map<String,Object>> empInfoList = userDao.findEmpInfoList();
        List<Map<String,Object>> departmentList = systemDDLService.findDepartmentList();
        List<Map<String,Object>> jobNameList = systemDDLService.findJobName();

        //定义要输出的集合
        List<Map<String,Object>> newEmpInfoList = new ArrayList<Map<String,Object>>();

        if (empInfoList != null && empInfoList.size() > 0) {
            for (Map<String, Object> empInfo : empInfoList) {

                int departmentId = (Integer) empInfo.get("DEPARTMEN_ID");
                int jobId = (Integer) empInfo.get("JOB");

                //遍历部门列表信息
                if (departmentList != null && departmentList.size() > 0) {
                    for (Map<String,Object> department : departmentList) {
                        int ddlCode = (Integer) department.get("DEPARTMEN_ID");
                        if (departmentId == ddlCode) {
                            empInfo.put("DEPARTMENT",department.get("DEPARTMEN_NAME"));
                        }
                    }
                }

                //遍历工作职业信息
                if (jobNameList != null && jobNameList.size() > 0) {
                    for (Map<String,Object> jobName : jobNameList) {
                        int ddlCode = (Integer) jobName.get("DDLCODE");
                        if (jobId == ddlCode) {
                            empInfo.put("JOB_NAME",jobName.get("DDLNAME"));
                        }
                    }
                }

                //添加到集合中
                newEmpInfoList.add(empInfo);
            }
        }
        return newEmpInfoList;
    }

    @Override
    public boolean deleteEmpInfoById(int itemId) {

        int effectRows = userDao.deleteEmpInfoById(itemId);
        if (effectRows != -1) return true;
        return false;
    }

    @Override
    public boolean addPopem(String role_name, String role_flag) {

        MWStringUtils.isBlank(role_name,role_flag);
        int effectRows = userDao.addPopem(role_name,role_flag);
        if (effectRows != -1) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findTelphoneByCondition(String telPhone) {

        MWStringUtils.isBlank(telPhone);
        return userDao.findTelphoneByCondition(telPhone);
    }

    @Override
    public boolean addRebate(User2BidInfo user2BidInfo) {

        if (user2BidInfo == null) throw new RuntimeException("对象不能为空！");
        int effectRows = userDao.addRebate(user2BidInfo);
        if (effectRows != -1) {
            //修改用户的账户金额
            userDao.modifyUserCapital(user2BidInfo.getUserId(),user2BidInfo.getSelfPlatformReveue());
            return true;
        }
        return false;
    }

    @Override
    public Map<String,Object> findUserLogByUid(int userId){
        MWStringUtils.isBlank(userId);
        Map<String,Object> resultMap = userDao.findUserLogByUid(userId);
        return resultMap;
    }

    @Override
    public boolean updateUserInviteCodeByUid(String inviteCode, int userId){

        MWStringUtils.isBlank(inviteCode,userId);
        int count = userDao.updateUserInviteCodeByUid(inviteCode, userId);
        if(count > 0){
            return true;
        }
        return false;
    }

}
