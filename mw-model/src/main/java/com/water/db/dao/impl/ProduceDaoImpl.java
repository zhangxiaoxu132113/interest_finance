package com.water.db.dao.impl;

import com.water.db.dao.IProduceDao;
import com.water.db.entry.Produce;
import com.water.tools.constant.admin.SystemDDLConstant;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/31.
 *
 */
@Repository(IProduceDao.SERVICE_NAME)
public class ProduceDaoImpl extends BaseDaoImpl implements IProduceDao {

    @Override
    public List<Map<String, Object>> getProduceList() {


        String SELECT_SQL = "SELECT bid.*,inv.P_BACKGROUND, inv.C_NAME, inv.P_NAME, sysddl.DDLNAME as moduleName, inv.LOGO_IMG " +
                            "FROM t_bid as bid, t_investmentplatform inv , t_systemddl as sysddl " +
                            "where bid.PLATFORMID = inv.ID and bid.MODULE = sysddl.DDLCODE and sysddl.KEYWORD = ?";
        return this.queryForList(SELECT_SQL,new Object[]{SystemDDLConstant.PLATFORM_CATEGORY});
    }

    @Override
    public int addProduceInfo(Produce produce) {

        String INSET_SQL  = "INSERT INTO t_bid " +
                            "(PLATFORMID, NAME, DESCRIPTION, TOTALCAPITAL, ANNUALRATE, SELF_ANNUALRATE," +
                            "TERM,STARTAMOUNT,REPAYMENT_WAY,BEARING_WAY,SAFEGUARD_WAY,MODULE,CREATEON)" +
                            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        return this.insertData(INSET_SQL,new Object[]{
                produce.getPlatformId(),
                produce.getName(),
                produce.getDescription(),
                produce.getTotalCapital(),
                produce.getAnnualRate(),
                produce.getSelfAnnualRate(),
                produce.getTerm(),
                produce.getStartMount(),
                produce.getRepaymentWay(),
                produce.getBearingWay(),
                produce.getSafeGuardWay(),
                produce.getModule(),
                timestamp
        });
    }

    @Override
    public int updateProduceInfo(Produce produce) {

        String INSET_SQL  = "UPDATE t_bid SET " +
                " PLATFORMID = ?, NAME = ?, DESCRIPTION = ?, TOTALCAPITAL = ?, ANNUALRATE = ?, SELF_ANNUALRATE = ?," +
                "TERM = ?,STARTAMOUNT = ?,REPAYMENT_WAY = ?,BEARING_WAY = ?,SAFEGUARD_WAY = ?,MODULE = ? " +
                " WHERE ID = ? ;";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        return this.insertData(INSET_SQL,new Object[]{
                produce.getPlatformId(),
                produce.getName(),
                produce.getDescription(),
                produce.getTotalCapital(),
                produce.getAnnualRate(),
                produce.getSelfAnnualRate(),
                produce.getTerm(),
                produce.getStartMount(),
                produce.getRepaymentWay(),
                produce.getBearingWay(),
                produce.getSafeGuardWay(),
                produce.getModule(),
                produce.getId()
        });
    }

    @Override
    public int deleteProduceById(int itemId) {

        String DELETE_SQL = "DELETE from t_bid WHERE ID = ?";
        return this.deleteData(DELETE_SQL,new Object[]{itemId});
    }

    @Override
    public List<Map<String, Object>> findBidByNewComer(int limitValue) {

        String SELECT_SQL = "SELECT bid.*,FORMAT(bid.ANNUALRATE,0) as ANNUALRATE_,FORMAT(bid.SELF_ANNUALRATE,0) as SELF_ANNUALRATE_,inv.LOGO_IMG " +
                " FROM t_bid as bid, t_investmentplatform inv" +
                " WHERE module = ? and bid.PLATFORMID = inv.ID LIMIT ?";
        return this.queryForList(SELECT_SQL,new Object[]{Produce.CATEGORY_NEWCOMER,limitValue});
    }

    @Override
    public List<Map<String, Object>> findBidByCuraton(int limitValue) {

        String SELECT_SQL = "SELECT bid.* ,inv.LOGO_IMG " +
                " FROM t_bid as bid, t_investmentplatform inv" +
                " WHERE module = ? and bid.PLATFORMID = inv.ID LIMIT ?";
        return this.queryForList(SELECT_SQL,new Object[]{Produce.CATEGORY_CURATON,limitValue});
    }

    @Override
    public Map<String, Object> findProduceById(int produceId) {

        String SELECT_SQL = "SELECT bid.*,FORMAT(bid.ANNUALRATE,0) as ANNUALRATE_,FORMAT(bid.SELF_ANNUALRATE,0) as SELF_ANNUALRATE_ " +
                            "FROM t_bid as bid WHERE ID = ?";
        return this.queryForMap(SELECT_SQL,new Object[]{produceId});
    }

    @Override
    public List<Map<String, Object>> queryProduceByCondition(Map<String, Object> condition, Map<String,Object> rangeCondition) {

        String SELECT_SQL = "SELECT bid.*,inv.P_BACKGROUND ,inv.LOGO_IMG from t_bid bid ,t_investmentplatform inv where bid.PLATFORMID = inv.ID ";
        String ConditionStr = getConditionStr(condition);
        String rangeConditionStr = getRangeConditionStr(rangeCondition);
        SELECT_SQL = SELECT_SQL + ConditionStr + rangeConditionStr;
        System.out.println("final-sql = " + SELECT_SQL);

        return this.queryForList(SELECT_SQL);
    }

    /**
     * 拼装要查询的条件
     * @param rangeCondition 条件键值对
     * @return
     */
    private static String getRangeConditionStr(Map<String,Object> rangeCondition) {
        if (rangeCondition == null) {
            throw new RuntimeException("传递的条件不能为空！");
        }

        StringBuilder condition = new StringBuilder();
        for (Map.Entry<String,Object> entry : rangeCondition.entrySet()) {

            String conditionKey = entry.getKey();
            Object conditionValue = entry.getValue();
            if ("returnRate".equals(conditionKey)) {
                String conditionStr = (String) conditionValue;
                String[] ranges = conditionStr.split("-");
                condition.append("and bid.ANNUALRATE+bid.SELF_ANNUALRATE BETWEEN ");
                condition.append(Integer.parseInt(ranges[0]));
                condition.append(" and ");
                condition.append(Integer.parseInt(ranges[1]));
                condition.append(" ");

            } else if ("returnDate".equals(conditionKey)) {
                String conditionStr = (String) conditionValue;
                String[] ranges = conditionStr.split("-");
                condition.append(" and bid.TERM BETWEEN ");
                condition.append(Integer.parseInt(ranges[0]) * 30);
                condition.append(" and ");
                condition.append(Integer.parseInt(ranges[1]) * 30 -1);

            }
        }

        return condition.toString();
    }

    /**
     * 拼装要查询的条件
     * @param conditionMap 条件键值对
     * @return
     */
    private String getConditionStr(Map<String,Object> conditionMap) {
        if (conditionMap == null) {
            throw new RuntimeException("传递的条件不能为空！");
        }

        StringBuilder condition = new StringBuilder();
        condition.append("and 1 =1 and ");
        for (Map.Entry<String,Object> entry : conditionMap.entrySet()) {
            String conditionKey = entry.getKey();
            Object conditionValue = entry.getValue();

            System.out.println("key = " + conditionKey);
            System.out.println("value = " + conditionValue);
            if (conditionValue instanceof Integer || conditionValue instanceof Float
                    || conditionValue instanceof Double || conditionValue instanceof Long) {
                condition.append(conditionKey + " = " +conditionValue + " and ");
            } else if (conditionValue instanceof String) {
                condition.append(conditionKey + " = '" +conditionValue + "' and ");
            }

        }

        return condition.substring(0,condition.lastIndexOf("and"));
    }
}
