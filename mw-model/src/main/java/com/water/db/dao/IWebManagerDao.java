package com.water.db.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface IWebManagerDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.dao.impl.WebManagerDaoImpl";

    /**保存网站设置*/
    int saveWebSetting(String webDescription, String webKey, String webTitle);

    /**删除网站设置*/
    int deleteWebSettingByDdlCode();

    /**查询网站设置信息*/
    Map<String,Object> findWebSetting();

    /**查询轮播图片列表*/
    List<Map<String,Object>> findCarouseImgs();

    /**添加轮播图片*/
    int addCarouseImg(String urlAddr, int picId, int sortBy);

    /**更新轮播图片信息*/
    int updateCarouselImgById(String urlAddr, int picId, int sortBy, int carouselId);

    /**根据id删除轮播图片*/
    int deleteCarouselById(int carouselInt);

    /**查询友情链接列表数据*/
    List<Map<String,Object>> findLinks();

    /**添加友情链接*/
    int addLink(String linkName, String linkUrl, int sortBy);

    /**更新友情链接*/
    int updateLink(String linkName, String linkUrl, int sortBy, int itemID);

    /**删除友情链接*/
    int deleteLinkById(int linkId);

    /**保存合作伙伴信息*/
    int addPartnerInfo(String partnerName, String partnerLinkUrl, int picId, int partnerSortBy);

    /**查询合作伙伴信息列表*/
    List<Map<String,Object>> findPartner();

    /**删除合作伙伴信息*/
    int deletePartnerById(int partnerId);
}
