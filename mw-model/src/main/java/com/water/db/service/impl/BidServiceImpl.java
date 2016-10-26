package com.water.db.service.impl;

import com.water.db.dao.IBidDao;
import com.water.db.service.IBidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by mrwater on 16/9/14.
 * 标的业务类
 */
@Service(IBidService.SERVICE_NAME)
public class BidServiceImpl implements IBidService {

    @Resource(name = IBidDao.SERVICE_NAME)
    private IBidDao bidDao;

    @Override
    public List<Map<String, Object>> findAllBidInfo() {

        return bidDao.findAllBidInfo();
    }

    @Override
    public List<Map<String, Object>> findRebateInfoList() {

        return bidDao.findRebateInfoList();
    }
}
