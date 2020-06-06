package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class UserChangePasswordRequest implements Serializable {
    private Integer userId;
    private String bPassword;
    private String password;
    public UserChangePasswordRequest() {
    }

    public UserChangePasswordRequest(Integer userId, String bPassword, String password) {
        this.userId = userId;
        this.bPassword = bPassword;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getbPassword() {
        return bPassword;
    }

    public void setbPassword(String bPassword) {
        this.bPassword = bPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
