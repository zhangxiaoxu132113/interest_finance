package com.water.db.dao.impl;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.water.db.dao.IPhotoDao;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by mrwater on 16/8/24.
 */
@Repository(IPhotoDao.SERVICE_NAME)
public class PhotoDaoImpl extends BankDaoImpl implements IPhotoDao {


    @Override
    public int saveImgUrl(final String imgUrl) {
        final String ADD_USER_SQL = "INSERT INTO t_img (IMGURL) VALUES (?)";
        int autoIncId = 0;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( new PreparedStatementCreator(){
                                 @Override
                                 public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                                     PreparedStatement ps = (PreparedStatement) conn.prepareStatement(ADD_USER_SQL, Statement.RETURN_GENERATED_KEYS);
                                     ps.setString(1, imgUrl);
                                     return ps;
                                 }
                             },
                keyHolder);

        autoIncId = keyHolder.getKey().intValue();
        return autoIncId;
    }
}
