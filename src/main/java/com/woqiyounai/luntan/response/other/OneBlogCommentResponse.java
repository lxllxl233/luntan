package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbBlogComment;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OneBlogCommentResponse implements Serializable {
    private List<TbBlogComment> p1List;
    private Map<Integer, List<TbBlogComment>> p2Map;
    public OneBlogCommentResponse() {
    }

    public OneBlogCommentResponse(List<TbBlogComment> p1List, Map<Integer, List<TbBlogComment>> p2Map) {
        this.p1List = p1List;
        this.p2Map = p2Map;
    }

    public List<TbBlogComment> getP1List() {
        return p1List;
    }

    public void setP1List(List<TbBlogComment> p1List) {
        this.p1List = p1List;
    }

    public Map<Integer, List<TbBlogComment>> getP2Map() {
        return p2Map;
    }

    public void setP2Map(Map<Integer, List<TbBlogComment>> p2Map) {
        this.p2Map = p2Map;
    }
}
