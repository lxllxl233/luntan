package com.woqiyounai.luntan.response.other;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private Integer userId;
    private String token;
    public LoginResponse() {
    }

    public LoginResponse(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
