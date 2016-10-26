package com.water.db.dao;

/**
 * Created by mrwater on 16/8/24.
 */
public interface IPhotoDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.dao.impl.PhotoDaoImpl";

    int saveImgUrl(String imgUrl);
}
