package com.water.db.dao;

import com.water.db.entry.PlatformAPI;
import com.water.db.entry.PlatformInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/30.
 */
public interface IPlatformDao extends IBaseDao{

    String SERVICE_NAME  = "com.water.db.dao.impl.PlatformDaoImpl";

    /**添加平台信息*/
    int addPlatformInfo(PlatformInfo platformInfo);

    /**添加平台信息*/
    int updatePlatformInfo(PlatformInfo platformInfo);

    /**获取平台信息列表*/
    List<Map<String,Object>> findPlatformList();

    /**根据平台的ID删除平台的信息*/
    int deletePlatformById(int itemId);

    /**根据平台的ID查询平台的信息*/
    Map<String,Object> findPlatformById(int platformId);

    /**添加平台的API接口信息*/
    int addPlatformApi(PlatformAPI platformAPI);

    /**获取平台的API接口列表*/
    List<Map<String,Object>> findPlatformApiList();

    /**根据平台和接口类型查询API接口*/
    List<Map<String,Object>> queryAPI(int platformId, int  apiFlag);

    /**根据ID删除API接口信息*/
    int deletePlatformAPIById(int itemId);

    /**查询平台的API录入信息是否存在*/
    Map<String,Object> queryPlatformApi(int platformId, int  apiFlag);

}
