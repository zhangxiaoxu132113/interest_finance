package com.water.db.controller;

import com.water.db.service.IPlatformService;
import com.water.db.service.IProduceService;
import com.water.tools.lang.GlobalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhang Miaojie on 2016/8/10.
 * 平台列表控制器
 */
@Controller
@RequestMapping(value = "/borrow")
public class BorrowController {

    @Resource(name = GlobalUtil.PRODUCE_SERVICE)
    private IProduceService produceService;

    @Resource(name = GlobalUtil.PLATFORM_SERVICE)
    private IPlatformService platformService;

    /**
     * @author      Zhang Miaojie
     * @description 跳转到用户模块【会员权益页面】
     * @time        2016-08-10
     * @return      /WEB-INF/page/borrow/index.jsp
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String redirect2borrowList() {

        return "/borrow/index";
    }

    @RequestMapping(value = "/produce/{produceId}", method = RequestMethod.GET)
    public ModelAndView redirect2BorrowProduce(@PathVariable String produceId) {

        System.out.println("produceId : "+produceId);
        Map<String,Object> resultJson = new HashMap<String,Object>();
        int produceIdInt = Integer.parseInt(produceId);
        Map<String,Object> bidInfo = produceService.findProduceById(produceIdInt);
        int platformId = (Integer) bidInfo.get("PLATFORMID");
        Map<String,Object> platformInfo = platformService.findPlatformById(platformId);
        resultJson.put("bidInfo",bidInfo);
        resultJson.put("platformInfo",platformInfo);
        return new ModelAndView("/borrow/detail","resultJson",resultJson);
    }
}
