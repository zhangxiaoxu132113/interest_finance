package com.water.db.service;

import com.water.db.entry.Produce;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/31.
 */
public interface IProduceService {

    String SERVICE_NAME = "com.water.db.service.impl.ProduceServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 查询投标的信息
     * @time        2016-08-31
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> getProduceList();

    /**
     * @author      Zhang Miaojie
     * @description 添加投标的信息
     * @time        2016-08-31
     * @return      boolean
     */
    boolean addProduceInfo(Produce produce);

    /**
     * @author      MengSheng
     * @description 修改投标的信息
     * @time        2016-08-31
     * @return      boolean
     */
    boolean updateProduceInfo(Produce produce);

    /**
     * @author      Zhang Miaojie
     * @description 根据id删除投标信息
     * @time        2016-08-31
     * @return      boolean
     */
    boolean deleteProduceById(int itemId);

    /**
     * @author      Zhang Miaojie
     * @description 查询新手标的信息
     * @time        2016-09-01
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findBidByNewComer(int limitValue);

    /**
     * @author      Zhang Miaojie
     * @description 查询精选手标的信息
     * @time        2016-09-01
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findBidByCuraton(int limitValue);

    /**
     * @author      Zhang Miaojie
     * @description 根据id查询标的信息
     * @time        2016-09-01
     * @return      Map<String,Object>
     */
    Map<String,Object> findProduceById(int produceId);

    /**
     * @author      Zhang Miaojie
     * @description 根据条件查询标信息列表
     * @time        2016-09-02
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> queryProduceByCondition(Map<String,Object> condition, Map<String,Object> rangeCondition);

}
