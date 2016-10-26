package com.water.db.controller;

import com.water.db.entry.PlatformAPI;
import com.water.db.entry.PlatformInfo;
import com.water.db.service.IPlatformService;
import com.water.db.service.ISystemDDLService;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.lang.MWStringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Miaojie on 16/8/30.
 * 平台信息控制器类
 */
@RestController
@RequestMapping(value = "/platform")
public class PlatformController {

    @Resource(name = GlobalUtil.PLATFORM_SERVICE)
    private IPlatformService platformService;

    @Resource(name = GlobalUtil.SYSTEMDDL_SERVICE)
    private ISystemDDLService systemDDLService;
    /**
     * @author      Zhang Miaojie
     * @description 添加第三方平台信息
     * @time        2016-08-30
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addPlatformInfo(@RequestBody PlatformInfo platformInfo) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("platform : "+platformInfo);
        boolean flag = platformService.addPlatformInfo(platformInfo);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 修改第三方平台信息
     * @time        2016-08-30
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updatePlatformInfo(@RequestBody PlatformInfo platformInfo) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("platform-utime : "+platformInfo.getUptime());
        boolean flag = platformService.updatePlatformInfo(platformInfo);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }


    /**
     * @author      Zhang Miaojie
     * @description 查询第三方p2p平台列表信息
     * @time        2016-08-30
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String, Object>> getPlatformList() {

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        resultJson = platformService.findPlatformList();
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据ID删除平台信息
     * @time        2016-08-30
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String, Object> deletePlatformById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        boolean flag = platformService.deletePlatformById(itemId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 获取平台下所有的平台背景类型
     * @time        2016-09-02
     * @return     List<Map<String,Object>>
     */
    @RequestMapping(value = "/findPlatformBackgronud", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findPlatformBackgronud() {

        List<Map<String,Object>> platformBackgrondList = new ArrayList<Map<String,Object>>();
        platformBackgrondList = systemDDLService.findPlatformBackgroundList();
        return platformBackgrondList;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加接口信息，获取模板数据
     * @time        2016-10-17
     * @return     List<Map<String,Object>>
     */
    @RequestMapping(value = "/addApiWithInfo", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Object> addApiWithInfo(HttpServletRequest request) {

        Map<String,Object> param = new HashMap<String,Object>();
        List<Map<String,Object>> platformList = platformService.findPlatformList();
        List<Map<String,Object>> apiTypeList = systemDDLService.findApiType();
        List<Map<String,Object>> apiParamList = systemDDLService.findApiParams(request);

        param.put("platformList",platformList);
        param.put("apiTypeList",apiTypeList);
        param.put("apiParamList",apiParamList);

        return param;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加接口信息，获取模板数据
     * @time        2016-10-17
     * @return     List<Map<String,Object>>
     */
    @RequestMapping(value = "/api/add", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addPlatformApi(@RequestBody PlatformAPI platformAPI) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        boolean flag = platformService.addPlatformApi(platformAPI);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 获取平台的API接口列表
     * @time        2016-10-24
     * @return     List<Map<String,Object>>
     */
    @RequestMapping(value = "/api/findPlatformApiList", method = RequestMethod.POST, produces = "application/json")
    public List<Map<String,Object>> findPlatformApiList() {

        List<Map<String,Object>> resultJson = platformService.findPlatformApiList();
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 根据平台和接口类型查询API接口
     * @time        2016-10-24
     * @return     Map<String,Object>
     */
    @RequestMapping(value = "/api/queryAPI", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> queryAPI(HttpServletRequest request) {

        int platformId = Integer.parseInt(request.getParameter("platformId"));
        int apiFlag = Integer.parseInt(request.getParameter("apiFlag"));
        List<Map<String,Object>> resultJson = platformService.queryAPI(platformId,apiFlag);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 根据ID删除接口信息
     * @time        2016-10-24
     * @return
     */
    @RequestMapping(value = "/api/removeAPI", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> deletePlatformAPIById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        boolean flag = platformService.deletePlatformAPIById(itemId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加接口信息，获取模板数据
     * @time        2016-10-19
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/api/addParamFlag", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addParamFlag(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String param_en_flag = MWStringUtils.getParameterByRequest(request,"param_en_flag");
        String param_cn_flag = MWStringUtils.getParameterByRequest(request,"param_cn_flag");

        boolean flag = systemDDLService.addPlatformParamFlag(request,param_cn_flag,param_en_flag);
        if (flag) {
            List<Map<String,Object>> apiParamList = systemDDLService.findApiParams(request);
            resultJson.put("status",0);
            resultJson.put("apiParamList",apiParamList);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }
//    /platform/api/removeParamFlag

    /**
     * @author      Zhang Miaojie
     * @description 删除接口参数类别信息
     * @time        2016-10-20
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/api/removeParamFlag", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> removeParamFlag(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String name = MWStringUtils.getParameterByRequest(request,"name");
        String description = MWStringUtils.getParameterByRequest(request,"description");

        boolean flag = systemDDLService.removeApiParamFlag(request,name,description);
        if (flag) {

            List<Map<String,Object>> apiParamList = systemDDLService.findApiParams(request);
            resultJson.put("status",0);
            resultJson.put("apiParamList",apiParamList);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }
}
