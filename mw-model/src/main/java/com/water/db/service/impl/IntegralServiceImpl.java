package com.water.db.service.impl;

import com.water.db.dao.IIntegralDao;
import com.water.db.service.IIntegralService;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/19.
 */
@Service(GlobalUtil.INTEGRAL_SERVICE)
@Transactional(readOnly = true)
public class IntegralServiceImpl implements IIntegralService {

    @Resource(name = GlobalUtil.INTEGRAL_DAO)
    private IIntegralDao integralDao;

    @Override
    public boolean saveIntegral(int userId,int score,int score_type,String source,int available_integral,int total_integral,Timestamp createTime){
        MWStringUtils.isBlank(userId,score,score_type,source,available_integral,total_integral,createTime);
        int count = integralDao.saveIntegral(userId,score,score_type,source,available_integral,total_integral,createTime);
        if(count < 0){
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String,Object>> findIntegralByUid(int userId){
        MWStringUtils.isBlank(userId);
        List<Map<String,Object>> result = integralDao.findIntegralByUid(userId);
        return result;
    }

    @Override
    public Map<String,Object> findLatestIntegralByUid(int userId){
        MWStringUtils.isBlank(userId);
        Map<String,Object> result = integralDao.findLatestIntegralByUid(userId);
        return result;
    }

    @Override
    public Map<String,Object> findIntegralMonthByUid(int userId,Timestamp startDate,Timestamp endDate){
        MWStringUtils.isBlank(userId,startDate,endDate);
        Map<String,Object> result = integralDao.findIntegralMonthByUid(userId, startDate, endDate);
        return result;
    }

    @Override
    public Map<String,Object> findSumIntegralByUid(int userId){
        MWStringUtils.isBlank(userId);
        Map<String,Object> result = integralDao.findSumIntegralByUid(userId);
        return result;
    }

}
