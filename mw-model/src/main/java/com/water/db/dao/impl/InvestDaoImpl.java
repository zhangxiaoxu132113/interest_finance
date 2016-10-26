package com.water.db.dao.impl;

import com.water.db.dao.IInvestDao;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 */
    @Repository(IInvestDao.SERVICE_NAME)
public class InvestDaoImpl extends BaseDaoImpl implements IInvestDao {

    @Override
    public int savePlatformRelation(int userId, int platformId){
        String querySQL = "insert into t_platform_relation (USERID,PLATFORMID,CREATETIME) values (?,?,?)";
        Timestamp createTime = new Timestamp(new Date().getTime());
        return this.insertData(querySQL,new Object[]{userId,platformId,createTime});
    }

    @Override
    public Map<String,Object> findPlaRelaByUIdAndPId(int userId, int platformId){
        String querySQL = "select * from t_platform_relation where USERID = ? and PLATFORMID = ?";
        return this.queryForMap(querySQL,new Object[]{userId,platformId});

    }

}
