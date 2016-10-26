package com.water.db.service.impl;

import com.water.db.dao.IInvestDao;
import com.water.db.service.IInvestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 */
@Service(IInvestService.SERVICE_NAME)
public class InvestServiceImpl implements IInvestService {

    @Resource(name = IInvestDao.SERVICE_NAME)
    private IInvestDao investDao;

    @Override
    public boolean savePlatformRelation(int userId, int platformId){

        int autoIncId = investDao.savePlatformRelation(userId, platformId);
        if(autoIncId < 0){
            return false;
        }
        return true;
    }


    @Override
    public Map<String,Object> findPlaRelaByUIdAndPId(int userId, int platformId){
        Map<String,Object> result = investDao.findPlaRelaByUIdAndPId(userId, platformId);
        return result;
    }


}
