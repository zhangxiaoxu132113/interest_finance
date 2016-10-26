package com.water.db.controller.admin;

import com.water.db.service.IBidService;
import com.water.db.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/9/14.
 *
 */
@RestController
@RequestMapping(value = "/fundManager")
public class FundManagementController {

    @Resource(name = IBidService.SERVICE_NAME)
    private IBidService bidService;

    @Resource(name = IUserService.SERVICE_NAME)
    private IUserService userService;

    /**
     * @author      Zhang Miaojie
     * @description 保存网站设置
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/getRebateList", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Object> getRebateList() {

        Map<String,Object> returnJson = new HashMap<String,Object>();

        //获取用户的投资的列表信息
        List<Map<String,Object>> rebateInfoList = bidService.findRebateInfoList();
        returnJson.put("rebateInfoList",rebateInfoList);

        //标的的信息列表
        List<Map<String,Object>> bidInfoList =  bidService.findAllBidInfo();
        returnJson.put("bidInfoList",bidInfoList);

        //用户的手机号码列表
        List<Map<String,Object>> userTelphoneList = userService.findTelphoneByCondition("1");
        returnJson.put("userTelphoneList",userTelphoneList);

        return returnJson;
    }
}
