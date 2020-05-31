package com.xinli.xinli.service.impl;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.dao.TbApplicationDao;
import com.xinli.xinli.dao.TbMasterDao;
import com.xinli.xinli.dao.TbUserDao;
import com.xinli.xinli.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    TbMasterDao tbMasterDao;
    @Autowired
    TbAdvisoryDao tbAdvisoryDao;
    @Autowired
    TbUserDao tbUserDao;
    @Autowired
    TbApplicationDao tbApplicationDao;
    @Override
    public TbMasterEntity getMasterById(Integer id) {
        return tbMasterDao.findByMasterId(id);
    }

    @Override
    public TbAdvisoryEntity getAdvisoryById(Integer id) {
        return tbAdvisoryDao.findByAdId(id);
    }

    @Override
    public TbUserEntity getUserById(Integer id) {
        return tbUserDao.findByUserId(id);
    }

    @Override
    public TbApplicationEntity getApplicationById(Integer id) {
        return tbApplicationDao.findByAppId(id);
    }
}
