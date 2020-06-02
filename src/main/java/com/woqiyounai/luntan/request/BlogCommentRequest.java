package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class BlogCommentRequest implements Serializable {
    private Integer pId;
    private Integer blogId;
    private Integer userId;
    private Integer bUserId;//被回复评论的id,需要pid=1
    private String text;
    public BlogCommentRequest() {
    }

    public BlogCommentRequest(Integer pId, Integer blogId, Integer userId, Integer bUserId, String text) {
        this.pId = pId;
        this.blogId = blogId;
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

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
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
