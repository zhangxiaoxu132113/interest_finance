package com.water.db.controller;

import com.water.db.service.IMessageService;
import com.water.db.service.IUserService;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.lang.RandomUtils;
import com.water.tools.msgUtil.SendMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhang Miaojie on 2016/8/15.
 * 短信控制器
 */
@RestController
@RequestMapping(value = "/msg")
public class MessageController {

    @Resource(name = GlobalUtil.MESSAGE_SERVICE)
    private IMessageService messageService;

    @Resource(name = GlobalUtil.USER_SERVICE)
    private IUserService userService;

    /**
     * @author      Zhang Miaojie
     * @description 发送手机短信注册验证码
     * @time        2016-08-16
     * @return
     */
    @RequestMapping(value = "/sendCodeWithRegister", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> sendVerificationCodeWithRegister(HttpServletRequest request) throws IOException {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String tel_phone = request.getParameter("tel_phone");
        //验证输入的手机号码是否已经注册过的
        Map<String,Object> userMap = messageService.findUserByTelPhone(tel_phone);
        if (userMap != null) {
            //返回JSON说明手机号码已经被注册过
            resultJson.put("status",1);
            return resultJson;
        }
        //获取随机的四位数的验证码
        String randomCode = RandomUtils.getRandNum(4);

        //调用短信接口发送信息
        Map<String,Object> resultMap = SendMsg.sendMsgCode(tel_phone,randomCode);
        System.out.println("调用短信接口返回状态："+resultMap.get("respstatus"));
        if (resultMap.get("respstatus") != null && resultMap.get("respstatus").equals("0")) {
            //成功发送验证码
            //将手机号码和验证码保存到数据库中[或者将数据保存到缓存中]
            messageService.saveVerificationCode(tel_phone,randomCode);
            resultJson.put("status",0);
            return resultJson;
        }
        //短信接口调用失败
        resultJson.put("status",2);
        return resultJson;

    }

    /**
     * @author      Zhang Miaojie
     * @description 找回密码，发送手机短信注册验证码
     * @time        2016-08-16
     * @return
     */
    @RequestMapping(value = "/sendCodeWithRecoverPwd", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> sendCodeWithRecoverPwd(HttpServletRequest request) throws IOException {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String tel_phone = request.getParameter("tel_phone");
        //根据手机号码验证数据库是否存在该用户
        boolean isExist = userService.findUserByTelphone(tel_phone);
        if (!isExist) {
            resultJson.put("status",1);
            return resultJson;
        }

        //删除数据库中的验证码
        messageService.deleteCodeData(tel_phone);

        //获取随机的四位数的验证码
        String randomCode = RandomUtils.getRandNum(4);

        //调用短信接口发送信息
        Map<String,Object> resultMap = SendMsg.sendMsgCode(tel_phone,randomCode);
        System.out.println("调用短信接口返回状态："+resultMap.get("respstatus"));
        if (resultMap.get("respstatus") != null && resultMap.get("respstatus").equals("0")) {
            //成功发送验证码
            //将手机号码和验证码保存到数据库中[或者将数据保存到缓存中]
            messageService.saveVerificationCode(tel_phone,randomCode);
            resultJson.put("status",0);
            return resultJson;
        }
        //短信接口调用失败
        resultJson.put("status",2);
        return resultJson;

    }

    /**
     * @author      MengSheng
     * @description 绑定银行卡，发送手机短信验证码
     * @time        2016-09-21
     * @return
     */
    @RequestMapping(value = "/sendCodeWithBindCard", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> sendCodeWithBindCard(HttpServletRequest request) throws IOException {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String tel_phone = request.getParameter("tel_phone");

        //获取随机的四位数的验证码
        String randomCode = RandomUtils.getRandNum(4);

        //调用短信接口发送信息
        Map<String,Object> resultMap = SendMsg.sendMsgCode(tel_phone,randomCode);
        System.out.println("调用短信接口返回状态："+resultMap.get("respstatus"));
        if (resultMap.get("respstatus") != null && resultMap.get("respstatus").equals("0")) {
            //成功发送验证码
            //将手机号码和验证码保存到数据库中[或者将数据保存到缓存中]
            messageService.saveVerificationCode(tel_phone,randomCode);
            resultJson.put("status",0);
            return resultJson;
        }
        //短信接口调用失败
        resultJson.put("status",1);
        return resultJson;

    }

    /**
     * @author      MengSheng
     * @description 认证手机号码，发送手机短信验证码
     * @time        2016-09-22
     * @return
     */
    @RequestMapping(value = "/sendCodeWithRzTel", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> sendCodeWithRzTel(HttpServletRequest request) throws IOException {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String tel_phone = request.getParameter("tel_phone");

        //获取随机的四位数的验证码
        String randomCode = RandomUtils.getRandNum(4);

        //调用短信接口发送信息
        Map<String,Object> resultMap = SendMsg.sendMsgCode(tel_phone,randomCode);
        System.out.println("调用短信接口返回状态："+resultMap.get("respstatus"));
        if (resultMap.get("respstatus") != null && resultMap.get("respstatus").equals("0")) {
            //成功发送验证码
            //将手机号码和验证码保存到数据库中[或者将数据保存到缓存中]
            messageService.saveVerificationCode(tel_phone,randomCode);
            resultJson.put("status",0);
            return resultJson;
        }
        //短信接口调用失败
        resultJson.put("status",1);
        return resultJson;

    }

}
