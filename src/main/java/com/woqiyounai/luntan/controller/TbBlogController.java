package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.entity.TbBlog;
import com.woqiyounai.luntan.request.BlogCommentRequest;
import com.woqiyounai.luntan.request.BlogReleaseRequest;
import com.woqiyounai.luntan.request.BlogUpdateRequest;
import com.woqiyounai.luntan.response.CommonResponse;
import com.woqiyounai.luntan.response.other.OneBlogCommentResponse;
import com.woqiyounai.luntan.service.TbBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "与博客操作有关的 api")
public class TbBlogController {

    @Autowired
    TbBlogService tbBlogService;

    //发布自己的博客
    @ApiOperation("发布自己的博客")
    @PostMapping("/api/blog/releaseBlog")
    public CommonResponse<String> releaseBlog(@RequestBody BlogReleaseRequest blogReleaseRequest){
        try {
            tbBlogService.writeBlog(blogReleaseRequest);
            return new CommonResponse(200,"发布成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"发布失败","fail");
        }
    }
    //修改自己的博客
    @ApiOperation("修改自己的博客")
    @PostMapping("/api/blog/updateBlog")
    public CommonResponse<String> updateBlog(@RequestBody BlogUpdateRequest blogUpdateRequest){
        try {
            tbBlogService.update(blogUpdateRequest);
            return new CommonResponse(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"修改失败","fail");
        }
    }
    //用户获取自己的博客
    @ApiOperation("根据用户id获取该用户所有的的博客")
    @PostMapping("/api/blog/getUserBlog")
    public CommonResponse<List<TbBlog>> getUserBlog(Integer userId){
        List<TbBlog> blogList = null;
        try {
            blogList = tbBlogService.findBlogByUserId(userId);
            return new CommonResponse(200,"获取成功",blogList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"获取成功",blogList);
        }
    }
    //根据二级分类获取博客
    @ApiOperation("根据二级分类获取博客")
    @PostMapping("/api/blog/getV2Blog")
    public CommonResponse<List<TbBlog>> getV2Blog(Integer v2Id){
        List<TbBlog> blogList = null;
        try {
            blogList = tbBlogService.findBlogByV2Id(v2Id);
            return new CommonResponse(200,"获取成功",blogList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"获取成功",blogList);
        }
    }
    //根据名称搜索博客
    @ApiOperation("根据博客名称模糊搜索博客")
    @PostMapping("/api/blog/searchBlog")
    public CommonResponse<List<TbBlog>> searchBlog(String searchName){
        List<TbBlog> blogList = null;
        try {
            blogList = tbBlogService.searchBlog(searchName);
            return new CommonResponse(200,"获取成功",blogList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"获取成功",blogList);
        }
    }
    //发布博客评论
    @ApiOperation("发布博客评论")
    @PostMapping("/api/blog/releaseComment")
    public CommonResponse<String> releaseComment(@RequestBody BlogCommentRequest blogCommentRequest){
        //顶级评论pid=0,下级评论pid=1
        try {
            tbBlogService.releaseComment(blogCommentRequest);
            return new CommonResponse(200,"发布成功",blogCommentRequest.getText());
        }catch (Exception e){
            return new CommonResponse(500,"发布失败",blogCommentRequest.getText());
        }
    }
    //根据博客id获取博客评论
    @ApiOperation("获取博客评论")
    @PostMapping("/api/blog/getComment")
    public CommonResponse<OneBlogCommentResponse> getComment(Integer blogId){
        OneBlogCommentResponse oneBlogCommentResponse = null;
        try {
            oneBlogCommentResponse = tbBlogService.findCommentByBlogId(blogId);
            return new CommonResponse<>(200,"获取成功",oneBlogCommentResponse);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

}
