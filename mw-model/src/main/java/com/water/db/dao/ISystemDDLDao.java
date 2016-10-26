package com.water.db.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 */
public interface ISystemDDLDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.dao.impl.SystemDDLDaoImpl";

    /**根据keyword来查询*/
    List<Map<String,Object>> findInfoListByKeyword(String key);

    /**获取标的分类*/
    List<Map<String,Object>> findBidCategory();

    /**根据keyword关键字和code查询数据字典，获取对应的值*/
    String queryByKeywordAndDDLCode(String keyword,int ddlCode);

    /**获取平台背景类型列表*/
    List<Map<String,Object>> findPlatformBackgroundList();

    List<Map<String,Object>> findDepartmentList();

}
