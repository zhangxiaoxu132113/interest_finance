package com.water.db.dao.impl;

import com.water.db.dao.IPlatformDao;
import com.water.db.entry.PlatformAPI;
import com.water.db.entry.PlatformInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/30.
 *
 */
@Repository(IPlatformDao.SERVICE_NAME)
public class PlatformDaoImpl extends BaseDaoImpl implements IPlatformDao {

    @Override
    public int addPlatformInfo(final PlatformInfo platformInfo) {

        String INSERT_SQL = "INSERT INTO t_investmentplatform " +
                            "(P_NAME, C_NAME, LOGO_IMG, REGISTERED_CAPITAL, C_ADDRESS, " +
                            "LEGAL_REPERSENTATIVE, UPTIME, TEL_PHONE, URL_ADDRESS,P_BACKGROUND," +
                            "PLATFORM_INTRODUCTION, RECOMMENDED_REASON, WIND_CONTROL_SITUATION," +
                            "PROJECT_TYPE, MANAGEMENT_COST, PREPAID_COST,SAFEGUARD_WAY,WITHDRAWAL_COST,GUARANTEDD_INSTITUTION)" +
                            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Object[] params = new Object[]{
                platformInfo.getpName(),
                platformInfo.getcName(),
                platformInfo.getLogoImg(),
                platformInfo.getRegisteredCapital(),
                platformInfo.getcAddress(),
                platformInfo.getLegalRepersentative(),
                platformInfo.getUptime(),
                platformInfo.getTelPhone(),
                platformInfo.getUrlAddress(),
                platformInfo.getpBackground(),
                platformInfo.getPlatformIntroduction(),
                platformInfo.getRecommendedReason(),
                platformInfo.getWindControlSituation(),
                platformInfo.getProjectType(),
                platformInfo.getManagerCost(),
                platformInfo.getPrepaidCost(),
                platformInfo.getSafeguardWay(),
                platformInfo.getWithdrawalCost(),
                platformInfo.getGuaranteddInstitution()
        };

        return this.insertData(INSERT_SQL,params);
    }

    @Override
    public int updatePlatformInfo(final PlatformInfo platformInfo) {

        String INSERT_SQL = "UPDATE t_investmentplatform  SET" +
                " P_NAME = ?, C_NAME = ?, LOGO_IMG = ?, REGISTERED_CAPITAL = ?, C_ADDRESS = ?, " +
                "LEGAL_REPERSENTATIVE = ?, UPTIME = ?, TEL_PHONE = ?, URL_ADDRESS = ?,P_BACKGROUND = ?," +
                "PLATFORM_INTRODUCTION = ?, RECOMMENDED_REASON = ?, WIND_CONTROL_SITUATION = ?" +
                " WHERE ID = ?";
        return this.insertData(INSERT_SQL,new Object[]{
                platformInfo.getpName(),
                platformInfo.getcName(),
                platformInfo.getLogoImg(),
                platformInfo.getRegisteredCapital(),
                platformInfo.getcAddress(),
                platformInfo.getLegalRepersentative(),
                platformInfo.getUptime(),
                platformInfo.getTelPhone(),
                platformInfo.getUrlAddress(),
                platformInfo.getpBackground(),
                platformInfo.getPlatformIntroduction(),
                platformInfo.getRecommendedReason(),
                platformInfo.getWindControlSituation(),
                platformInfo.getId()
        });
    }

    @Override
    public List<Map<String, Object>> findPlatformList() {

        String SELECT_SQL = "select * from t_investmentplatform";
        return this.queryForList(SELECT_SQL);
    }

    @Override
    public int deletePlatformById(int itemId) {

        String SELECT_SQL = "delete from t_investmentplatform where id = ?";
        return this.deleteData(SELECT_SQL,new Object[]{itemId});
    }

    @Override
    public Map<String, Object> findPlatformById(int platformId) {

        String SELECT_SQL = "SELECT * FROM t_investmentplatform WHERE ID = ?";
        return this.queryForMap(SELECT_SQL,new Object[]{platformId});
    }

    @Override
    public int addPlatformApi(PlatformAPI platformAPI) {
        String INSERT_SQL = "INSERT INTO t_platform_api " +
                "(PLATFORMID, URL, PARAMS, APPKEY, APIFLAG,DESCRIPTION) VALUES (?,?,?,?,?,?)";
        Object[]params = new Object[]{
                platformAPI.getPlatformId(),
                platformAPI.getUrl(),
                platformAPI.getParams(),
                platformAPI.getAppKey(),
                platformAPI.getApiFlag(),
                platformAPI.getDescription()
        };
        return this.insertData(INSERT_SQL,params);
    }

    @Override
    public List<Map<String,Object>> findPlatformApiList(){

        String querySQL = "select api.*,plat.P_NAME,ddl.DDLNAME from t_platform_api api,t_investmentplatform plat,(select * from t_systemddl where KEYWORD = 'api_flag') ddl where api.PLATFORMID = plat.ID and api.APIFLAG = ddl.DDLCODE;";
        return this.queryForList(querySQL);
    }

    @Override
    public List<Map<String,Object>> queryAPI(int platformId, int  apiFlag){

        String str= " ";
        if(platformId == -1 && apiFlag == -1){
            str = " -1 = ? and -1 = ? and ";
        }
        if(platformId == -1 && apiFlag != -1){
            str = " -1 = ? and api.APIFLAG = ? and ";
        }
        if(platformId != -1 && apiFlag == -1){
            str = " api.PLATFORMID = ? and -1 = ? and ";
        }
        if(platformId != -1 && apiFlag != -1){
            str = " api.PLATFORMID = ? and api.APIFLAG = ? and ";
        }
        String querySQL = "select api.*,plat.P_NAME,ddl.DDLNAME from t_platform_api api,t_investmentplatform plat,(select * from t_systemddl where KEYWORD = 'api_flag') ddl where " + str + " api.PLATFORMID = plat.ID and api.APIFLAG = ddl.DDLCODE;";
        return this.queryForList(querySQL, new Object[]{platformId, apiFlag});
    }

    @Override
    public int deletePlatformAPIById(int itemId){
        String deleteSQL = "delete from t_platform_api where id = ?";
        return this.deleteData(deleteSQL,new Object[]{itemId});
    }

    @Override
    public Map<String,Object> queryPlatformApi(int platformId, int apiFlag) {

        String SELECT_SQL = "SELECT * FROM t_platform_api api WHERE api.PLATFORMID = ? AND api.APIFLAG = ?";
        Object[]params = new Object[]{ platformId, apiFlag };
        return this.queryForMap(SELECT_SQL,params);
    }
}
