package com.woqiyounai.luntan.response.other.info;

import com.woqiyounai.luntan.entity.TbBlogComment;

import java.io.Serializable;
import java.util.List;

public class OneBlogCommit implements Serializable {
    private TbBlogComment p1;
    private List<TbBlogComment> p2List;
    public OneBlogCommit() {
    }

    public OneBlogCommit(TbBlogComment p1, List<TbBlogComment> p2List) {
        this.p1 = p1;
        this.p2List = p2List;
    }

    public TbBlogComment getP1() {
        return p1;
    }

    public void setP1(TbBlogComment p1) {
        this.p1 = p1;
    }

    public List<TbBlogComment> getP2List() {
        return p2List;
    }

    public void setP2List(List<TbBlogComment> p2List) {
        this.p2List = p2List;
    }
}
