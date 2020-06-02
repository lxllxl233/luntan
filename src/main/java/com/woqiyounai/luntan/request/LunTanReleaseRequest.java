package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class LunTanReleaseRequest implements Serializable {
    private Integer v2Id;
    private Integer userId;
    private String title;
    private String text;
    public LunTanReleaseRequest() {
    }

    public LunTanReleaseRequest(Integer v2Id, Integer userId, String title, String text) {
        this.v2Id = v2Id;
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public Integer getV2Id() {
        return v2Id;
    }

    public void setV2Id(Integer v2Id) {
        this.v2Id = v2Id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
