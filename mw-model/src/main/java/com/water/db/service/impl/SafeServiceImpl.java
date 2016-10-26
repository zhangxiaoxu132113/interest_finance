package com.water.db.service.impl;

/**
 * Created by Meng Sheng on 2016/9/13.
 */

import com.water.db.dao.ISafeDao;
import com.water.db.service.ISafeService;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service(ISafeService.SERVICE_NAME)
@Transactional(readOnly = true)
public class SafeServiceImpl  implements ISafeService{

    @Resource(name = GlobalUtil.SAFE_DAO)
    private ISafeDao safeDao;

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean updateRzTellPhoneByUid(String phone, int userId){

        MWStringUtils.isBlank(phone, userId);
        int resultCode = safeDao.updateRzTellPhoneByUid(phone, userId);
        if (resultCode > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean updateRealNameByUid(String realname, int userId){
        MWStringUtils.isBlank(realname, userId);
        int resultCode = safeDao.updateRealNameByUid(realname, userId);
        if (resultCode > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean updatePwdByUid(String password,int userId) {

        MWStringUtils.isBlank(password, userId);
        int resultCode = safeDao.updatePwdByUid(password, userId);
        if (resultCode > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean upadatePayPwdByUid(String payPassword,int userId){
        MWStringUtils.isBlank(payPassword, userId);
        int resultCode = safeDao.updatePayPwdByUid(payPassword, userId);
        if (resultCode > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean findPwdByUid(String password,int userId){
        MWStringUtils.isBlank(password,userId);
        Map<String,Object> userMap = safeDao.findPwdByUid(password,userId);
        if (userMap != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean findPayPwdByUid(String payPassword,int userId){
        MWStringUtils.isBlank(payPassword,userId);
        Map<String,Object> userMap = safeDao.findPayPwdByUid(payPassword, userId);
        if (userMap != null){
            return true;
        }
        return false;
    }
}
