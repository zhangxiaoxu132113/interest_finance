package com.water.db.dao.impl;

import com.water.db.dao.ITransactionDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/15.
 */
@Repository(ITransactionDao.SERVICE_NAME)
public class TransactionDaoImpl extends BaseDaoImpl implements ITransactionDao {

    @Override
    public int saveTransaction(int userId, int amount, int amount_type, int trans_status, String remark ,Timestamp createTime ){
        String querySQL = "insert into t_transaction_detail (USERID,AMOUNT,AMOUNT_TYPE,TRANS_STATUS,REMARK,CREATETIME) values (?,?,?,?,?,?)";
        return this.insertData(querySQL,new Object[]{userId,amount,amount_type,trans_status,remark,createTime});
    }

    @Override
    public int updateUserTotalaccountByUid(BigDecimal totalaccount, int userId){
        String querySQL = "update t_user set TOTALACCOUNT =? where USERID =?";
        return this.updateData(querySQL,new Object[]{totalaccount,userId});
    }

    @Override
    public List<Map<String,Object>> findTransactionsByUid(int userId){
        String querySQL = "SELECT ub.*, inv.P_NAME, bid.`NAME` as BID_NAME, bid.TERM FROM "
                        + " t_user_bid ub, t_investmentplatform inv,t_bid bid"
                        + " WHERE ub.USERID = ? AND ub.PLATFORMID = inv.ID AND ub.BIDID = bid.ID";
        return this.queryForList(querySQL,new Object[]{userId});
    }

    @Override
    public int deleteTransactionByUidAndTid(int userId, int Tid){
        String querySQL = "delete from t_transaction_detail where USERID = ? and Id = ?";
        return this.deleteData(querySQL,new Object[]{userId,Tid});
    }

    @Override
    public Map<String, Object> findInvestmentDetailByUid(int userId) {

        String SELECT_SQL = "SELECT COUNT(DISTINCT ub.PLATFORMID) as platformAcount," +
                " COUNT(DISTINCT ub.BIDID) bidAcount," +
                " SUM(ub.SELF_PLATFORM_REVENUE) as selfPlatformProfit," +
                " SUM(ub.SELF_PLATFORM_REVENUE + PLATFORM_REVENUE) as platformProfit" +
                " FROM t_user_bid ub where ub.USERID = ? ";
        return this.queryForMap(SELECT_SQL,new Object[]{userId});
    }


}
