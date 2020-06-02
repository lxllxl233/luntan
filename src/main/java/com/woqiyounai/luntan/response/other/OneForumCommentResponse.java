package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbForumCommit;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OneForumCommentResponse implements Serializable {
    private List<TbForumCommit> p1List;
    private Map<Integer, List<TbForumCommit>> p2Map;
    public OneForumCommentResponse() {
    }

    public OneForumCommentResponse(List<TbForumCommit> p1List, Map<Integer, List<TbForumCommit>> p2Map) {
        this.p1List = p1List;
        this.p2Map = p2Map;
    }

    public List<TbForumCommit> getP1List() {
        return p1List;
    }

    public void setP1List(List<TbForumCommit> p1List) {
        this.p1List = p1List;
    }

    public Map<Integer, List<TbForumCommit>> getP2Map() {
        return p2Map;
    }

    public void setP2Map(Map<Integer, List<TbForumCommit>> p2Map) {
        this.p2Map = p2Map;
    }
}
