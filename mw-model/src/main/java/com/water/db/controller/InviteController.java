package com.water.db.controller;

import com.water.db.service.IInviteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 * 我的推广控制器
 */
@Controller
@RequestMapping(value = "/user/invite")
public class InviteController {

    @Resource(name = IInviteService.SERVICE_NAME)
    private IInviteService inviteService;

    /**
     * @author      MengSheng
     * @description 点击我的推广链接跳转至邀请新用户注册页面
     * @time        2016-08-23
     * @return      /common/registerInvite.jsp
     */
    @RequestMapping(value = "/register/{inviteCode}.html", method = RequestMethod.GET)
    public String inviteRegister(@PathVariable String inviteCode, Model model) {

        model.addAttribute("inviteCode",inviteCode);
        return "/common/registerInvite";
    }

    /**
     * @author      MengSheng
     * @descrition  获取被推荐人列表
     * @time        2016/8/26
     */
    @RequestMapping(value="/inviteList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> inviteList(HttpServletRequest request){

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = inviteService.findInviteListByUserId(userId);
        //给手机号码中间打上星号
        for(int i = 0 ;i < resultJson.size();i++){
            String str = (String)resultJson.get(i).get("USERNAME");
            str = str.replace(str.substring(3,7),"****");
            resultJson.get(i).put("USERNAME",str);
        }
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  获取累计被推荐人数
     * @time        2016/8/26
     */
    @RequestMapping(value="/inviteTotalPerson", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Map<String,Object>> inviteTotalPerson(HttpServletRequest request){

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = inviteService.findInvitesCountByUserId(userId);
        return resultJson;
    }

}
