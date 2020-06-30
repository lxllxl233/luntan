package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbBlog;
import com.woqiyounai.luntan.entity.TbForum;
import com.woqiyounai.luntan.entity.TbUser;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {
    private List<TbUser> tbUsers;
    private List<TbBlog> tbBlogs;
    private List<TbForum> tbForums;
    public SearchResponse() {
    }

    public SearchResponse(List<TbUser> tbUsers, List<TbBlog> tbBlogs, List<TbForum> tbForums) {
        this.tbUsers = tbUsers;
        this.tbBlogs = tbBlogs;
        this.tbForums = tbForums;
    }

    public List<TbUser> getTbUsers() {
        return tbUsers;
    }

    public void setTbUsers(List<TbUser> tbUsers) {
        this.tbUsers = tbUsers;
    }

    public List<TbBlog> getTbBlogs() {
        return tbBlogs;
    }

    public void setTbBlogs(List<TbBlog> tbBlogs) {
        this.tbBlogs = tbBlogs;
    }

    public List<TbForum> getTbForums() {
        return tbForums;
    }

    public void setTbForums(List<TbForum> tbForums) {
        this.tbForums = tbForums;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "tbUsers=" + tbUsers +
                ", tbBlogs=" + tbBlogs +
                ", tbForums=" + tbForums +
                '}';
    }
}
