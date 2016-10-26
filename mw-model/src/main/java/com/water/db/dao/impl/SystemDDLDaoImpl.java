package com.water.db.dao.impl;

import com.water.db.dao.ISystemDDLDao;
import com.water.tools.constant.admin.SystemDDLConstant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 *
 */
@Repository(ISystemDDLDao.SERVICE_NAME)
public class SystemDDLDaoImpl extends BaseDaoImpl implements ISystemDDLDao {


    @Override
    public List<Map<String, Object>> findInfoListByKeyword(String keyword) {

        String SELECT_SQL = "select * from t_systemddl where keyword = ?";
        return this.queryForList(SELECT_SQL,new Object[]{keyword});
    }

    @Override
    public List<Map<String, Object>> findBidCategory() {

        String SELECT_SQL = "select * from t_systemddl where keyword = ?";
        return this.queryForList(SELECT_SQL,new Object[]{SystemDDLConstant.PLATFORM_CATEGORY});
    }

    @Override
    public String queryByKeywordAndDDLCode(String keyword, int ddlCode) {

        String SELECT_SQL = "SELECT DDLNAME FROM t_systemddl WHERE KEYWORD =? and DDLCODE = ?";
        Map<String,Object> resultJson = this.queryForMap(SELECT_SQL,new Object[]{keyword,ddlCode});
        return (String) resultJson.get("DDLNAME");
    }

    @Override
    public List<Map<String, Object>> findPlatformBackgroundList() {

        String SELECT_SQL = "select * from t_systemddl where keyword = ?";
        return this.queryForList(SELECT_SQL,new Object[]{SystemDDLConstant.PLATFORM_BACKGROUND});
    }

    @Override
    public List<Map<String, Object>> findDepartmentList() {

        String SELECT_SQL = "SELECT * FROM t_department";
        return this.queryForList(SELECT_SQL);
    }

}
