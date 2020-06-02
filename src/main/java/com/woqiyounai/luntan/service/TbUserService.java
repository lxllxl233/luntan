package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;

public interface TbUserService {
    TbUser getById(int i);
    void registeredUser(UserRegisteredRequest userRegisteredRequest);

    TbUser userLogin(UserLoginRequest userLoginRequest);

    TbUser findUserByUserPhone(String userPhone);

    void updateUserInfo(UserChangeInfoRequest userChangeInfoRequest);

    void updateUserPassword(Integer userId, String password);
}
