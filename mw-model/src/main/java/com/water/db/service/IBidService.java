package com.water.db.service;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/9/14.
 */
public interface IBidService {

    String SERVICE_NAME = "com.water.db.service.impl.BidServiceImpl";

    /**
     * 获取平台下的所有的标的信息
     */
    List<Map<String,Object>> findAllBidInfo();

    /**
     * 获取用户的投资返利信息
     */
    List<Map<String,Object>> findRebateInfoList();


}
