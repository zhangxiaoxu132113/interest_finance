package com.water.db.service.impl;

import com.water.db.dao.ITransactionDao;
import com.water.db.service.ITransactionService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/15.
 */
@Service(ITransactionService.SERVICE_NAME)
@Transactional(readOnly = true)
public class TransactionServiceImpl implements ITransactionService{

    @Resource(name = ITransactionDao.SERVICE_NAME)
    private ITransactionDao transactionDao;

    @Override
    public boolean saveTransaction(int userId, int amount, int amount_type, int trans_status, String remark ,Timestamp createTime){
        MWStringUtils.isBlank(userId,amount,amount_type,trans_status,remark,createTime);
        int count = transactionDao.saveTransaction(userId,amount,amount_type,trans_status,remark,createTime);
        if(count < 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUserTotalaccountByUid(BigDecimal totalaccount, int userId){
        MWStringUtils.isBlank(totalaccount,userId);
        int count = transactionDao.updateUserTotalaccountByUid(totalaccount, userId);
        if(count < 0){
            return false;
        }
        return true;
    }

    @Override
    public List<Map<String,Object>> findTransactionsByUid(int userId){
        MWStringUtils.isBlank(userId);
        List<Map<String,Object>> resultList = transactionDao.findTransactionsByUid(userId);
        return  resultList;
    }
    @Override
    public boolean deleteTransactionByUidAndTid(int userId, int Tid){
        MWStringUtils.isBlank(userId,Tid);
        int count = transactionDao.deleteTransactionByUidAndTid(userId, Tid);
        if(count < 0){
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Object> findInvestmentDetailByUid(int userId) {

        MWStringUtils.isBlank(userId);
        return transactionDao.findInvestmentDetailByUid(userId);
    }

}
