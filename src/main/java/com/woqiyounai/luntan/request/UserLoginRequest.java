package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {
    private String userPhone;
    private String password;
    public UserLoginRequest() {
    }

    public UserLoginRequest(String userPhone, String password) {
        this.userPhone = userPhone;
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
