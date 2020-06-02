package com.woqiyounai.luntan.service;

import com.woqiyounai.luntan.entity.TbBlog;
import com.woqiyounai.luntan.request.BlogCommentRequest;
import com.woqiyounai.luntan.request.BlogReleaseRequest;
import com.woqiyounai.luntan.request.BlogUpdateRequest;
import com.woqiyounai.luntan.response.other.OneBlogCommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TbBlogService {
    void writeBlog(BlogReleaseRequest blogReleaseRequest);

    void update(BlogUpdateRequest blogUpdateRequest);

    List<TbBlog> findBlogByUserId(Integer userId);

    List<TbBlog> findBlogByV2Id(Integer v2Id);

    List<TbBlog> searchBlog(String searchName);

    void releaseComment(BlogCommentRequest blogCommentRequest);

    OneBlogCommentResponse findCommentByBlogId(Integer blogId);
}
