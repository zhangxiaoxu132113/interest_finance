package com.water.db.service.impl;

import com.water.db.dao.IPhotoDao;
import com.water.db.dao.IWebManagerDao;
import com.water.db.service.IWebManagerService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 *
 */
@Service(IWebManagerService.SERVICE_NAME)
@Transactional(readOnly = true)
public class WebManagerServiceImpl implements IWebManagerService {

    @Resource(name = IWebManagerDao.SERVICE_NAME)
    private IWebManagerDao webManagerDao;

    @Resource(name = IPhotoDao.SERVICE_NAME)
    private IPhotoDao photoDao;

    @Override
    @Transactional(readOnly = false,isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean saveWebSetting(String webDecription, String webKey, String webTitle) {

        MWStringUtils.isBlank(webDecription,webKey,webTitle);
        webManagerDao.deleteWebSettingByDdlCode();
        int effectRow = webManagerDao.saveWebSetting(webDecription,webKey,webTitle);
        if (effectRow != 0) return true;

        return false;
    }

    @Override
    public Map<String, Object> findWebSetting() {

        return webManagerDao.findWebSetting();
    }

    @Override
    public List<Map<String, Object>> findCarouselImgs() {

        return webManagerDao.findCarouseImgs();
    }

    @Override
    @Transactional(readOnly = false,isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean addCarouselImg(String urlAddr, String imgUrl, int sortBy) {

        MWStringUtils.isBlank(urlAddr,imgUrl,sortBy);
        int picId = photoDao.saveImgUrl(imgUrl);
        int effectRows = webManagerDao.addCarouseImg(urlAddr,picId,sortBy);

        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean deleteCarouselById(int carouselId) {

        int effectRows = webManagerDao.deleteCarouselById(carouselId);

        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findLinks() {

        return webManagerDao.findLinks();
    }

    @Override
    public boolean addLink(String linkName, String linkUrl, int sortBy) {

        MWStringUtils.isBlank(linkName, linkUrl, sortBy);

        int effectRows = webManagerDao.addLink(linkName, linkUrl, sortBy);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean updateLink(String linkName, String linkUrl, int sortBy, int itemID){
        MWStringUtils.isBlank(linkName, linkUrl, sortBy, itemID);

        int effectRows = webManagerDao.updateLink(linkName, linkUrl, sortBy,itemID);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean deleteLinkById(int linkId) {

        int effectRows = webManagerDao.deleteLinkById(linkId);
        if (effectRows != 0) return true;

        return false;
    }

    @Override
    public boolean addPartnerInfo(String partnerName, String partnerLinkUrl, String partnerImgUrl, int partnerSortBy) {

        MWStringUtils.isBlank(partnerName,partnerLinkUrl,partnerImgUrl,partnerSortBy);
        int picId = photoDao.saveImgUrl(partnerImgUrl);
        int effectRows = webManagerDao.addPartnerInfo(partnerName,partnerLinkUrl,picId,partnerSortBy);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findPartners() {

        return webManagerDao.findPartner();
    }

    @Override
    public boolean deletePartnerById(int partnerId) {

        int effectRow = webManagerDao.deletePartnerById(partnerId);
        if (effectRow != 0) return true;
        return false;
    }

    @Override
    public boolean updateCarouselImgById(String urlAddr, String imgUrl, int sortBy, int carouselId) {

        MWStringUtils.isBlank(urlAddr,imgUrl,sortBy);
        int picId = photoDao.saveImgUrl(imgUrl);
        int effectRows = webManagerDao.updateCarouselImgById(urlAddr,picId,sortBy,carouselId);
        if (effectRows != 0) return true;
        return false;
    }
}
