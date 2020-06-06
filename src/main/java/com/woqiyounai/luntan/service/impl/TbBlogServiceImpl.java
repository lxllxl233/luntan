package com.woqiyounai.luntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woqiyounai.luntan.entity.TbBlog;
import com.woqiyounai.luntan.entity.TbBlogComment;
import com.woqiyounai.luntan.mapper.TbBlogCommentMapper;
import com.woqiyounai.luntan.mapper.TbBlogMapper;
import com.woqiyounai.luntan.request.BlogCommentRequest;
import com.woqiyounai.luntan.request.BlogReleaseRequest;
import com.woqiyounai.luntan.request.BlogUpdateRequest;
import com.woqiyounai.luntan.response.other.OneBlogCommentResponse;
import com.woqiyounai.luntan.service.TbBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbBlogServiceImpl implements TbBlogService {
    @Autowired
    TbBlogMapper tbBlogMapper;
    @Autowired
    TbBlogCommentMapper tbBlogCommentMapper;
    @Override
    public void writeBlog(BlogReleaseRequest blogReleaseRequest) {
        TbBlog tbBlog = new TbBlog(blogReleaseRequest);
        tbBlogMapper.insert(tbBlog);
    }

    @Override
    public void update(BlogUpdateRequest blogUpdateRequest) {
        TbBlog tbBlog = new TbBlog(blogUpdateRequest);
        tbBlogMapper.updateById(tbBlog);
    }

    @Override
    public List<TbBlog> findBlogByUserId(Integer userId) {
        QueryWrapper<TbBlog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq("user_id",userId);
        List<TbBlog> blogList = tbBlogMapper.selectList(blogQueryWrapper);
        return blogList;
    }

    @Override
    public List<TbBlog> findBlogByV2Id(Integer v2Id) {
        QueryWrapper<TbBlog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq("v2_id",v2Id);
        blogQueryWrapper.select("id","user_id","v2_id","title","create_time","update_time");
        List<TbBlog> blogList = tbBlogMapper.selectList(blogQueryWrapper);
        return blogList;
    }

    @Override
    public List<TbBlog> searchBlog(String searchName) {
        QueryWrapper<TbBlog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.like("title",searchName);
        List<TbBlog> blogList = tbBlogMapper.selectList(blogQueryWrapper);
        return blogList;
    }

    @Override
    public void releaseComment(BlogCommentRequest blogCommentRequest) {
        TbBlogComment tbBlogComment = new TbBlogComment(blogCommentRequest);
        tbBlogCommentMapper.insert(tbBlogComment);
    }

    @Override
    public OneBlogCommentResponse findCommentByBlogId(Integer blogId) {
        QueryWrapper<TbBlogComment> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.like("blog_id",blogId);
        List<TbBlogComment> blogList = tbBlogCommentMapper.selectList(blogQueryWrapper);
        if (null != blogList){
            List<TbBlogComment> tbBlogCommentList = new ArrayList<>();
            Map<Integer,List<TbBlogComment>> blogCommentMap = new HashMap<>();
            blogList.forEach(e->{
                if (e.getpId().equals(0)){
                    tbBlogCommentList.add(e);
                }else {
                    if (blogCommentMap.containsKey(e.getbUserId())){
                        List<TbBlogComment> blogComments = blogCommentMap.get(e.getbUserId());
                        blogComments.add(e);
                        blogCommentMap.put(e.getbUserId(),blogComments);
                    }else {
                        List<TbBlogComment> blogComments = new ArrayList<>();
                        blogComments.add(e);
                        blogCommentMap.put(e.getbUserId(),blogComments);
                    }
                }
            });
            OneBlogCommentResponse oneBlogCommentResponse = new OneBlogCommentResponse(tbBlogCommentList,blogCommentMap);
            return oneBlogCommentResponse;
        }
        return null;
    }

    @Override
    public TbBlog getBlogById(Integer blogId) {
        return tbBlogMapper.selectById(blogId);
    }
}
