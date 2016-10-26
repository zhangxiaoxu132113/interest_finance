package com.water.db.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/14.
 */
public interface ITransactionDao {
    String SERVICE_NAME = "com.water.db.dao.impl.TransactionDaoImpl";

    /**
     * @author      MengSheng
     * @descrition  保存交易记录
     * @time        2016/9/15
     * @param       userId  用户ID
     * @param       amount  交易金额
     * @param       amount_type 交易标识【0】支出，【1】收入
     * @param       trans_status    交易状态【0】成功，【1】失败
     * @param       remark  备注
     * @param       createTime  创建时间
     */
    int saveTransaction(int userId, int amount, int amount_type, int trans_status, String remark, Timestamp createTime);

    /**
     * @author      MengSheng
     * @descrition  更新用户账户总额
     * @time        2016/9/15
     * @param       userId  用户ID
     * @param       totalaccount  用户总额
     */
    int updateUserTotalaccountByUid(BigDecimal totalaccount, int userId);

    /**
     * @author      MengSheng
     * @descrition  查询交易详细
     * @time        2016/9/15
     */
    List<Map<String,Object>> findTransactionsByUid(int userId);

    /**
     * @author      MengSheng
     * @descrition  删除单行交易详细记录
     * @time        2016/9/15
     */
    int deleteTransactionByUidAndTid(int userId, int Tid);

    Map<String,Object> findInvestmentDetailByUid(int userId);

}
