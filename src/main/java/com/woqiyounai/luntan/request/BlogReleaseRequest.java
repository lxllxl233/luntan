package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class BlogReleaseRequest implements Serializable {
    private Integer userId;
    private Integer v2Id;
    private String title;
    private String text;
    public BlogReleaseRequest() {
    }

    public BlogReleaseRequest(Integer userId, Integer v2Id, String title, String text) {
        this.userId = userId;
        this.v2Id = v2Id;
        this.title = title;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getV2Id() {
        return v2Id;
    }

    public void setV2Id(Integer v2Id) {
        this.v2Id = v2Id;
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
