package com.water.db.service.impl;

import com.water.db.dao.IProduceDao;
import com.water.db.dao.ISystemDDLDao;
import com.water.db.entry.Produce;
import com.water.db.service.IProduceService;
import com.water.tools.constant.admin.SystemDDLConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/31.
 */
@Service(IProduceService.SERVICE_NAME)
public class ProduceServiceImpl implements IProduceService {

    @Resource(name = IProduceDao.SERVICE_NAME)
    private IProduceDao produceDao;

    @Resource(name = ISystemDDLDao.SERVICE_NAME)
    private ISystemDDLDao systemDDLDao;

    @Override
    public List<Map<String, Object>> getProduceList() {

        List<Map<String,Object>> produceList = this.modifyProduceTerm(produceDao.getProduceList());
        List<Map<String,Object>> platformBackgroundList =  systemDDLDao.findPlatformBackgroundList();

        return setPlatformBackgroundName(produceList,platformBackgroundList);
    }

    @Override
    public List<Map<String, Object>> queryProduceByCondition(Map<String, Object> condition,  Map<String,Object> rangeCondition) {

        List<Map<String,Object>> produceList = produceDao.queryProduceByCondition(condition,rangeCondition);
        produceList = modifyProduceTerm(produceList);
        List<Map<String,Object>> platformBackgroundList = systemDDLDao.findPlatformBackgroundList();

        return setPlatformBackgroundName(produceList,platformBackgroundList);
    }

    @Override
    public boolean addProduceInfo(Produce produce) {

        if (produce == null) {
            throw  new RuntimeException("对象不能为空!");
        }
        int effectRows = produceDao.addProduceInfo(produce);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean updateProduceInfo(Produce produce) {

        if (produce == null) {
            throw  new RuntimeException("对象不能为空!");
        }
        int effectRows = produceDao.updateProduceInfo(produce);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean deleteProduceById(int itemId) {

        int effectRows = produceDao.deleteProduceById(itemId);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findBidByNewComer(int limitValue) {

        return this.modifyProduceTerm(produceDao.findBidByNewComer(limitValue));
    }

    @Override
    public List<Map<String, Object>> findBidByCuraton(int limitValue) {

        return this.modifyProduceTerm(produceDao.findBidByCuraton(limitValue));
    }

    @Override
    public Map<String, Object> findProduceById(int produceId) {

        Map<String,Object> bidInfo = produceDao.findProduceById(produceId);

        //查询数据字典，转换内容
        int REPAYMENT_WAY_CODE = (Integer) bidInfo.get("REPAYMENT_WAY");
        int BEARING_WAY_CODE = (Integer) bidInfo.get("BEARING_WAY");
        int SAFEGUARD_WAY_CODE = (Integer) bidInfo.get("SAFEGUARD_WAY");

        bidInfo.put("BEARING_WAY",systemDDLDao.queryByKeywordAndDDLCode(SystemDDLConstant.BEARING_WAY,BEARING_WAY_CODE));
        bidInfo.put("REPAYMENT_WAY",systemDDLDao.queryByKeywordAndDDLCode(SystemDDLConstant.REPAYMENT_WAY,REPAYMENT_WAY_CODE));
        bidInfo.put("SAFEGUARD_WAY",systemDDLDao.queryByKeywordAndDDLCode(SystemDDLConstant.GURANTEE_WAY,SAFEGUARD_WAY_CODE));

        return bidInfo;
    }

    /**
     * 根据标的的集合数据，转换每一个标的的平台的名称
     * @param produceList
     * @param platformBackgroundList
     * @return
     */
    private List<Map<String,Object>> setPlatformBackgroundName(List<Map<String,Object>> produceList, List<Map<String,Object>> platformBackgroundList) {

        List<Map<String,Object>> newProduceList = new ArrayList<Map<String,Object>>();
        if (produceList != null && produceList.size() > 0 && platformBackgroundList != null && platformBackgroundList.size() > 0) {

            for (int i =0; i<produceList.size(); i++) {

                Map<String,Object> produce = produceList.get(i);
                for (int j=0; j<platformBackgroundList.size(); j++) {

                    Map<String,Object> pBackground = platformBackgroundList.get(j);

                    if (produce.get("P_BACKGROUND") == pBackground.get("DDLCODE")) {
                        produce.put("pBackgroundName",pBackground.get("DDLNAME"));
                        newProduceList.add(produce);
                    }
                }
            }
        }
        return newProduceList;
    }

    /**
     * 修改每一个标的的时间格式
     * @param produceList
     * @return
     */
    private List<Map<String,Object>> modifyProduceTerm(List<Map<String,Object>> produceList) {
        List<Map<String,Object>> newProduceList = new ArrayList<Map<String,Object>>();

        for (int i=0; i<produceList.size(); i++) {
            Map<String,Object> produce = produceList.get(i);
            int term = (Integer) produce.get("TERM");
            if (term % 30 == 0) {
                int time = term / 30 ;
                System.out.println(time + "个月");
                produce.put("TERM_F",time + "个月");
            } else {
                produce.put("TERM_F",term+"天");
                System.out.println(term+"天");
            }
            newProduceList.add(produce);
        }

        return newProduceList;
    }

}
