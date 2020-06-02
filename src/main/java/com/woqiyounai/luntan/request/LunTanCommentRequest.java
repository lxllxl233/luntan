package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class LunTanCommentRequest implements Serializable {
    private Integer pId;
    private Integer forumId;
    private Integer userId;
    private Integer bUserId;//被回复评论的id,需要pid=1
    private String text;
    public LunTanCommentRequest() {
    }

    public LunTanCommentRequest(Integer pId, Integer forumId, Integer userId, Integer bUserId, String text) {
        this.pId = pId;
        this.forumId = forumId;
        this.userId = userId;
        this.bUserId = bUserId;
        this.text = text;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getbUserId() {
        return bUserId;
    }

    public void setbUserId(Integer bUserId) {
        this.bUserId = bUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
