package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class UserRegisteredRequest implements Serializable {
    private String userName;
    private String nickName;
    private String userPhone;
    private String userPassword;
    private String userIntroduce;
    public UserRegisteredRequest() {
    }

    public UserRegisteredRequest(String userName, String nickName, String userPhone, String userPassword, String userIntroduce) {
        this.userName = userName;
        this.nickName = nickName;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userIntroduce = userIntroduce;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    @Override
    public String toString() {
        return "UserRegisteredRequest{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIntroduce='" + userIntroduce + '\'' +
                '}';
    }
}
