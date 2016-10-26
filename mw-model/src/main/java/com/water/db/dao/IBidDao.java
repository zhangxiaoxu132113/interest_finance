package com.water.db.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/9/14.
 */
public interface IBidDao extends IBaseDao{

    String SERVICE_NAME = "com.water.db.service.impl.BidDaoImpl";

    /**查询所有的标的信息*/
    List<Map<String,Object>> findAllBidInfo();

    /**查询投标返现列表信息*/
    List<Map<String,Object>> findRebateInfoList();
}
