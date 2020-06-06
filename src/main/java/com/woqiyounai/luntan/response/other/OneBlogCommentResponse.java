package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbBlogComment;
import com.woqiyounai.luntan.response.other.info.OneBlogCommit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OneBlogCommentResponse implements Serializable {
    private List<OneBlogCommit> blogCommitList;
    public OneBlogCommentResponse() {
    }

    public OneBlogCommentResponse(List<OneBlogCommit> blogCommitList) {
        this.blogCommitList = blogCommitList;
    }

    public OneBlogCommentResponse(List<TbBlogComment> tbBlogCommentList, Map<Integer, List<TbBlogComment>> blogCommentMap) {
        blogCommitList = new ArrayList<>();
        tbBlogCommentList.forEach(e->{
            blogCommitList.add(new OneBlogCommit(e,blogCommentMap.get(e.getId())));
        });
    }

    public List<OneBlogCommit> getBlogCommitList() {
        return blogCommitList;
    }

    public void setBlogCommitList(List<OneBlogCommit> blogCommitList) {
        this.blogCommitList = blogCommitList;
    }
}
