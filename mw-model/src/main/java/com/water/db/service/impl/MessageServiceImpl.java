package com.water.db.service.impl;

import com.water.db.dao.IMessageDao;
import com.water.db.service.IMessageService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/16.
 */
@Service(IMessageService.SERVICE_NAME)
@Transactional(readOnly = true)
public class MessageServiceImpl implements IMessageService {

    @Resource(name = IMessageDao.SERVICE_NAME)
    private IMessageDao messageDao;

    @Override
    public Map<String, Object> findUserByTelPhone(String tel_phone) {

        MWStringUtils.isBlank(tel_phone);
        return messageDao.findUserByPhoneNum(tel_phone);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void saveVerificationCode(String tel_phone, String randomCode) {

        MWStringUtils.isBlank(tel_phone,randomCode);
        int autoIncId = messageDao.saveVerificationCode(tel_phone,randomCode);
    }

    @Override
    public boolean checkVericationCode(String tel_phone, String verification_code) {

        MWStringUtils.isBlank(tel_phone,verification_code);
        Map<String,Object> result =  messageDao.checkVericationCode(tel_phone,verification_code);

        if (result == null) return false;

        long diff_time = (Long) result.get("diff_time");
        if (diff_time<0) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteCodeData(String tel_phone) {

        messageDao.deleteCodeData(tel_phone);
    }

}
