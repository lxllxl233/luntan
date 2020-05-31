package com.xinli.xinli.request;

public class MasterLoginRequest {
    private String userPhone;
    private String password;
    public MasterLoginRequest() {
    }

    public MasterLoginRequest(String userPhone, String password) {
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
}
