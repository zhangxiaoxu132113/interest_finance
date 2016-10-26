package com.water.db.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 */
public interface IInviteService {

    String SERVICE_NAME = "com.water.db.service.impl.InviteServiceImpl";

    /**
     * @author      MengSheng
     * @descrition  根据用户邀请码获取用户
     * @time        2016/8/24
     * @param       inviteCode
     */
    Map<String,Object> findUserByInviteCode(String inviteCode);

    /**
     * @author      MengSheng
     * @descrition  保存邀请好友关系表信息
     * @time        2016/8/24
     */
    boolean saveInvitation(int userId, int friendId, int inviteWay, Timestamp createDon);

    /**
     * @author      MengSheng
     * @descrition  推荐人查询累计推荐人数
     * @time        2016/8/25
     * @param       userId
     */
    List<Map<String,Object>> findInvitesCountByUserId(int userId);

    /**
     * @author      MengSheng
     * @descrition  获取被推荐人列表
     * @time        2016/8/25
     * @param       userId
     */
    List<Map<String,Object>> findInviteListByUserId(int userId);

}
