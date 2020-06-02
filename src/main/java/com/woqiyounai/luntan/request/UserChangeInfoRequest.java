package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class UserChangeInfoRequest implements Serializable {
    private Integer id;
    private String userHeadimg;
    private String username;
    private String nickname;
    private String userIntroduction;
    public UserChangeInfoRequest() {
    }

    public UserChangeInfoRequest(Integer id, String userHeadimg, String username, String nickname, String userIntroduction) {
        this.id = id;
        this.userHeadimg = userHeadimg;
        this.username = username;
        this.nickname = nickname;
        this.userIntroduction = userIntroduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }
}
