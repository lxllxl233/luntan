package com.xinli.xinli.service;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;

public interface InfoService {
    TbMasterEntity getMasterById(Integer id);

    TbAdvisoryEntity getAdvisoryById(Integer id);

    TbUserEntity getUserById(Integer id);

    TbApplicationEntity getApplicationById(Integer id);
}
