package com.water.db.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface IWebManagerService {

    String SERVICE_NAME = "com.water.db.service.impl.WebManagerServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 保存网站设置
     * @time        2016-08-23
     * @return      boolean
     */
    boolean saveWebSetting(String webDecription, String webKey, String webTitle);

    /**
     * @author      Zhang Miaojie
     * @description  查询网站设置的信息
     * @time        2016-08-23
     * @return      Map<String,Object>
     */
    Map<String,Object> findWebSetting();

    /**
     * @author      Zhang Miaojie
     * @description 查询网站首页轮播图片的集合数据
     * @time        2016-08-23
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findCarouselImgs();

    /**
     * @author      Zhang Miaojie
     * @description 添加轮播图片
     * @time        2016-08-23
     * @return      boolean
     */
    boolean addCarouselImg(String urlAddr, String imgUrl, int sortBy);

    /**
     * @author      Zhang Miaojie
     * @description 根据id删除轮播图片
     * @time        2016-08-24
     * @return      boolean
     */
    boolean deleteCarouselById(int carouselId);

    /**
     * @author      Zhang Miaojie
     * @description 查询网站友情链接的列表信息
     * @time        2016-08-23
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findLinks();

    /**
     * @author      Zhang Miaojie
     * @description 添加网站友情链接
     * @time        2016-08-23
     * @return      boolean
     */
    boolean addLink(String linkName, String linkUrl, int sortBy);

    /**
     * @author      MengSheng
     * @description 更新网站友情链接
     * @time        2016-10-26
     * @return      boolean
     */
    boolean updateLink(String linkName, String linkUrl, int sortBy, int itemID);

    /**
     * @author      Zhang Miaojie
     * @description 移除网站友情链接
     * @time        2016-08-24
     * @return      boolean
     */
    boolean deleteLinkById(int linkId);

    /**
     * @author      Zhang Miaojie
     * @description 添加合作伙伴的信息
     * @time        2016-08-24
     * @return      boolean
     */
    boolean addPartnerInfo(String partnerName, String partnerLinkUrl, String partnerImgUrl,int partnerSortBy);

    /**
     * @author      Zhang Miaojie
     * @description 添加合作伙伴的信息
     * @time        2016-08-24
     * @return      List<Map<String,Object>>
     */
    List<Map<String,Object>> findPartners();

    /**
     * @author      Zhang Miaojie
     * @description 删除合作伙伴的信息
     * @time        2016-08-24
     * @return      boolean
     */
    boolean deletePartnerById(int partnerId);

    /**
     * @author      Zhang Miaojie
     * @description 更新轮播图片的信息
     * @time        2016-09-27
     * @return      boolean
     */
    boolean updateCarouselImgById(String urlAddr, String imgUrl,int sortBy, int carouselId);

}
