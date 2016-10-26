package com.water.db.service.impl;

import com.water.db.dao.IBankDao;
import com.water.db.entry.BankInfo;
import com.water.db.service.IBankService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
@Service(IBankService.SERVICE_NAME)
@Transactional(readOnly = true)
public class BankServiceImpl implements IBankService {

    @Resource(name = IBankDao.SERVICE_NAME)
    private IBankDao bankDao;



    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean bindBankCard(BankInfo bankInfo) {

        MWStringUtils.isBlank(bankInfo.getUserId(),bankInfo.getAccountName(),bankInfo.getCardId(),bankInfo.getBankCardId(),bankInfo.getBankCode(),bankInfo.getBankBranch(),bankInfo.getCreateTime());
        int autoIncId = bankDao.bindBankCard(bankInfo);
        if (autoIncId > 0) {
            //更新用户的银行卡绑定状态
//            String update_sql = "";
//            bankDao.updateData(update_sql,new Object[]{bankI});
            int bind_status = 1;//表示已绑定银行卡
            int int_bind = bankDao.updateUserBankCardStatus(bankInfo.getUserId(),bind_status);
            if(int_bind > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<Map<String,Object>> findBankCardByUid(int userId){
        MWStringUtils.isBlank(userId);
        List<Map<String,Object>> result = bankDao.findBankCardByUid(userId);
        return result;
    }
}
