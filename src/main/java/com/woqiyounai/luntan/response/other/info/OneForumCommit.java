package com.woqiyounai.luntan.response.other.info;

import com.woqiyounai.luntan.entity.TbForumCommit;

import java.io.Serializable;
import java.util.List;

public class OneForumCommit implements Serializable {
    private TbForumCommit p1;
    private List<TbForumCommit> p2List;
    public OneForumCommit() {
    }

    public OneForumCommit(TbForumCommit p1, List<TbForumCommit> p2List) {
        this.p1 = p1;
        this.p2List = p2List;
    }

    public TbForumCommit getP1() {
        return p1;
    }

    public void setP1(TbForumCommit p1) {
        this.p1 = p1;
    }

    public List<TbForumCommit> getP2List() {
        return p2List;
    }

    public void setP2List(List<TbForumCommit> p2List) {
        this.p2List = p2List;
    }
}
