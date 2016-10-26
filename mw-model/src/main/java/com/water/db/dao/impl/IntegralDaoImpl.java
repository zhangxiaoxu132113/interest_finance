package com.water.db.dao.impl;

import com.water.db.dao.IIntegralDao;
import com.water.tools.lang.GlobalUtil;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/19.
 */
@Repository(GlobalUtil.INTEGRAL_DAO)
public class IntegralDaoImpl extends BaseDaoImpl implements IIntegralDao {

    @Override
    public int saveIntegral(int userId,int score,int score_type,String source,int available_integral,int total_integral,Timestamp createTime){
        String querySQL = "insert into t_user_integral (USERID,SCORE,SCORE_TYPE,SOURCE,AVAILABLE_INTEGRAL,TOTAL_INTEGRAL,CREATETIME) values (?,?,?,?,?,?,?)";
        return this.insertData(querySQL,new Object[]{userId,score,score_type,source,available_integral,total_integral,createTime});
    }

    @Override
    public List<Map<String,Object>> findIntegralByUid(int userId){
        String querySQL = "select * from t_user_integral where USERID = ? ORDER BY CREATETIME DESC ";
        return this.queryForList(querySQL,new Object[]{userId});
    }

    @Override
    public Map<String,Object> findLatestIntegralByUid(int userId){
        String querySQL = "select * from t_user_integral where ID = (select max(id) from t_user_integral where USERID =?)";
        return this.queryForMap(querySQL,new Object[]{userId});
    }

    @Override
    public Map<String,Object> findIntegralMonthByUid(int userId,Timestamp startDate,Timestamp endDate){
        String querySQL = "select ifnull(SUM(score),0) as sumMonthIntegral from t_user_integral where SCORE_TYPE = 1 and USERID = ? and CREATETIME BETWEEN ? and ? ";
        return this.queryForMap(querySQL,new Object[]{userId,startDate,endDate});
    }

    @Override
    public Map<String,Object> findSumIntegralByUid(int userId){
        String querySQL = "select sum(score) as sumScore from t_user_integral where SCORE_TYPE = 1 and USERID =?";
        return this.queryForMap(querySQL,new Object[]{userId});
    }

}
