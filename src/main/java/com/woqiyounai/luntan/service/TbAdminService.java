package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.TbBlogCatalogV1;
import com.woqiyounai.luntan.entity.TbBlogCatalogV2;
import com.woqiyounai.luntan.entity.TbForumCatalogV1;
import com.woqiyounai.luntan.entity.TbForumCatalogV2;

import java.util.List;

public interface TbAdminService {
    List<TbForumCatalogV1> getForumCatalogV1();
    List<TbForumCatalogV2> getForumCatalogV2(Integer v1Id);
    List<TbBlogCatalogV1> getBlogCatalogV1();
    List<TbBlogCatalogV2> getBlogCatalogV2(Integer v1Id);

    void addBlogCatalogV1(String name);

    void addForumCatalogV1(String name);

    void addBlogCatalogV2(String name);

    void addForumCatalogV2(String name);
}
