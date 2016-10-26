package com.water.db.dao;

import com.water.db.entry.Produce;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/31.
 *
 */
public interface IProduceDao extends IBaseDao {

    String SERVICE_NAME  = "com.water.db.dao.impl.ProduceDaoImpl";

    /**获取产品（标）列表信息*/
    List<Map<String,Object>> getProduceList();

    /**添加产品（标）信息*/
    int addProduceInfo(Produce produce);

    /**修改产品（标）信息*/
    int updateProduceInfo(Produce produce);

    /**删除产品（标）信息*/
    int deleteProduceById(int itemId);

    /**查询新手标信息*/
    List<Map<String,Object>> findBidByNewComer(int limitValue);

    /**查询精选标信息*/
    List<Map<String,Object>> findBidByCuraton(int limitValue);

    /**根据id查询标的信息*/
    Map<String,Object> findProduceById(int produceId);

    /**根据条件查询标的信息列表*/
    List<Map<String,Object>> queryProduceByCondition(Map<String,Object> condition, Map<String,Object> rangeCondition);

}
