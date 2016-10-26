package com.water.db.service.impl;

import com.water.db.dao.IInviteDao;
import com.water.db.service.IInviteService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
@Service(IInviteService.SERVICE_NAME)
@Transactional(readOnly = true)
public class InviteServiceImpl implements IInviteService{

    @Resource(name = IInviteDao.SERVICE_NAME)
    private IInviteDao inviteDao;

    @Override
    public Map<String,Object> findUserByInviteCode(String inviteCode){

        MWStringUtils.isBlank(inviteCode);
        Map<String,Object> userMap = inviteDao.findUserByInviteCode(inviteCode);
        return userMap;
    }

    @Override
    public boolean saveInvitation(int userId, int friendId, int inviteWay, Timestamp createDon){

        MWStringUtils.isBlank(userId,friendId,inviteWay,createDon);
        int resultCode = inviteDao.saveInvitation(userId, friendId, inviteWay,createDon);
        if (resultCode > 0){
            return  true;
        }
        return false;
    }

    @Override
    public List<Map<String,Object>> findInvitesCountByUserId(int userId){
        MWStringUtils.isBlank(userId);
        List<Map<String,Object>> userList= inviteDao.findInvitesCountByUserId(userId);
        return userList;
    }

    @Override
    public List<Map<String,Object>> findInviteListByUserId(int userId){
        MWStringUtils.isBlank(userId);
        List<Map<String,Object>> userList= inviteDao.findInviteListByUserId(userId);
        return userList;
    }
}
