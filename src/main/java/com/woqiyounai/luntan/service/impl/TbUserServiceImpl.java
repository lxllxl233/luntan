package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.mapper.TbUserMapper;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import com.woqiyounai.luntan.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    public TbUser getById(int i) {
        return tbUserMapper.selectById(i);
    }

    @Override
    public void registeredUser(UserRegisteredRequest userRegisteredRequest) {
        TbUser tbUser = new TbUser(userRegisteredRequest);
        tbUserMapper.insert(tbUser);
    }

    @Override
    public TbUser userLogin(UserLoginRequest userLoginRequest) {
        userLoginRequest.setPassword(DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes()));
        QueryWrapper<TbUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_phone",userLoginRequest.getUserPhone()).eq("user_password",userLoginRequest.getPassword());
        TbUser tbUser = tbUserMapper.selectOne(userQueryWrapper);
        return tbUser;
    }

    @Override
    public TbUser findUserByUserPhone(String userPhone) {
        QueryWrapper<TbUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_phone",userPhone);
        TbUser tbUser = tbUserMapper.selectOne(userQueryWrapper);
        return tbUser;
    }

    @Override
    public void updateUserInfo(UserChangeInfoRequest userChangeInfoRequest) {
        TbUser tbUser = new TbUser(userChangeInfoRequest);
        tbUserMapper.updateById(tbUser);
    }

    @Override
    public void updateUserPassword(Integer userId, String password) {
        TbUser tbUser = new TbUser(userId,password);
        tbUserMapper.updateById(tbUser);
    }

}
