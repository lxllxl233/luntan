package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.*;

import java.util.List;

public interface TbAdminService {
    List<TbForumCatalogV1> getForumCatalogV1();
    List<TbForumCatalogV2> getForumCatalogV2(Integer v1Id);
    List<TbBlogCatalogV1> getBlogCatalogV1();
    List<TbBlogCatalogV2> getBlogCatalogV2(Integer v1Id);

    void addBlogCatalogV1(String name);

    void addForumCatalogV1(String name);
    
    void updateBlogCatalogV1(Integer id, String name);

    void updateForumCatalogV1(Integer id, String name);

    void updateBlogCatalogV2(Integer id, String name);

    void updateForumCatalogV2(Integer id, String name);

    void deleteBlogCatalogV1(Integer id);

    void deleteForumCatalogV1(Integer id);

    void deleteBlogCatalogV2(Integer id);

    void deleteForumCatalogV2(Integer id);

    List<TbUser> getAllUser();

    List<TbUser> getAllAdmin();

    List<TbBlog> getAllBlog();

    List<TbForum> getAllForum();

    void deleteUser(Integer userId);

    void initUserPassword(Integer userId);

    void addBlogCatalogV2(String name, Integer v1Id);

    void addForumCatalogV2(String name, Integer v1Id);

    void deleteForum(Integer forunId);

    void deleteBlog(Integer blogId);
}
