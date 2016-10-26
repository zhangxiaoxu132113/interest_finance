package com.water.db.dao;

import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/6.
 */
public interface IInvestDao extends IBaseDao{
    String SERVICE_NAME = "com.water.db.dao.impl.InvestDaoImpl";

    /**
     * @author      Meng Sheng
     * @descrition  开通X平台账户表;通过该表可知兴趣金融是否已开通X平台账户
     * @time        2016/9/6
     * @param       userId              兴趣金融用户的ID
     * @param       platformId          第三方平台的ID
     */
    int savePlatformRelation(int userId, int platformId);

    /**
     * @author      Meng Sheng
     * @descrition  查询是否已开通X平台账户
     * @time        2016/9/6
     * @param       userId              兴趣金融用户的ID
     * @param       platformId          第三方平台的ID
     */
    Map<String,Object> findPlaRelaByUIdAndPId(int userId, int platformId);


}
