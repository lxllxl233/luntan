package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import com.woqiyounai.luntan.response.other.OneBlogCatalogResponse;
import com.woqiyounai.luntan.response.other.OneForumCatalogResponse;
import com.woqiyounai.luntan.response.other.SearchResponse;

public interface TbUserService {
    TbUser getById(int i);
    void registeredUser(UserRegisteredRequest userRegisteredRequest);

    TbUser userLogin(UserLoginRequest userLoginRequest);

    TbUser findUserByUserPhone(String userPhone);

    void updateUserInfo(UserChangeInfoRequest userChangeInfoRequest);

    void updateUserPassword(Integer userId, String password);

    OneBlogCatalogResponse getAllBlogCatalog();

    OneForumCatalogResponse getAllForumCatalog();


    boolean selectUserByPassword(String getbPassword, Integer userId);

    TbUser findUserByUserId(Integer userId);

    SearchResponse searchAll(String searchName);
}
