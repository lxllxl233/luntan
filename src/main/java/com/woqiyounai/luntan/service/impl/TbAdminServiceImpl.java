package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.TbBlogCatalogV1;
import com.woqiyounai.luntan.entity.TbBlogCatalogV2;
import com.woqiyounai.luntan.entity.TbForumCatalogV1;
import com.woqiyounai.luntan.entity.TbForumCatalogV2;
import com.woqiyounai.luntan.mapper.TbBlogCatalogV1Mapper;
import com.woqiyounai.luntan.mapper.TbBlogCatalogV2Mapper;
import com.woqiyounai.luntan.mapper.TbForumCatalogV1Mapper;
import com.woqiyounai.luntan.mapper.TbForumCatalogV2Mapper;
import com.woqiyounai.luntan.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addBlogCatalogV2(String name) {
       TbBlogCatalogV2 tbBlogCatalogV2 = new TbBlogCatalogV2(name);
       tbBlogCatalogV2Mapper.insert(tbBlogCatalogV2);
    }

    @Override
    public void addForumCatalogV2(String name) {
        TbForumCatalogV2 tbForumCatalogV2 = new TbForumCatalogV2(name);
        tbForumCatalogV2Mapper.insert(tbForumCatalogV2);
    }
}
