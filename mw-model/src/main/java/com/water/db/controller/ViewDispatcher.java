package com.water.db.controller;

import com.water.db.service.IArticleService;
import com.water.db.service.IProduceService;
import com.water.db.service.IWebManagerService;
import com.water.tools.lang.GlobalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Miaojie on 16/6/4.
 * 视图转发器
 */
@Controller
public class ViewDispatcher {

    @Resource(name = GlobalUtil.WEBMANAGER_SERVICE)
    private IWebManagerService webManagerService;

    @Resource(name = GlobalUtil.PRODUCE_SERVICE)
    private IProduceService produceService;

    @Resource(name = GlobalUtil.ARTICLE_SERVICE)
    private IArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView redirect2home() {
        System.out.println("跳转首页!");
        Map<String,Object> resultJson = new HashMap<String,Object>();

        //获取展示在首页的数据
        List<Map<String,Object>> carouseImgs =  webManagerService.findCarouselImgs();
        List<Map<String,Object>> lists = webManagerService.findLinks();
        List<Map<String,Object>> partners = webManagerService.findPartners();
        Map<String,Object> webSetting = webManagerService.findWebSetting();

        //获取新手标和精选标的数据
        List<Map<String,Object>> bidByNewComers = produceService.findBidByNewComer(3);
        List<Map<String,Object>> bidByCuratons = produceService.findBidByCuraton(6);

        //获取文章模块的数据
        List<Map<String,Object>> industryArticles =  articleService.findIndustryInfo(6);    //行业资讯
        List<Map<String,Object>> companyInfos =  articleService.findcompanyInfos(6);    //公司公告


        resultJson.put("partners",partners);                    //合作伙伴
        resultJson.put("carouseImgs",carouseImgs);              //轮播图片
        resultJson.put("bidByNewComers",bidByNewComers);        //新手标信息
        resultJson.put("bidByCuratons",bidByCuratons);          //精选标信息

        resultJson.put("industryArticles",industryArticles);    //行业资讯
        resultJson.put("companyInfos",companyInfos);    //行业资讯



        return new ModelAndView("/index","resultJson",resultJson);
    }


}
