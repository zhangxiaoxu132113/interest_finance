package com.water.db.controller;

import com.water.db.entry.Produce;
import com.water.db.service.IPlatformService;
import com.water.db.service.IProduceService;
import com.water.db.service.ISystemDDLService;
import com.water.tools.lang.GlobalUtil;
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
 * Created by Zhang Miaojie on 16/8/31.
 * 标控制器
 */
@RestController
@RequestMapping(value = "/produce")
public class ProduceController {

    @Resource(name = GlobalUtil.PRODUCE_SERVICE)
    private IProduceService produceService;

    @Resource(name = GlobalUtil.PLATFORM_SERVICE)
    private IPlatformService platformService;

    @Resource(name = GlobalUtil.SYSTEMDDL_SERVICE)
    private ISystemDDLService systemDDLService;

    /**
     * @author      Zhang Miaojie
     * @description 查询投标的信息
     * @time        2016-08-31
     * @return      List<Map<String,Object>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Object> getProduceList() {


        Map<String,Object> resultJson = new HashMap<String,Object>();

        List<Map<String,Object>> produceList = produceService.getProduceList();
        List<Map<String,Object>> platformList = platformService.findPlatformList();

        List<Map<String,Object>> bidCategoryList = systemDDLService.findBidCategory();
        List<Map<String,Object>> bearingWayList = systemDDLService.findBearingWays();
        List<Map<String,Object>> guaranteeWayList = systemDDLService.findGuaranteeWays();
        List<Map<String,Object>> repaymentWayList = systemDDLService.findRepaymentWays();
        List<Map<String,Object>> platformBackgroundList = systemDDLService.findPlatformBackgroundList();

        resultJson.put("produceList",produceList);
        resultJson.put("platformList",platformList);
        resultJson.put("bidCategoryList",bidCategoryList);
        resultJson.put("bearingWayList",bearingWayList);
        resultJson.put("guaranteeWayList",guaranteeWayList);
        resultJson.put("repaymentWayList",repaymentWayList);
        resultJson.put("platformBackgroundList",platformBackgroundList);

        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加投标的信息
     * @time        2016-08-31
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addProduceInfo(@RequestBody Produce produce) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("in add produce method !");
        boolean flag = produceService.addProduceInfo(produce);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 修改投标的信息
     * @time        2016-08-31
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updateProduceInfo(@RequestBody Produce produce) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("in add produce method !");
        boolean flag = produceService.updateProduceInfo(produce);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据id删除投标的信息
     * @time        2016-08-31
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> deleteProduceById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        boolean flag = produceService.deleteProduceById(itemId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据条件查询标的信息
     * @time        2016-09-02
     * @return      List<Map<String,Object>>
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    public List<Map<String,Object>> queryProduceByCondition(HttpServletRequest request) {

        List<Map<String,Object>> produceList = new ArrayList<Map<String,Object>>();

        Map<String,Object> condition = new HashMap<String,Object>();
        Map<String,Object> rangeCondition = new HashMap<String,Object>();

        int module = Integer.parseInt(request.getParameter("module"));
        if (module != -1) condition.put("module",module);

        int startAmount = Integer.parseInt(request.getParameter("startAmount"));
        if (startAmount != -1) condition.put("startAmount",startAmount);

        int platformBackgroundID = Integer.parseInt(request.getParameter("platformBackgroundID"));
        if (platformBackgroundID != -1) condition.put("p_Background",platformBackgroundID);

        String returnRate = request.getParameter("returnRate");
        if (!"".equals(returnRate)) rangeCondition.put("returnRate",returnRate);

        String returnDate = request.getParameter("returnDate");
        if (!"".equals(returnDate)) rangeCondition.put("returnDate",returnDate);

        produceList = produceService.queryProduceByCondition(condition,rangeCondition);
        return produceList;
    }
}
