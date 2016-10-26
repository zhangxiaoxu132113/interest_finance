package com.water.db.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/31.
 * 数据字典服务类
 */
public interface ISystemDDLService {

    String SERVICE_NAME = "com.water.db.service.impl.SystemDDLServiceImpl";

    /**
     * 获取投标的分类
     *
     */
    List<Map<String,Object>> findBidCategory();

    /**
     * 获取标的计息方式
     *
     */
    List<Map<String,Object>> findBearingWays();

    /**
     * 获取标的保障方式
     *
     */
    List<Map<String,Object>> findGuaranteeWays();

    /**
     * 获取标的还款方式
     *
     */
    List<Map<String,Object>> findRepaymentWays();

    /**
     * 获取平台背景的信息列表
     */
    List<Map<String,Object>> findPlatformBackgroundList();

    /**
     * 获取性别的信息列表
     */
    List<Map<String,Object>> findGenderList();

    /**
     * 获取部门的信息列表
     */
    List<Map<String,Object>> findDepartmentList();

    /**
     * 获取政治面貌的信息列表
     */
    List<Map<String,Object>> findPolitics();

    /**
     * 获取婚姻状态的信息列表
     */
    List<Map<String,Object>> findMarriages();

    /**
     * 获取工作职位的信息列表
     */
    List<Map<String,Object>> findJobName();

    /**
     * 获取接口类型
     */
    List<Map<String,Object>> findApiType();

    /**
     * 获取请求参数的类型
     */
    List<Map<String,Object>> findApiParams(HttpServletRequest request);

    /**
     * 添加平台的API接口请求参数的类型
     */
    boolean addPlatformParamFlag(HttpServletRequest request,String param_cn_flag,String param_en_flag);

    /**根据条件删除请求参数的属性*/
    boolean removeApiParamFlag(HttpServletRequest request, String name,String description);


}
