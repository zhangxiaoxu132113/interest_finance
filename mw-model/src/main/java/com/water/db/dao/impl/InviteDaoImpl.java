package com.water.db.dao.impl;

import com.water.db.dao.IInviteDao;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
@Repository(IInviteDao.SERVICE_NAME)
public class InviteDaoImpl extends BaseDaoImpl implements IInviteDao {

    @Override
    public Map<String,Object> findUserByInviteCode(String inviteCode){
        String querySQL = "select * from t_user u where u.INVITECODE = ?";
        return this.queryForMap(querySQL,new Object[]{inviteCode});
    }

    @Override
    public int saveInvitation(int userId, int friendId, int inviteWay, Timestamp createDon){
        String querySQL = "insert into t_friends_invitation (USERID,FRIENDID,INVIATION_WAY,CREATEDON) values (?,?,?,?)";
        return this.insertData(querySQL,new Object[]{userId,friendId,inviteWay,createDon});
    }

    @Override
    public List<Map<String,Object>> findInvitesCountByUserId(int userId){
        String querySQL = " select * from t_friends_invitation where USERID = ?";
        return this.queryForList(querySQL,new Object[]{userId});
    }

    @Override
    public List<Map<String,Object>> findInviteListByUserId(int userId){
        String querySQL = "select i.*,u.* from t_user u,t_friends_invitation i where i.USERID = ? and u.USERID = i.FRIENDID ORDER BY CREATETIME DESC limit 0,3;";
        return this.queryForList(querySQL,new Object[]{userId});
    }

}
