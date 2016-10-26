package com.water.db.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/5/31.
 */
public interface IBaseDao {

    public static String SERVICE_NAME = "com.water.db.dao.impl.BaseDaoImpl";

    /**
     * 查询对象
     */
    Map<String,Object> queryForMap(String sql);
    /**
     * 查询对象
     */
    Map<String,Object> queryForMap(String sql, Object... args);

    /**
     * 查询对象集合
     */
    <T>  List<T> queryForList(String sql, Class<T> elementType) ;

    /**
     * 查询对象集合
     */
    List<Map<String,Object>> queryForList(String sql);

    /**
     * 查询对象集合
     */
    List<Map<String,Object>> queryForList(String sql, Object... args);

    /**
     * 删除数据
     */
    int deleteData(String sql, Object... args);

    /**
     * 更新数据
     */
    int  updateData(String sql, Object... args);

    /**
     * 插入数据
     */
    int insertData(String sql, Object... args);


    /**
     * 分页查询
     */
    List<Map<String,Object>> queryPagesList(String sql,int pages,int pageSize);
}
