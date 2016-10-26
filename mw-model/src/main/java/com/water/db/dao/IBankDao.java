package com.water.db.dao;

import com.water.db.entry.BankInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
public interface IBankDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.service.impl.BankDaoImpl";

    /**绑定用户银行卡*/
    int bindBankCard(BankInfo bankInfo);

    /**更新用户的银行卡绑定状态;【0】未绑定,【1】已绑定*/
    int updateUserBankCardStatus(int userId, int bind_status);

    /**查询用户银行卡信息*/
    List<Map<String,Object>> findBankCardByUid(int userId);

}
