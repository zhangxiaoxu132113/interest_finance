package com.water.db.controller.admin;

import com.water.db.service.IWebManagerService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/8/23.
 *
 */
@RestController
@RequestMapping(value = "/webManager")
public class WebManagerController {

    @Resource(name = IWebManagerService.SERVICE_NAME)
    private IWebManagerService webManagerService;


    /**
     * @author      Zhang Miaojie
     * @description 保存网站设置
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/saveSetting", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> webSetting(HttpServletRequest request) {

        Map<String,Object> result = new HashMap<String,Object>();
        Map<String,Object> settingMap = new HashMap<String,Object>();

        String webDescription = MWStringUtils.getParameterByRequest(request,"webDescription");
        String webKey = MWStringUtils.getParameterByRequest(request,"webKey");
        String webTitle = MWStringUtils.getParameterByRequest(request,"webTitle");

        System.out.println("webDescription = "+webDescription + ", webKey = "+webKey + ", webTitle = "+webTitle);
        boolean flag = webManagerService.saveWebSetting(webDescription,webKey,webTitle);
        if (flag) {
            result.put("status",0);
            return result;
        }

        result.put("status",1);
        return result;
    }

    /**
     * @author      Zhang Miaojie
     * @description 查询网站设置
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/findSetting", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Object> findWebSetting(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        resultJson = webManagerService.findWebSetting();
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 查询网站首页轮播图片列表
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/findCarouselImgs", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findCarouselImgs() {

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        resultJson = webManagerService.findCarouselImgs();

        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加轮播图片
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/addCarouselImg", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addCarouselImg(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String urlAddr = request.getParameter("urlAddr");
        String imgUrl = request.getParameter("imgUrl");
        String sortBy = request.getParameter("sortBy");
        int sortByInt = Integer.parseInt(sortBy);

        boolean flag = webManagerService.addCarouselImg(urlAddr,imgUrl,sortByInt);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 更新轮播图片
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/updateCarouselImg", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updateCarouselImg(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String urlAddr = request.getParameter("urlAddr");
        String imgUrl = request.getParameter("imgUrl");
        int sortBy = Integer.parseInt(request.getParameter("sortBy"));
        int carouselId = Integer.parseInt(request.getParameter("carouselId"));

        boolean flag = webManagerService.updateCarouselImgById(urlAddr,imgUrl,sortBy,carouselId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;

    }
    /**
     * @author      Zhang Miaojie
     * @description 删除轮播图片
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/deleteCarouselById", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> deleteCarouselById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String strId = request.getParameter("carouselId");
        int carouselId = Integer.parseInt(strId);

        webManagerService.deleteCarouselById(carouselId);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 查询网站首页轮播图片列表
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/findLinks", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findLinks() {

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        resultJson = webManagerService.findLinks();

        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加友情链接
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/addLink", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addLink(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String linkName = MWStringUtils.getParameterByRequest(request,"linkName");
        String linkUrl = MWStringUtils.getParameterByRequest(request,"linkUrl");
        String sortBy = MWStringUtils.getParameterByRequest(request,"sortBy");
        int sortByInt = Integer.parseInt(sortBy);

        boolean flag = webManagerService.addLink(linkName, linkUrl, sortByInt);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 更新友情链接
     * @time        2016-10-26
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/updateLink", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updateLink(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String linkName = MWStringUtils.getParameterByRequest(request,"linkName");
        String linkUrl = MWStringUtils.getParameterByRequest(request,"linkUrl");
        String sortBy = MWStringUtils.getParameterByRequest(request,"sortBy");
        int sortByInt = Integer.parseInt(sortBy);
        int itemID = Integer.parseInt(request.getParameter("itemID"));

        boolean flag = webManagerService.updateLink(linkName, linkUrl, sortByInt, itemID);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 删除友情链接
     * @time        2016-08-24
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/removeLink", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> removeLink(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String linkId = request.getParameter("linkId");
        int linkIdInt = Integer.parseInt(linkId);

        boolean flag = webManagerService.deleteLinkById(linkIdInt);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加网站合作伙伴的信息
     * @time        2016-08-24
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/addPartner", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addPartner(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String partnerName = MWStringUtils.getParameterByRequest(request,"partnerName");
        String partnerLinkUrl = MWStringUtils.getParameterByRequest(request,"partnerLinkUrl");
        String partnerImgUrl = MWStringUtils.getParameterByRequest(request,"partnerImgUrl");
        int partnerSortBy = Integer.parseInt(MWStringUtils.getParameterByRequest(request,"partnerSortBy"));

        boolean flag = webManagerService.addPartnerInfo(partnerName,partnerLinkUrl,partnerImgUrl,partnerSortBy);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 查询合作伙伴的列表信息
     * @time        2016-08-24
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/findPartners", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findPartners() {

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        resultJson = webManagerService.findPartners();
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据ID删除合作伙伴的信息
     * @time        2016-08-24
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/removePartnerById", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> removePartnerById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int partnerId = Integer.parseInt(request.getParameter("partnerId"));
        boolean flag = webManagerService.deletePartnerById(partnerId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }
}
