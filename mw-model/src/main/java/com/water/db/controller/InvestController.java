package com.water.db.controller;

import com.water.db.service.IInvestService;
import com.water.db.service.IPlatformService;
import com.water.tools.implUtil.SendRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/6.
 * 前往投资控制器
 */
@Controller
@RequestMapping(value = "/invest")
public class InvestController {

    @Resource(name = IInvestService.SERVICE_NAME)
    private IInvestService investService;

    @Resource(name = IPlatformService.SERVICE_NAME)
    private IPlatformService platformService;

    /**
     * @author      Meng Sheng
     * @description 查询本地数据库是否已开通X平台账户
     * @time        2016-09-6
     * @return      /WEB-INF/page/borrow/detail.jsp
     */
    @RequestMapping(value = "/queryInvest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object>  detail2queryPlatform(HttpServletRequest request) {
        Map<String,Object> resultJson = new HashMap<String,Object>();
        int userId = Integer.parseInt(request.getParameter("userId"));//兴趣金融用户id
        int platformId = Integer.parseInt(request.getParameter("platformId"));//第三方平台ID

        /**查询数据库是否已开通X平台，账户表t_platform_relation*/
        Map<String,Object> resultUserMap = investService.findPlaRelaByUIdAndPId(userId,platformId);
        if(resultUserMap == null){
            //未开通X平台账户
            resultJson.put("open_status",0);
        }else{
            //已开通X平台账户
            resultJson.put("open_status",1);
        }
        return resultJson;
    }

    /**
     * @author      Meng Sheng
     * @description 调用第三方接口，查询是否已注册，若未注册就提交信息注册。若已注册则返回提示信息
     * @time        2016-09-09
     * @return      /WEB-INF/page/borrow/detail.jsp
     */
    @RequestMapping(value = "/goInvest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object>  detail2toPlatformRegister(HttpServletRequest request) {
        Map<String,Object> resultJson = new HashMap<String,Object>();

        System.out.println("in detail2toPlatformRegister ....");
        String phone = request.getParameter("phone");//手机号码
        int userId = Integer.parseInt(request.getParameter("userId"));//用户ID
        int platformId = Integer.parseInt(request.getParameter("platformId"));//平台ID

        /**目前只允许跳转至富金利平台操作*/
        if(platformId != 30){
            System.out.println("目前还不能跳转至除了富金利平台的操作。。。");
            return  null;
        }

        /**查询本地数据库获取第三方是否注册接口参数信息*/
        Map<String,Object> api_map = platformService.queryPlatformApi(platformId,1);
        //将请求参数封装为map对象
        Map<String,Object> que_map = SendRequestUtil.mapUtil(api_map,phone);

        //查询是否注册的接口地址
        String url_que = (String)api_map.get("URL");
        //调用第三方接口，查询手机号码在第三方平台是否已注册
        String que_status = SendRequestUtil.sendRequest(url_que, que_map);
        System.out.println("查询是否注册状态码:"+que_status);

        if(que_status.equals("10001")){
            /**用户未注册，提交参数到第三方平台注册*/
            resultJson.put("status",3);//测试，暂时不能提交给第三方注册操作
            System.out.println("测试阶段，不进行提交数据至第三方平台注册 ");

            /**Map<String,Object> api_map2 = platformService.queryPlatformApi(platformId,2);
            //将请求参数封装为map对象
            Map<String,Object> reg_map = SendRequestUtil.mapUtil(api_map,phone);
            //注册第三方账户接口地址
            String url_reg = (String)api_map2.get("URL");
            //调用第三方接口，注册第三方账户
            String reg_status = SendRequestUtil.sendRequest(url_reg, reg_map);
            System.out.println("注册状态码:"+reg_status);

            if(reg_status.equals("20001")){
                System.out.println("注册成功!");
                //注册成功，添加账户表t_platform_relation
                investService.savePlatformRelation(userId,platformId);
                resultJson.put("status",1);
            }else if(reg_status.equals("20000")){
                //注册失败
                resultJson.put("status",2);
            } */

        }else if(que_status.equals("10000")){
            //账号已注册！
            resultJson.put("status",0);
        }
        return resultJson;
    }


}
