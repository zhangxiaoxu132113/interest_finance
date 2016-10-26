package com.water.db.dao.impl;

import com.water.db.dao.ISafeDao;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
@Repository(ISafeDao.SERVICE_NAME)
public class SafeDaoImpl extends BaseDaoImpl implements ISafeDao{

    @Override
    public int updateRzTellPhoneByUid(String phone, int userId){
        String querySQL = "update t_user set TELLPHONE = ? , IS_TEL_STATUS = 1 where USERID = ?";
        return this.updateData(querySQL,new Object[]{phone,userId});
    }

    @Override
    public int updateRealNameByUid(String realname, int userId){
        String querySQL = "update t_user set REALNAME = ? , IS_AUTH_STATUS = 1 where USERID = ?";
        return this.updateData(querySQL,new Object[]{realname,userId});
    }

    @Override
    public int updatePwdByUid(String password,int userId){
        String querySQL = "update t_user set PASSWORD = ? where USERID = ?";
        return this.updateData(querySQL,new Object[]{password,userId});
    }

    @Override
    public int updatePayPwdByUid(String payPassword,int userId){
        String querySQL = "update t_user set PAYPASSWORD = ?,IS_PAYPWD_STATUS=1 where USERID = ?";
        return this.updateData(querySQL,new Object[]{payPassword,userId});
    }

    @Override
    public Map<String,Object> findPwdByUid(String password,int userId){
        String querySQL = "select * from t_user u where u.PASSWORD = ? and u.USERID = ?";
        Map<String,Object> results = this.queryForMap(querySQL,new Object[]{password,userId});
        return results;
    }

    @Override
    public Map<String,Object> findPayPwdByUid(String payPassword,int userId){
        String querySQL = "select * from t_user u where u.PAYPASSWORD = ? and u.USERID = ?";
        Map<String,Object> results = this.queryForMap(querySQL,new Object[]{payPassword,userId});
        return results;
    }
}
