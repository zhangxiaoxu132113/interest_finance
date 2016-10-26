package com.water.db.controller;

import com.water.db.service.IIntegralService;
import com.water.tools.lang.GlobalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Meng Sheng on 2016/9/19.
 * 积分控制器
 */
@Controller
@RequestMapping(value = "/user/integral")
public class IntegralController {

    @Resource(name = GlobalUtil.INTEGRAL_SERVICE)
    private IIntegralService integralService;

    /**
     * @author      MengSheng
     * @descrition  查询积分明细列表
     * @time        2016/9/19
     */
    @RequestMapping(value="/integralList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> findIntegralListByUid(HttpServletRequest request){

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = integralService.findIntegralByUid(userId);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  查询本月获得积分
     * @time        2016/9/19
     */
    @RequestMapping(value="/integralSumTotal", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findMonthTotalIntegralByUid(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        //获取本月的开始日期和结束日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前月第一天：
        Calendar c_firs = Calendar.getInstance();
        c_firs.add(Calendar.MONTH, 0);//设置当前月
        c_firs.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String firstDay = df.format(c_firs.getTime());
        //获取当前月最后一天
        Calendar c_last = Calendar.getInstance();
        c_last.set(Calendar.DAY_OF_MONTH, c_last.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDay = df.format(c_last.getTime());
        Timestamp startDate = Timestamp.valueOf(firstDay);//开始日期
        Timestamp endDate = Timestamp.valueOf(lastDay);//结束日期
        resultJson = integralService.findIntegralMonthByUid(userId,startDate,endDate);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  查询累计获得积分
     * @time        2016/9/19
     */
    @RequestMapping(value="/integralTotal", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findTotalIntegralByUid(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = integralService.findSumIntegralByUid(userId);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  查询该用户最新的积分记录
     * @time        2016/9/19
     */
    @RequestMapping(value="/integralLatest", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findLatestIntegralByUid(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = integralService.findLatestIntegralByUid(userId);
        return resultJson;
    }

}
