package com.water.db.dao.impl;

import com.water.db.dao.IWebManagerDao;
import com.water.tools.constant.admin.WebSettingConstant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 */
@Repository(IWebManagerDao.SERVICE_NAME)
public class WebManagerDaoImpl extends BaseDaoImpl implements IWebManagerDao {


    @Override
    public int saveWebSetting(String webDescription, String webKey, String webTitle) {

        String INSERT_SQL = " insert into b_web_manager (MANAGER_MODULE,WEB_DESCRIPTION,WEB_KEY,INDEX_TITLE) values (?,?,?,?)";
        return this.insertData(INSERT_SQL,new Object[]{WebSettingConstant.WEB_SETTING,webDescription,webKey,webTitle});
    }

    @Override
    public int deleteWebSettingByDdlCode() {

        String DELETE_SQL = "delete from b_web_manager where manager_module = ?";
        return this.deleteData(DELETE_SQL,new Object[]{WebSettingConstant.WEB_SETTING});
    }

    @Override
    public Map<String, Object> findWebSetting() {

        String SELECT_SQL = "select * from b_web_manager where manager_module=?";
        return this.queryForMap(SELECT_SQL,new Object[]{WebSettingConstant.WEB_SETTING});
    }

    @Override
    public List<Map<String, Object>> findCarouseImgs() {

        String SELECT_SQL = "SELECT bwm.*,img.imgurl as IMGURL FROM b_web_manager bwm,t_img img  " +
                "where manager_module = ? and img.imgid = bwm.picid order by sortorder asc";
        return this.queryForList(SELECT_SQL,WebSettingConstant.WEB_CAROUSEL);
    }

    @Override
    public int addCarouseImg(String urlAddr, int picId, int sortBy) {

        //获取图片保存到数据库的id主键
        String INSERT_SQL = "INSERT INTO b_web_manager (PICID, URL, SORTORDER, MANAGER_MODULE) VALUES (?,?,?,?)";
        return this.insertData(INSERT_SQL,new Object[]{picId,urlAddr,sortBy,WebSettingConstant.WEB_CAROUSEL});
    }

    @Override
    public int updateCarouselImgById(String urlAddr, int picId, int sortBy, int carouselId) {

        String UPDATE_SQL = "UPDATE b_web_manager SET URL = ?,PICID = ?,SORTORDER=? WHERE ID = ?";
        Object[]params = new Object[]{urlAddr,picId,sortBy,carouselId};

        return this.updateData(UPDATE_SQL,params);
    }

    @Override
    public int deleteCarouselById(int carouselInt) {

        String DELETE_SQL = "delete from b_web_manager where manager_module = ? and id = ?";
        return this.deleteData(DELETE_SQL,new Object[]{WebSettingConstant.WEB_CAROUSEL,carouselInt});
    }

    @Override
    public List<Map<String, Object>> findLinks() {

        String SELECT_SQL = "select * from b_web_manager where manager_module = ?";
        return this.queryForList(SELECT_SQL,new Object[]{WebSettingConstant.WEB_LINKS});
    }

    @Override
    public int addLink(String linkName, String linkUrl, int sortBy) {

        String INSERT_SQL = "INSERT INTO b_web_manager (DESCRIPTION, URL, SORTORDER, MANAGER_MODULE) VALUES (?,?,?,?)";
        return this.insertData(INSERT_SQL,new Object[]{linkName,linkUrl,sortBy,WebSettingConstant.WEB_LINKS});
    }

    @Override
    public int updateLink(String linkName, String linkUrl, int sortBy, int itemID){
        String UPDATE_SQL = "UPDATE b_web_manager SET DESCRIPTION = ?, URL = ?, SORTORDER = ? where ID = ?;";
        return this.insertData(UPDATE_SQL,new Object[]{linkName,linkUrl,sortBy,itemID});
    }

    @Override
    public int deleteLinkById(int linkId) {

        String DELETE_SQL = "delete from b_web_manager where manager_module = ? and id = ?";
        return this.deleteData(DELETE_SQL,new Object[]{WebSettingConstant.WEB_LINKS,linkId});
    }

    @Override
    public int addPartnerInfo(String partnerName, String partnerLinkUrl, int picId, int partnerSortBy) {

        String INSERT_SQL = "INSERT INTO b_web_manager (DESCRIPTION, URL,PICID, SORTORDER, MANAGER_MODULE) VALUES (?,?,?,?,?)";
        return this.insertData(INSERT_SQL,new Object[]{partnerName,partnerLinkUrl,picId,partnerSortBy,WebSettingConstant.WEB_PARTNER});
    }

    @Override
    public List<Map<String, Object>> findPartner() {

        String SELECT_SQL = "SELECT bwm.*,img.imgurl as IMGURL FROM b_web_manager bwm,t_img img  " +
                "where manager_module = ? and img.imgid = bwm.picid order by sortorder asc";
        return this.queryForList(SELECT_SQL,new Object[]{WebSettingConstant.WEB_PARTNER});
    }

    @Override
    public int deletePartnerById(int partnerId) {

        String DELETE_SQL = "delete from b_web_manager where manager_module = ? and id = ?";
        return this.deleteData(DELETE_SQL,new Object[]{WebSettingConstant.WEB_PARTNER,partnerId});
    }
}
