package com.water.db.dao.impl;

import com.water.db.dao.IBidDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/9/14.
 */
@Repository(IBidDao.SERVICE_NAME)
public class BidDaoImpl extends BaseDaoImpl implements IBidDao {

    @Override
    public List<Map<String, Object>> findAllBidInfo() {

        String SELECT_SQL = "select bid.*,inv.P_NAME  from t_bid bid,t_investmentplatform inv where bid.PLATFORMID = inv.ID";
        return this.queryForList(SELECT_SQL);
    }

    @Override
    public List<Map<String, Object>> findRebateInfoList() {

        return null;
    }
}
