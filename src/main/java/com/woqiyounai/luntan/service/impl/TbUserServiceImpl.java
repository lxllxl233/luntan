package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.*;
import com.woqiyounai.luntan.mapper.*;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import com.woqiyounai.luntan.response.other.OneBlogCatalogResponse;
import com.woqiyounai.luntan.response.other.OneForumCatalogResponse;
import com.woqiyounai.luntan.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbBlogCatalogV1Mapper tbBlogCatalogV1Mapper;
    @Autowired
    TbBlogCatalogV2Mapper tbBlogCatalogV2Mapper;
    @Autowired
    TbForumCatalogV1Mapper tbForumCatalogV1Mapper;
    @Autowired
    TbForumCatalogV2Mapper tbForumCatalogV2Mapper;
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
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        TbUser tbUser = new TbUser(userId,password);
        tbUserMapper.updateById(tbUser);
    }

    @Override
    public OneBlogCatalogResponse getAllBlogCatalog() {
        List<TbBlogCatalogV1> tbBlogCatalogV1List = tbBlogCatalogV1Mapper.selectList(null);
        List<TbBlogCatalogV2> tbBlogCatalogV2List = tbBlogCatalogV2Mapper.selectList(null);
        Map<Integer,List<TbBlogCatalogV2>> map = new HashMap<>();
        tbBlogCatalogV2List.forEach(e->{
            if (map.containsKey(e.getV1Id())){
                List<TbBlogCatalogV2> tbBlogCatalogV2List1 = map.get(e.getV1Id());
                tbBlogCatalogV2List1.add(e);
                map.put(e.getV1Id(),tbBlogCatalogV2List1);
            }else {
                List<TbBlogCatalogV2> tbBlogCatalogV2List1 = new ArrayList<>();
                tbBlogCatalogV2List1.add(e);
                map.put(e.getV1Id(),tbBlogCatalogV2List1);
            }
        });
        OneBlogCatalogResponse oneBlogCatalogResponse = new OneBlogCatalogResponse(tbBlogCatalogV1List, map);
        return oneBlogCatalogResponse;
    }

    @Override
    public OneForumCatalogResponse getAllForumCatalog() {
        List<TbForumCatalogV1> tbForumCatalogV1List = tbForumCatalogV1Mapper.selectList(null);
        List<TbForumCatalogV2> tbForumCatalogV2List = tbForumCatalogV2Mapper.selectList(null);
        Map<Integer,List<TbForumCatalogV2>> map = new HashMap<>();
        tbForumCatalogV2List.forEach(e->{
            if (map.containsKey(e.getV1Id())){
                List<TbForumCatalogV2> tbForumCatalogV2List1 = map.get(e.getV1Id());
                tbForumCatalogV2List1.add(e);
                map.put(e.getV1Id(),tbForumCatalogV2List1);
            }else {
                List<TbForumCatalogV2> tbForumCatalogV2List1 = new ArrayList<>();
                tbForumCatalogV2List1.add(e);
                map.put(e.getV1Id(),tbForumCatalogV2List1);
            }
        });
        OneForumCatalogResponse oneForumCatalogResponse = new OneForumCatalogResponse(tbForumCatalogV1List, map);
        return oneForumCatalogResponse;
    }

    @Override
    public boolean selectUserByPassword(String getbPassword,Integer userId) {
        String password = DigestUtils.md5DigestAsHex(getbPassword.getBytes());
        TbUser tbUser = tbUserMapper.selectById(userId);
        if (null == tbUser){
            return false;
        }
        if (tbUser.getUserPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public TbUser findUserByUserId(Integer userId) {
        return tbUserMapper.selectById(userId);
    }

}
