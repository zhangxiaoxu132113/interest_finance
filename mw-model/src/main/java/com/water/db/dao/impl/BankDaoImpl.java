package com.water.db.dao.impl;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.water.db.dao.IBankDao;
import com.water.db.entry.BankInfo;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
@Repository(IBankDao.SERVICE_NAME)
public class BankDaoImpl extends BaseDaoImpl implements IBankDao {

    @Override
    public int bindBankCard(BankInfo bankInfo) {
        final String ADD_SQL = "INSERT INTO t_bank_card (USER_ID,ACCOUNT_NAME, CARDID,BANK_CARD_NO,BANK_CODE,BANK_BRANCH,CREATETIME) VALUES (?,?,?,?,?,?,?)";
        int autoIncId = 0;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( new PreparedStatementCreator(){
                                 @Override
                                 public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                                     PreparedStatement ps = (PreparedStatement) conn.prepareStatement(ADD_SQL, Statement.RETURN_GENERATED_KEYS);
                                     ps.setInt(1, bankInfo.getUserId());
                                     ps.setString(2, bankInfo.getAccountName());
                                     ps.setString(3, bankInfo.getCardId());
                                     ps.setString(4, bankInfo.getBankCardId());
                                     ps.setInt(5, bankInfo.getBankCode());
                                     ps.setString(6, bankInfo.getBankBranch());
                                     ps.setTimestamp(7, bankInfo.getCreateTime());
                                     return ps;
                                 }
                             },
                keyHolder);

        autoIncId = keyHolder.getKey().intValue();
        return autoIncId;
    }

    @Override
    public int updateUserBankCardStatus(int userId, int bind_status){
        String querySQL = "update t_user set IS_BIND_BANKCARD = ? where USERID = ?";
        return this.updateData(querySQL,new Object[]{bind_status,userId});
    }

    @Override
    public List<Map<String,Object>> findBankCardByUid(int userId){
        String querySQL = "select * from t_bank_card where USER_ID =?";
        return this.queryForList(querySQL,new Object[]{userId});
    }
}
