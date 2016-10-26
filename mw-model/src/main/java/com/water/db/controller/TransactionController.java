package com.water.db.controller;

import com.water.db.service.ITransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/15.
 *交易详细记录控制器
 */
@Controller
@RequestMapping(value = "/user/transaction")
public class TransactionController {

    @Resource(name = ITransactionService.SERVICE_NAME)
    private ITransactionService transactionService;

    /**
     * @author      Meng Sheng
     * @description 添加交易详细记录
     * @time        2016-09-08
     * @return
     */
    @RequestMapping(value="/saveTrans", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> saveTransaction(HttpServletRequest request){
        Map<String,Object> resultJson = new HashMap<>();
        /**int userId=Integer.parseInt(request.getParameter("userId"));
        Timestamp createTime = new Timestamp(new Date().getTime());
        String amount=request.getParameter("amount");//交易金额
        //TODO
        //交易类型
         int type = 1;
        //TODO
        //交易类型
        int status = 0;
        String remark = "";
        //添加交易详细
        boolean trans_flag = transactionService.saveTransaction(userId,createTime,amount,type,status,remark);
        //同时更新账户总额
        BigDecimal totalaccount = new BigDecimal(amount);
        boolean total_flag = transactionService.updateUserTotalaccountByUid(totalaccount,userId);
        if(trans_flag && total_flag){
            //保存成功
            resultJson.put("status","0");
        }else{
            //保存失败
            resultJson.put("status","1");
        }*/
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  查询交易详细
     * @time        2016/9/15
     */
    @RequestMapping(value="/findTransByUid", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findTransByUid(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<String,Object>();

        int userId=Integer.parseInt(request.getParameter("userId"));
        List<Map<String,Object>> transactions = transactionService.findTransactionsByUid(userId);
        Map<String,Object> investmentDetail = transactionService.findInvestmentDetailByUid(userId);
        resultJson.put("transactions",transactions);
        resultJson.put("investmentDetail",investmentDetail);

        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  删除单行交易详细记录
     * @time        2016/9/15
     */
    @RequestMapping(value="/deleteTrans", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> deleteTrans(HttpServletRequest request){
        Map<String,Object> resultJson = new HashMap<>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        int Tid=Integer.parseInt(request.getParameter("Tid"));
        boolean flag = transactionService.deleteTransactionByUidAndTid(userId,Tid);
        if(flag){
            //删除成功
            resultJson.put("status","0");
        }else{
            //删除失败
            resultJson.put("status","1");
        }
        return resultJson;
    }


}
