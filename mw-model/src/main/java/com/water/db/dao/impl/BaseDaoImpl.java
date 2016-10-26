package com.water.db.dao.impl;

import com.water.db.dao.IBaseDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/5/31.
 */
public class BaseDaoImpl implements IBaseDao {

    @Resource(name="jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    /**
     * 查询对象
     * @date  2016-05-31
     * @param sql
     */
    @Override
    public Map<String, Object> queryForMap(String sql) {

        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> queryForMap(String sql, Object... args) {
        List<Map<String,Object>> results = queryForList(sql,args);
        if (results != null && results.size() == 1) {
            return results.get(0);
        }

        return null;
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     * @param elementType
     */
    @Override
    public <T> List<T> queryForList(String sql, Class<T> elementType) {

        return jdbcTemplate.queryForList(sql,elementType);
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     */
    @Override
    public List<Map<String, Object>> queryForList(String sql) {

        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询对象集合
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    @Override
    public List<Map<String, Object>> queryForList(String sql, Object... args) {

        return jdbcTemplate.queryForList(sql,args);
    }

    /**
     * 删除数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    @Override
    public int deleteData(String sql, Object... args) {

        return jdbcTemplate.update(sql,args);
    }

    /**
     * 更新数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    @Override
    public int updateData(String sql, Object... args) {

        return jdbcTemplate.update(sql,args);
    }

    /**
     * 插入数据
     * @date  2016-05-31
     * @param sql
     * @param args
     */
    @Override
    public int insertData(String sql, Object... args) {

        return jdbcTemplate.update(sql,args);
    }

    @Override
    public List<Map<String, Object>> queryPagesList(String sql, int pages, int pageSize) {
        //每页的开头的位置(n-1)*m+1,n表示第几页，m表示每页显示的最多的条数
        int startLocation = (pages-1) * pageSize;

        String pageSql = sql + " limit " + startLocation + "," + pageSize;

        List<Map<String,Object>> pageList = jdbcTemplate.queryForList(pageSql);

        return pageList;
    }
}
