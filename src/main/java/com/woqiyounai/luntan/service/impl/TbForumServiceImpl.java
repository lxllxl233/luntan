package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.TbForum;
import com.woqiyounai.luntan.entity.TbForumCommit;
import com.woqiyounai.luntan.mapper.TbForumCommitMapper;
import com.woqiyounai.luntan.mapper.TbForumMapper;
import com.woqiyounai.luntan.request.LunTanCommentRequest;
import com.woqiyounai.luntan.request.LunTanReleaseRequest;
import com.woqiyounai.luntan.request.LunTanUpdateRequest;
import com.woqiyounai.luntan.response.other.OneForumCommentResponse;
import com.woqiyounai.luntan.service.TbForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbForumServiceImpl implements TbForumService {

    @Autowired
    TbForumMapper tbForumMapper;
    @Autowired
    TbForumCommitMapper tbForumCommitMapper;
    @Override
    public void releaseLunTan(LunTanReleaseRequest lunTanReleaseRequest) {
        TbForum tbForum = new TbForum(lunTanReleaseRequest);
        tbForumMapper.insert(tbForum);
    }

    @Override
    public void updateLunTan(LunTanUpdateRequest lunTanUpdateRequest) {
        TbForum tbForum = new TbForum(lunTanUpdateRequest);
        tbForumMapper.updateById(tbForum);
    }

    @Override
    public List<TbForum> getLunTanByUserId(Integer userId) {
        QueryWrapper<TbForum> tbForumQueryWrapper = new QueryWrapper<>();
        tbForumQueryWrapper.eq("user_id",userId);
        List<TbForum> tbForumList = tbForumMapper.selectList(tbForumQueryWrapper);
        return tbForumList;
    }

    @Override
    public List<TbForum> searchLunTan(String searchName) {
        QueryWrapper<TbForum> tbForumQueryWrapper = new QueryWrapper<>();
        tbForumQueryWrapper.like("title",searchName);
        List<TbForum> tbForumList = tbForumMapper.selectList(tbForumQueryWrapper);
        return tbForumList;
    }

    @Override
    public List<TbForum> getLunTanByV2Id(Integer v2Id) {
        QueryWrapper<TbForum> tbForumQueryWrapper = new QueryWrapper<>();
        tbForumQueryWrapper.select("id","user_id","v2_id","title","create_time","update_time");
        tbForumQueryWrapper.like("v2_id",v2Id);
        List<TbForum> tbForumList = tbForumMapper.selectList(tbForumQueryWrapper);
        return tbForumList;
    }

    @Override
    public void postComment(LunTanCommentRequest lunTanCommentRequest) {
        TbForumCommit tbForumCommit = new TbForumCommit(lunTanCommentRequest);
        tbForumCommitMapper.insert(tbForumCommit);
    }

    @Override
    public OneForumCommentResponse getComment(Integer forumId) {
        QueryWrapper<TbForumCommit> forumCommitQueryWrapper = new QueryWrapper<>();
        forumCommitQueryWrapper.like("forum_id",forumId);
        List<TbForumCommit> blogList = tbForumCommitMapper.selectList(forumCommitQueryWrapper);
        if (null != blogList){
            List<TbForumCommit> tbBlogCommentList = new ArrayList<>();
            Map<Integer,List<TbForumCommit>> blogCommentMap = new HashMap<>();
            blogList.forEach(e->{
                if (e.getpId().equals(0)){
                    tbBlogCommentList.add(e);
                }else {
                    if (blogCommentMap.containsKey(e.getbUserId())){
                        List<TbForumCommit> blogComments = blogCommentMap.get(e.getbUserId());
                        blogComments.add(e);
                        blogCommentMap.put(e.getbUserId(),blogComments);
                    }else {
                        List<TbForumCommit> blogComments = new ArrayList<>();
                        blogComments.add(e);
                        blogCommentMap.put(e.getbUserId(),blogComments);
                    }
                }
            });
            OneForumCommentResponse oneForumCommentResponse = new OneForumCommentResponse(tbBlogCommentList,blogCommentMap);
            return oneForumCommentResponse;
        }
        return null;
    }

    @Override
    public TbForum getLunTanById(Integer forumId) {
        return tbForumMapper.selectById(forumId);
    }
}
