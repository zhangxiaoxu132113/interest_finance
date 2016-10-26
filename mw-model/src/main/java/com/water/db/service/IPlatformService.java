package com.water.db.service;

import com.water.db.entry.PlatformAPI;
import com.water.db.entry.PlatformInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/30.
 *
 */
public interface IPlatformService {

    String SERVICE_NAME = "com.water.db.service.impl.PlatformServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 添加第三方平台信息
     * @time        2016-08-30
     * @return      boolean
     */
    boolean addPlatformInfo(PlatformInfo platformInfo);

    /**
     * @author      MengSheng
     * @description 修改第三方平台信息
     * @time        2016-08-30
     * @return      boolean
     */
    boolean updatePlatformInfo(PlatformInfo platformInfo);

    /**
     * @author      Zhang Miaojie
     * @description 查询第三方平台的信息列表
     * @time        2016-08-30
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findPlatformList();

    /**
     * @author      Zhang Miaojie
     * @description 根据id删除平台信息
     * @time        2016-08-30
     * @return      boolean
     */
    boolean deletePlatformById(int itemId);

    /**
     * @author      Zhang Miaojie
     * @description 根据id查询平台信息
     * @time        2016-09-01
     * @return      boolean
     */
    Map<String,Object> findPlatformById(int platformId);

    /**
     * @author      Zhang Miaojie
     * @description 添加平台的API接口
     * @time        2016-10-18
     * @return      boolean
     */
    boolean addPlatformApi(PlatformAPI platformAPI);

    /**
     * @author      MengSheng
     * @description 获取平台的API接口列表
     * @time        2016-10-24
     * @return      boolean
     */
    List<Map<String,Object>> findPlatformApiList();

    /**
     * @author      MengSheng
     * @description 根据平台和接口类型查询API接口
     * @time        2016-10-24
     * @return
     */
    List<Map<String,Object>> queryAPI(int platformId, int  apiFlag);

    /**
     * @author      MengSheng
     * @description 根据ID删除API接口信息
     * @time        2016-10-24
     * @return
     */
    boolean deletePlatformAPIById(int itemId);


    /**
     * @author      Zhang Miaojie
     * @description 查询平台的API接口
     * @time        2016-10-18
     * @return
     */
    Map<String,Object> queryPlatformApi(int platformId, int  apiFlag);


}
