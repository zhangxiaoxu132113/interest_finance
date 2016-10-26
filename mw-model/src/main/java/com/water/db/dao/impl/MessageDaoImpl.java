package com.water.db.dao.impl;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.water.db.dao.IMessageDao;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/16.
 */
@Repository(IMessageDao.SERVICE_NAME)
public class MessageDaoImpl extends BaseDaoImpl implements IMessageDao {

    @Override
    public Map<String, Object> findUserByPhoneNum(String tel_phone) {

        String select_sql = "SELECT * FROM t_user WHERE  USERNAME = ?";
        List<Map<String, Object>> userList = this.queryForList(select_sql, new Object[]{tel_phone});
        if (userList != null && userList.size() > 0) {
            //TODO
            return userList.get(0);
        }
        return null;

    }

    @Override
    public int saveVerificationCode(String tel_phone, String randomCode) {
        final String ADD_USER_SQL = "INSERT INTO t_code (TEL_PHONE, RANDOM_CODE,CREATEON) VALUES (?,?,?)";
        int autoIncId = 0;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //保存当前时间加上2分钟
        Date date = new Date();
        long two_minute = 2 * 60 * 1000;
        Timestamp timestamp = new Timestamp(date.getTime() + two_minute);
        jdbcTemplate.update(new PreparedStatementCreator(){
                                @Override
                                public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                                    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS);
                                    ps.setString(1, tel_phone);
                                    ps.setString(2, randomCode);
                                    ps.setTimestamp(3,timestamp);
                                    return ps;
                                }
                            },
                keyHolder);

        autoIncId = keyHolder.getKey().intValue();
        System.out.println("autoIncId = " + autoIncId);
        return autoIncId;
    }

    @Override
    public Map<String,Object> checkVericationCode(String tel_phone, String randomCode) {

        Map<String, Object> returnMap = null;
        String CHECK_SQL = "select timestampdiff(second,now(),code.createon) as diff_time" +
                " from t_code as code where code.tel_phone = ? and random_code = ?";
        List<Map<String,Object>> results = this.queryForList(CHECK_SQL, new Object[]{tel_phone,randomCode});
        if (results != null && results.size()==1) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public void deleteCodeData(String tel_phone) {
        String DELETE_SQL = "DELETE FROM t_code WHERE tel_phone = ?";
        this.deleteData(DELETE_SQL,new Object[]{tel_phone});
    }
}
