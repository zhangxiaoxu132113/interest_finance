package com.water.db.service.impl;

import com.water.db.dao.IPlatformDao;
import com.water.db.entry.PlatformAPI;
import com.water.db.entry.PlatformInfo;
import com.water.db.service.IPlatformService;
import com.water.db.service.ISystemDDLService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/30.
 */
@Service(IPlatformService.SERVICE_NAME)
public class PlatformServiceImpl implements IPlatformService {

    @Resource(name = IPlatformDao.SERVICE_NAME)
    private IPlatformDao platformDao;

    @Resource(name = ISystemDDLService.SERVICE_NAME)
    private ISystemDDLService systemDDLService;

    @Override
    public boolean addPlatformInfo(PlatformInfo platformInfo) {

        if (platformInfo == null) {
            throw new RuntimeException("平台项目对象不能为空!");
        }
        int effectRows = platformDao.addPlatformInfo(platformInfo);
        if (effectRows !=0 ) return true;
        return false;
    }

    @Override
    public boolean updatePlatformInfo(PlatformInfo platformInfo) {

        if (platformInfo == null) {
            throw new RuntimeException("平台项目对象不能为空!");
        }
        int effectRows = platformDao.updatePlatformInfo(platformInfo);
        if (effectRows !=0 ) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findPlatformList() {

        List<Map<String,Object>> platformList = platformDao.findPlatformList();
        if (platformList != null && platformList.size() > 0) {
            //转换内容格式
            List<Map<String,Object>> platformListNew = new ArrayList<Map<String,Object>>();
            Iterator iterator = platformList.iterator();
            while (iterator.hasNext()) {
                Map<String,Object> platformInfo = (Map<String, Object>) iterator.next();
                conversionNumFormat(platformInfo,"REGISTERED_CAPITAL");
                platformListNew.add(platformInfo);
            }

            return platformListNew;
        }
        return platformList;
    }

    @Override
    public boolean deletePlatformById(int itemId) {

        MWStringUtils.isBlank(itemId);
        int effectRows = platformDao.deletePlatformById(itemId);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public Map<String, Object> findPlatformById(int platformId) {

        Map<String,Object> platformInfo = platformDao.findPlatformById(platformId);

        //设置平台的背景
        List<Map<String,Object>> pBackgroundList = systemDDLService.findPlatformBackgroundList();
        if (pBackgroundList != null && pBackgroundList.size() > 0) {
            for(int i=0; i<pBackgroundList.size(); i++) {
                Map<String,Object> pBackground = pBackgroundList.get(i);
                if (platformInfo.get("P_BACKGROUND") == pBackground.get("DDLCODE")) {
                    platformInfo.put("P_BACKGROUND",pBackground.get("DDLNAME"));
                }
            }
        }

        /**将数额转换为以万为单位的格式*/
        conversionNumFormat(platformInfo,"REGISTERED_CAPITAL");

        return platformInfo;
    }

    @Override
    public boolean addPlatformApi(PlatformAPI platformAPI) {

        if (platformAPI == null) throw new RuntimeException("对象不能为空！");
        //查询要添加的接口信息是否存在
        Map<String,Object> apiMap = platformDao.queryPlatformApi(platformAPI.getPlatformId(),platformAPI.getApiFlag());
        if (apiMap == null) return false;
        //添加数据
        int effectRows = platformDao.addPlatformApi(platformAPI);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String,Object>> findPlatformApiList(){

        List<Map<String,Object>> list = platformDao.findPlatformApiList();
        return list;
    }

    @Override
    public List<Map<String,Object>> queryAPI(int platformId, int  apiFlag){

        MWStringUtils.isBlank(platformId,apiFlag);
        List<Map<String,Object>> list = platformDao.queryAPI(platformId,apiFlag);
        return list;
    }

    @Override
    public boolean deletePlatformAPIById(int itemId){

        MWStringUtils.isBlank(itemId);
        int effectRows = platformDao.deletePlatformAPIById(itemId);
        if (effectRows != 0) return true;
        return false;
    }

    /**将数字转换为以万为单位的格式*/
    private void conversionNumFormat(Map<String,Object> mapObj, String keyword) {

        //获取要转换的数字
        int register_capital = (Integer) mapObj.get(keyword);
        //开发转换格式
        String register_capital_str = MWStringUtils.conversion(register_capital,0);
        //修改键值对
        mapObj.put(keyword,register_capital_str);
    }

    @Override
    public Map<String,Object> queryPlatformApi(int platformId, int  apiFlag){

        MWStringUtils.isBlank(platformId,apiFlag);
        Map<String,Object> result = platformDao.queryPlatformApi(platformId, apiFlag);
        return result;
    }

}
