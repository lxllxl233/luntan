package com.woqiyounai.luntan.service.impl;

import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.mapper.TbUserMapper;
import com.woqiyounai.luntan.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    public TbUser getById(int i) {
        return tbUserMapper.selectById(i);
    }
}
