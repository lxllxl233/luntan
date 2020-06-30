package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.entity.TbForum;
import com.woqiyounai.luntan.request.LunTanCommentRequest;
import com.woqiyounai.luntan.request.LunTanReleaseRequest;
import com.woqiyounai.luntan.request.LunTanUpdateRequest;
import com.woqiyounai.luntan.response.CommonResponse;
import com.woqiyounai.luntan.response.other.OneForumCommentResponse;
import com.woqiyounai.luntan.response.other.info.OneForumCommit;
import com.woqiyounai.luntan.service.TbForumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "论坛操作 api")
public class TbForumController {

    @Autowired
    TbForumService tbForumService;
    //发布自己的论坛
    @ApiOperation("发布自己的论坛")
    @PostMapping("/api/forum/releaseLunTan")
    public CommonResponse<String> releaseLunTan(@RequestBody LunTanReleaseRequest lunTanReleaseRequest){
        try {
            tbForumService.releaseLunTan(lunTanReleaseRequest);
            return new CommonResponse<>(200,"发布论坛成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"发布论坛失败","fail");
        }
    }
    //修改自己的论坛
    @ApiOperation("修改自己的论坛")
    @PostMapping("/api/forum/updateLunTan")
    public CommonResponse<String> updateLunTan(@RequestBody LunTanUpdateRequest lunTanUpdateRequest){
        try {
            tbForumService.updateLunTan(lunTanUpdateRequest);
            return new CommonResponse<>(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"修改失败","fail");
        }
    }
    //根据用户id获取该用户的论坛
    @ApiOperation("根据id获取该用户的所有论坛")
    @GetMapping("/api/forum/getLunTanByUserId")
    public CommonResponse<List<TbForum>> getLunTanByUserId(Integer userId){
        List<TbForum> tbForumList = null;
        try {
            tbForumList = tbForumService.getLunTanByUserId(userId);
            return new CommonResponse<>(200,"获取成功",tbForumList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumList);
        }
    }
    //根据名称搜索论坛
    @ApiOperation("根据名称模糊搜索论坛")
    @GetMapping("/api/forum/searchLunTan")
    public CommonResponse<List<TbForum>> searchLunTan(String searchName){
        List<TbForum> tbForumList = null;
        try {
            tbForumList = tbForumService.searchLunTan(searchName);
            return new CommonResponse<>(200,"获取成功",tbForumList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumList);
        }
    }
    //根据二级id获取论坛
    @ApiOperation("根据二级id获取论坛")
    @GetMapping("/api/forum/getLunTanByV2Id")
    public CommonResponse<List<TbForum>> getLunTanByV2Id(Integer v2Id){
        List<TbForum> tbForumList = null;
        try {
            tbForumList = tbForumService.getLunTanByV2Id(v2Id);
            return new CommonResponse<>(200,"获取成功",tbForumList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumList);
        }
    }
    //发布论坛下的评论
    @ApiOperation("发布论坛下的评论")
    @PostMapping("/api/forum/postComment")
    public CommonResponse<String> postComment(@RequestBody LunTanCommentRequest lunTanCommentRequest){
        try {
            tbForumService.postComment(lunTanCommentRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //获取论坛评论,根据论坛 id
    @ApiOperation("获取论坛下的评论")
    @GetMapping("/api/forum/getComment")
    public CommonResponse<List<OneForumCommit>> getComment(Integer forumId){
        OneForumCommentResponse oneForumCommentResponse = null;
        try {
            oneForumCommentResponse = tbForumService.getComment(forumId);
            return new CommonResponse<>(200,"获取成功",oneForumCommentResponse.getForumCommitList());
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

    //根据 id 获取论坛
    @ApiOperation("根据 id 获取论坛")
    @GetMapping("/api/forum/getLunTanById")
    public CommonResponse<TbForum> getLunTanById(Integer forumId){
        TbForum tbForum = null;
        try {
            tbForum = tbForumService.getLunTanById(forumId);
            return new CommonResponse<>(200,"获取成功",tbForum);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

}
