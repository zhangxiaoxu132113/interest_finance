package com.water.db.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/19.
 */
public interface IIntegralService {

    /**
     * @author      MengSheng
     * @descrition  保存积分记录
     * @time        2016/9/19
     * @param userId                用户ID
     * @param score                 积分收入
     * @param score_type            积分收支标识（【0】支出，【1】收入）
     * @param source                积分来源
     * @param total_integral        总积分
     * @param available_integral    可用积分
     * @param createTime            创建时间
     */
    boolean saveIntegral(int userId,int score,int score_type,String source,int available_integral,int total_integral,Timestamp createTime);

    /**
     * @author      MengSheng
     * @descrition  查询积分记录列表
     * @time        2016/9/19
     * @param userId
     */
    List<Map<String,Object>> findIntegralByUid(int userId);

    /**
     * @author      MengSheng
     * @descrition  查询该用户最新的积分记录
     * @time        2016/9/19
     * @param userId
     */
    Map<String,Object> findLatestIntegralByUid(int userId);

    /**
     * @author      MengSheng
     * @descrition  查询本月获得积分
     * @time        2016/9/19
     * @param userId
     * @param startDate 开始日期
     * @param endDate   结束日期
     */
    Map<String,Object> findIntegralMonthByUid(int userId,Timestamp startDate,Timestamp endDate);

    /**
     * @author      MengSheng
     * @descrition  查询累计获得积分
     * @time        2016/9/19
     * @param userId
     */
    Map<String,Object> findSumIntegralByUid(int userId);

}
