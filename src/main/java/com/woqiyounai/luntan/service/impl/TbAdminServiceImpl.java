package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.*;
import com.woqiyounai.luntan.mapper.*;
import com.woqiyounai.luntan.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class TbAdminServiceImpl implements TbAdminService {
    @Autowired
    TbForumCatalogV1Mapper tbForumCatalogV1Mapper;
    @Autowired
    TbForumCatalogV2Mapper tbForumCatalogV2Mapper;
    @Autowired
    TbBlogCatalogV1Mapper tbBlogCatalogV1Mapper;
    @Autowired
    TbBlogCatalogV2Mapper tbBlogCatalogV2Mapper;
    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    TbBlogMapper tbBlogMapper;
    @Autowired
    TbForumMapper tbForumMapper;
    @Override
    public List<TbForumCatalogV1> getForumCatalogV1() {
        return tbForumCatalogV1Mapper.selectList(null);
    }

    @Override
    public List<TbForumCatalogV2> getForumCatalogV2(Integer v1Id) {
        QueryWrapper<TbForumCatalogV2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v1_id",v1Id);
        List<TbForumCatalogV2> tbForumCatalogV2s = tbForumCatalogV2Mapper.selectList(queryWrapper);
        return tbForumCatalogV2s;
    }

    @Override
    public List<TbBlogCatalogV1> getBlogCatalogV1() {
        return tbBlogCatalogV1Mapper.selectList(null);
    }

    @Override
    public List<TbBlogCatalogV2> getBlogCatalogV2(Integer v1Id) {
        QueryWrapper<TbBlogCatalogV2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v1_id",v1Id);
        List<TbBlogCatalogV2> tbBlogCatalogV2s = tbBlogCatalogV2Mapper.selectList(queryWrapper);
        return tbBlogCatalogV2s;
    }

    @Override
    public void addBlogCatalogV1(String name) {
        TbBlogCatalogV1 tbBlogCatalogV1 = new TbBlogCatalogV1(name);
        tbBlogCatalogV1Mapper.insert(tbBlogCatalogV1);
    }

    @Override
    public void addForumCatalogV1(String name) {
        TbForumCatalogV1 tbForumCatalogV1 = new TbForumCatalogV1(name);
        tbForumCatalogV1Mapper.insert(tbForumCatalogV1);
    }

    @Override
    public void updateBlogCatalogV1(Integer id, String name) {
        TbBlogCatalogV1 tbBlogCatalogV1 = new TbBlogCatalogV1(id,name);
        tbBlogCatalogV1Mapper.updateById(tbBlogCatalogV1);
    }

    @Override
    public void updateForumCatalogV1(Integer id, String name) {
        TbForumCatalogV1 tbForumCatalogV1 = new TbForumCatalogV1(id,name);
        tbForumCatalogV1Mapper.updateById(tbForumCatalogV1);
    }

    @Override
    public void updateBlogCatalogV2(Integer id, String name) {
        TbBlogCatalogV2 tbBlogCatalogV2 = new TbBlogCatalogV2(id,name);
        tbBlogCatalogV2Mapper.updateById(tbBlogCatalogV2);
    }

    @Override
    public void updateForumCatalogV2(Integer id, String name) {
        TbForumCatalogV2 tbForumCatalogV2 = new TbForumCatalogV2(id,name);
        tbForumCatalogV2Mapper.updateById(tbForumCatalogV2);
    }

    @Override
    public void deleteBlogCatalogV1(Integer id) {
        tbBlogCatalogV1Mapper.deleteById(id);
        QueryWrapper<TbBlogCatalogV2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v1_id",id);
        tbBlogCatalogV2Mapper.delete(queryWrapper);
    }

    @Override
    public void deleteForumCatalogV1(Integer id) {
        tbForumCatalogV1Mapper.deleteById(id);
        QueryWrapper<TbForumCatalogV2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("v1_id",id);
        tbForumCatalogV2Mapper.delete(queryWrapper);
    }

    @Override
    public void deleteBlogCatalogV2(Integer id) {
        tbBlogCatalogV2Mapper.deleteById(id);
    }

    @Override
    public void deleteForumCatalogV2(Integer id) {
        tbForumCatalogV2Mapper.deleteById(id);
    }

    @Override
    public List<TbUser> getAllUser() {
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.eq("identity",1);
        return tbUserMapper.selectList(wrapper);
    }

    @Override
    public List<TbUser> getAllAdmin() {
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.eq("identity",0);
        return tbUserMapper.selectList(wrapper);
    }

    @Override
    public List<TbBlog> getAllBlog() {
        QueryWrapper<TbBlog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.select("id","user_id","v2_id","title","create_time","update_time");
        List<TbBlog> blogList = tbBlogMapper.selectList(blogQueryWrapper);
        return blogList;
    }

    @Override
    public List<TbForum> getAllForum() {
        QueryWrapper<TbForum> tbForumQueryWrapper = new QueryWrapper<>();
        tbForumQueryWrapper.select("id","user_id","v2_id","title","create_time","update_time");
        List<TbForum> tbForumList = tbForumMapper.selectList(tbForumQueryWrapper);
        return tbForumList;
    }

    @Override
    public void deleteUser(Integer userId) {
        tbUserMapper.deleteById(userId);
    }

    @Override
    public void initUserPassword(Integer userId) {
        TbUser tbUser = tbUserMapper.selectById(userId);
        tbUser.setUserPassword(DigestUtils.md5DigestAsHex(
                "666666".getBytes()
        ));
        tbUserMapper.updateById(tbUser);
    }

    @Override
    public void addBlogCatalogV2(String name, Integer v1Id) {
        TbBlogCatalogV2 tbBlogCatalogV2 = new TbBlogCatalogV2(name, v1Id);
        tbBlogCatalogV2Mapper.insert(tbBlogCatalogV2);
    }

    @Override
    public void addForumCatalogV2(String name, Integer v1Id) {
        TbForumCatalogV2 tbForumCatalogV2 = new TbForumCatalogV2(name,v1Id);
        tbForumCatalogV2Mapper.insert(tbForumCatalogV2);
    }

    @Override
    public void deleteForum(Integer forunId) {
        tbForumMapper.deleteById(forunId);
    }

    @Override
    public void deleteBlog(Integer blogId) {
        tbBlogMapper.deleteById(blogId);
    }
}
