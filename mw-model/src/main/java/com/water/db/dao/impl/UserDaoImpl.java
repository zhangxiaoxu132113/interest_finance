package com.water.db.dao.impl;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.water.db.dao.IUserDao;
import com.water.db.entry.EmpInfo;
import com.water.db.entry.User2BidInfo;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 *
 */
@Repository(IUserDao.SERVICE_NAME)
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    @Override
    public int saveUser(final Map<String, Object> userMap) {
        final String ADD_USER_SQL = "INSERT INTO t_user (USERNAME, PASSWORD, CREATETIME) VALUES (?,?,?)";
        int autoIncId = 0;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( new PreparedStatementCreator(){
                                 @Override
                                 public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                                     PreparedStatement ps = (PreparedStatement) conn.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS);
                                     ps.setString(1, (String) userMap.get("USERNAME"));
                                     ps.setString(2, (String) userMap.get("PASSWORD"));
                                     ps.setTimestamp(3, (Timestamp) userMap.get("CREATETIME"));
                                     return ps;
                                 }
                             },
                keyHolder);

        autoIncId = keyHolder.getKey().intValue();
        return autoIncId;
    }

    @Override
    public Map<String, Object> findUserByNameAndPwd(String username, String pwd) {

        String querySQL = "SELECT u.*,img.IMGURL as headerImg from t_user as u,t_img img" +
                " where u.HEADURLID = img.IMGID and u.USERNAME = ? and u.PASSWORD = ?";
        return this.queryForMap(querySQL,new Object[]{username,pwd});
    }

    /**根据用户ID查询用户信息*/
    @Override
    public Map<String,Object> findUserByUserId(int userId){
        String querySQL = "SELECT u.*,img.IMGURL as headerImg from t_user as u,t_img img" +
                " where u.HEADURLID = img.IMGID and u.USERID = ?";
        return  this.queryForMap(querySQL,new Object[]{userId});
    }

    @Override
    public void recordLoginLog(int userId) {

        String SELECT_SQL = "SELECT timestampdiff(day,logintime,now()) AS diff_time FROM t_login_log where userid = ?";
        List<Map<String,Object>> results = this.queryForList(SELECT_SQL,new Object[]{userId});
        Map<String,Object> result = null;

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        if (results != null && results.size() == 1) {
            result = results.get(0);
        } else {
            //表没有用户的登录记录
            String INSERT_SQL = "INSERT INTO t_login_log (USERID, LOGINTIME, CONTINUElOGINCNT) VALUES (?,?,?)";
            this.insertData(INSERT_SQL,new Object[]{userId,timestamp,1});
            return;
        }
        //获取上次登录时间和当前登录时间的差值
        long diff_time = (Long) result.get("diff_time");
        String UPDATE_SQL = null;
        if (diff_time >= 2) {
            UPDATE_SQL = "UPDATE t_login_log SET CONTINUElOGINCNT = 1,LOGINTIME = ? WHERE USERID = ?";
        } else if (diff_time == 1){
            UPDATE_SQL = "UPDATE t_login_log SET CONTINUElOGINCNT = CONTINUElOGINCNT + 1,LOGINTIME = ? WHERE USERID = ?";
        } else {
            //TODO 修改时间该用户当天已经登录过了
            return;
        }

        this.updateData(UPDATE_SQL,new Object[]{timestamp,userId});
    }

    @Override
    public void deleteCodeData(String tel_phone) {

        String DELETE_SQL = "DELETE FROM t_code WHERE tel_phone = ?";
        this.deleteData(DELETE_SQL,new Object[]{tel_phone});
    }

    @Override
    public int updatePwdByTelphone(String tel_phone, String pwd) {

        String UPDATE_SQL = "UPDATE t_user SET PASSWORD = ? WHERE USERNAME = ?";
        return this.updateData(UPDATE_SQL,new Object[]{pwd,tel_phone});
    }

    @Override
    public Map<String, Object> findUserByTelphone(String tel_phone) {

        String SELECT_SQL = " SELECT * FROM t_user WHERE USERNAME =?;";
        List<Map<String,Object>> results = this.queryForList(SELECT_SQL,new Object[]{tel_phone});
        if (results != null && results.size() == 1) {
            return results.get(0);
        }

        return null;
    }

    @Override
    public Map<String, Object> findEmpInfoByUserNameAndPwd(String username, String password) {

        String SELECT_SQL = "SELECT * FROM t_empinfo emp WHERE emp.USERNAME = ? AND emp.PASSWORD = ?";
        return this.queryForMap(SELECT_SQL, new Object[]{username, password});
    }

    @Override
    public int addEmpInfo(EmpInfo empInfo) {

        //创建时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String INSERT_SQL = "INSERT INTO t_empinfo (USERNAME, PASSWORD, EMPLOYEE_NAME,DEPARTMEN_ID,GENDER,BRITHDAY," +
                "POLITICS_STATAS,MARRIAGE,ADRRESS,EMAL,PHONE,JOB,CREATEDON) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Object[] params = new Object[]{
                empInfo.getUserName(),
                empInfo.getPassword(),
                empInfo.getEmployeeName(),
                empInfo.getDepartmentId(),
                empInfo.getGender(),
                empInfo.getBrithday(),
                empInfo.getPoliticsStatus(),
                empInfo.getMarriage(),
                empInfo.getAddress(),
                empInfo.getEmail(),
                empInfo.getPhone(),
                empInfo.getJob(),
                timestamp
        };
        return this.insertData(INSERT_SQL,params);
    }

    @Override
    public List<Map<String, Object>> findEmpInfoList() {

        String SELECT_SQL = "select * from t_empinfo";
        return this.queryForList(SELECT_SQL);
    }

    @Override
    public int deleteEmpInfoById(int itemId) {

        String DELETE_SQL = "DELETE FROM t_empinfo WHERE ID = ?";
        return this.deleteData(DELETE_SQL,new Object[]{itemId});
    }

    @Override
    public int addPopem(String role_name, String role_flag) {

        String INSERT_SQL = "INSERT INTO t_role (ROLECODE,ROLENAME) VALUES (?,?)";
        return this.insertData(INSERT_SQL,new Object[]{role_name,role_flag});
    }

    @Override
    public List<Map<String, Object>> findTelphoneByCondition(String telPhone) {

        String SELECT_SQL = "SELECT u.USERID,u.USERNAME FROM t_user as u where u.USERNAME like ?";
        telPhone = telPhone+"%";
        return this.queryForList(SELECT_SQL,new Object[]{telPhone});
    }

    @Override
    public int addRebate(User2BidInfo user2BidInfo) {

        String INSERT_SQL = "INSERT INTO t_user_bid (USERID, BIDID,PLATFORMID, INVESTMENT_AMOUNT, SELF_PLATFORM_REVENUE, PLATFORM_REVENUE,CREATEDON) VALUES (?,?,?,?,?,?,?)";
        //创建时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        //定义参数数组
        Object[] params = new Object[]{
                user2BidInfo.getUserId(),
                user2BidInfo.getBidId(),
                user2BidInfo.getPlatformId(),
                user2BidInfo.getInvestmentAmount(),
                user2BidInfo.getSelfPlatformReveue(),
                user2BidInfo.getPlatformReveue(),
                timestamp

        };
        return this.insertData(INSERT_SQL,params);
    }

    @Override
    public int modifyUserCapital(int userId, BigDecimal money) {

        String UPDAATE_SQL = "UPDATE t_user SET TOTALACCOUNT = TOTALACCOUNT + ? WHERE USERID = ?";
        return this.updateData(UPDAATE_SQL,new Object[]{money,userId});
    }

    @Override
    public Map<String,Object> findUserLogByUid(int userId){

        String querySQL = "select * from t_login_log where USERID =?";
        return this.queryForMap(querySQL,new Object[]{userId});
    }

    @Override
    public int updateUserInviteCodeByUid(String inviteCode, int userId){
        String updateSQL = "UPDATE t_user SET INVITECODE = ? where USERID = ? ;";
        return this.updateData(updateSQL,new Object[]{inviteCode,userId});
    }

}
