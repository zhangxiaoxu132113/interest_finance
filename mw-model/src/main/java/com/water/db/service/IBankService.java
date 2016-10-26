package com.water.db.service;

import com.water.db.entry.BankInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
public interface IBankService {

    String SERVICE_NAME = "com.water.db.service.impl.BankServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 绑定银行卡
     * @time        2016-08-19
     * @return      Map<String,Object>
     */
    boolean bindBankCard(BankInfo bankInfo);

    /**
     * @author      MengSheng
     * @description 查询用户银行卡信息
     * @time        2016-09-19
     * @return
     * @param       userId  用户ID
     */
    List<Map<String,Object>> findBankCardByUid(int userId);
}
