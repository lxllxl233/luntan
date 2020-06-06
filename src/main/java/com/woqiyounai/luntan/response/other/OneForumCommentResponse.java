package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbForumCommit;
import com.woqiyounai.luntan.response.other.info.OneForumCommit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OneForumCommentResponse implements Serializable {
    private List<OneForumCommit> forumCommitList;
    public OneForumCommentResponse() {
    }

    public OneForumCommentResponse(List<OneForumCommit> forumCommitList) {
        this.forumCommitList = forumCommitList;
    }

    public OneForumCommentResponse(List<TbForumCommit> tbBlogCommentList, Map<Integer, List<TbForumCommit>> blogCommentMap) {
        forumCommitList = new ArrayList<>();
        tbBlogCommentList.forEach(e->{
            forumCommitList.add(new OneForumCommit(e,blogCommentMap.get(e.getId())));
        });
    }

    public List<OneForumCommit> getForumCommitList() {
        return forumCommitList;
    }

    public void setForumCommitList(List<OneForumCommit> forumCommitList) {
        this.forumCommitList = forumCommitList;
    }
}
