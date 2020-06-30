package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.TbForum;
import com.woqiyounai.luntan.request.LunTanCommentRequest;
import com.woqiyounai.luntan.request.LunTanReleaseRequest;
import com.woqiyounai.luntan.request.LunTanUpdateRequest;
import com.woqiyounai.luntan.response.other.OneForumCommentResponse;

import java.util.List;

public interface TbForumService {
    void releaseLunTan(LunTanReleaseRequest lunTanReleaseRequest);

    void updateLunTan(LunTanUpdateRequest lunTanUpdateRequest);

    List<TbForum> getLunTanByUserId(Integer userId);

    List<TbForum> searchLunTan(String searchName);

    List<TbForum> getLunTanByV2Id(Integer v2Id);

    void postComment(LunTanCommentRequest lunTanCommentRequest);

    OneForumCommentResponse getComment(Integer forumId);

    TbForum getLunTanById(Integer forumId);
}
