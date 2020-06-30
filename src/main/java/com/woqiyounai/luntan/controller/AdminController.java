package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.entity.*;
import com.woqiyounai.luntan.response.CommonResponse;
import com.woqiyounai.luntan.service.TbAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "后台管理 api")
public class AdminController {

    @Autowired
    TbAdminService tbAdminService;

    //获取一级分类
    @ApiOperation("获取论坛一级分类")
    @PostMapping("/api/admin/getForumCatalogV1")
    public CommonResponse<List<TbForumCatalogV1>> getForumCatalogV1(){
        List<TbForumCatalogV1> tbForumCatalogV1List = null;
        try {
            tbForumCatalogV1List = tbAdminService.getForumCatalogV1();
            return new CommonResponse<>(200,"获取成功",tbForumCatalogV1List);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumCatalogV1List);
        }
    }
    @ApiOperation("获取博客一级分类")
    @PostMapping("/api/admin/getBlogCatalogV1")
    public CommonResponse<List<TbBlogCatalogV1>> getBlogCatalogV1(){
        List<TbBlogCatalogV1> tbBlogCatalogV1List = null;
        try {
            tbBlogCatalogV1List = tbAdminService.getBlogCatalogV1();
            return new CommonResponse<>(200,"获取成功",tbBlogCatalogV1List);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbBlogCatalogV1List);
        }
    }
    //根据一级分类获取二级分类
    @ApiOperation("获取论坛二级分类")
    @PostMapping("/api/admin/getForumCatalogV2")
    public CommonResponse<List<TbForumCatalogV2>> getForumCatalogV2(Integer v1Id){
        List<TbForumCatalogV2> tbForumCatalogV2List = null;
        try {
            tbForumCatalogV2List = tbAdminService.getForumCatalogV2(v1Id);
            return new CommonResponse<>(200,"获取成功",tbForumCatalogV2List);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumCatalogV2List);
        }
    }
    @ApiOperation("获取博客二级分类")
    @PostMapping("/api/admin/getBlogCatalogV2")
    public CommonResponse<List<TbBlogCatalogV2>> getBlogCatalogV2(Integer v1Id){
        List<TbBlogCatalogV2> tbBlogCatalogV2List = null;
        try {
            tbBlogCatalogV2List = tbAdminService.getBlogCatalogV2(v1Id);
            return new CommonResponse<>(200,"获取成功",tbBlogCatalogV2List);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbBlogCatalogV2List);
        }
    }
    //增加一级分类
    @ApiOperation("增加博客一级分类")
    @GetMapping("/api/admin/addBlogCatalogV1")
    public CommonResponse<String> addBlogCatalogV1(String name){
        try {
            tbAdminService.addBlogCatalogV1(name);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }

    @ApiOperation("增加论坛一级分类")
    @GetMapping("/api/admin/addForumCatalogV1")
    public CommonResponse<String> addForumCatalogV1(String name){
        try {
            tbAdminService.addForumCatalogV1(name);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }
    //增加二级分类
    @ApiOperation("增加博客二级分类")
    @GetMapping("/api/admin/addBlogCatalogV2")
    public CommonResponse<String> addBlogCatalogV2(String name,Integer v1Id){
        try {
            tbAdminService.addBlogCatalogV2(name,v1Id);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }

    @ApiOperation("增加论坛二级分类")
    @GetMapping("/api/admin/addForumCatalogV2")
    public CommonResponse<String> addForumCatalogV2(String name,Integer v1Id){
        try {
            tbAdminService.addForumCatalogV2(name,v1Id);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }
    //修改一级分类名称
    @ApiOperation("修改博客一级分类名称")
    @PostMapping("/api/admin/updateBlogCatalogV1")
    public CommonResponse<String> updateBlogCatalogV1(Integer id,String name){
        try {
            tbAdminService.updateBlogCatalogV1(id,name);
            return new CommonResponse<>(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"修改失败","fail");
        }
    }
    @ApiOperation("修改论坛一级分类名称")
    @PostMapping("/api/admin/updateForumCatalogV1")
    public CommonResponse<String> updateForumCatalogV1(Integer id,String name){
        try {
            tbAdminService.updateForumCatalogV1(id,name);
            return new CommonResponse<>(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"修改失败","fail");
        }
    }
    //修改二级分类名称
    @ApiOperation("修改博客二级分类名称")
    @PostMapping("/api/admin/updateBlogCatalogV2")
    public CommonResponse<String> updateBlogCatalogV2(Integer id,String name){
        try {
            tbAdminService.updateBlogCatalogV2(id,name);
            return new CommonResponse<>(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"修改失败","fail");
        }
    }
    @ApiOperation("修改论坛二级分类名称")
    @PostMapping("/api/admin/updateForumCatalogV2")
    public CommonResponse<String> updateForumCatalogV2(Integer id,String name){
        try {
            tbAdminService.updateForumCatalogV2(id,name);
            return new CommonResponse<>(200,"修改成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"修改失败","fail");
        }
    }
    //删除一级分类,连带删除二级分类
    @ApiOperation("删除博客一级分类,连带删除博客二级分类")
    @GetMapping("/api/admin/deleteBlogCatalogV1")
    public CommonResponse<String> deleteBlogCatalogV1(Integer id){
        try {
            tbAdminService.deleteBlogCatalogV1(id);
            return new CommonResponse<>(200,"删除成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"删除失败","fail");
        }
    }

    @ApiOperation("删除论坛一级分类,连带删除博客二级分类")
    @GetMapping("/api/admin/deleteForumCatalogV1")
    public CommonResponse<String> deleteForumCatalogV1(Integer id){
        try {
            tbAdminService.deleteForumCatalogV1(id);
            return new CommonResponse<>(200,"删除成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"删除失败","fail");
        }
    }

    @ApiOperation("删除博客二级分类")
    @GetMapping("/api/admin/deleteBlogCatalogV2")
    public CommonResponse<String> deleteBlogCatalogV2(Integer id){
        try {
            tbAdminService.deleteBlogCatalogV2(id);
            return new CommonResponse<>(200,"删除成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"删除失败","fail");
        }
    }

    @ApiOperation("删除论坛二级分类")
    @GetMapping("/api/admin/deleteForumCatalogV2")
    public CommonResponse<String> deleteForumCatalogV2(Integer id){
        try {
            tbAdminService.deleteForumCatalogV2(id);
            return new CommonResponse<>(200,"删除成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"删除失败","fail");
        }
    }

    //获取所有管理员
    @ApiOperation("获取所有管理员")
    @PostMapping("/api/admin/getAllAdmin")
    public CommonResponse<List<TbUser>> getAllUserAdmin(){
        List<TbUser> tbUserList = null;
        try {
            tbUserList = tbAdminService.getAllAdmin();
            return new CommonResponse<>(200,"获取成功",tbUserList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbUserList);
        }
    }
    //获取所有普通用户
    @ApiOperation("获取所有普通用户")
    @PostMapping("/api/admin/getAllUser")
    public CommonResponse<List<TbUser>> getAllUser(){
        List<TbUser> tbUserList = null;
        try {
            tbUserList = tbAdminService.getAllUser();
            return new CommonResponse<>(200,"获取成功",tbUserList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbUserList);
        }
    }
    //获取所有博客内容预览
    @ApiOperation("获取所有博客内容预览")
    @PostMapping("/api/admin/getAllBlog")
    public CommonResponse<List<TbBlog>> getAllBlog(){
        List<TbBlog> blogList = null;
        try {
            blogList = tbAdminService.getAllBlog();
            return new CommonResponse(200,"获取成功",blogList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"获取成功",blogList);
        }
    }
    //获取所有论坛内容预览
    @ApiOperation("获取所有博客内容预览")
    @PostMapping("/api/admin/getAllForum")
    public CommonResponse<List<TbForum>> getAllForum(){
        List<TbForum> tbForumList = null;
        try {
            tbForumList = tbAdminService.getAllForum();
            return new CommonResponse<>(200,"获取成功",tbForumList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbForumList);
        }
    }

    //根据 id 删除用户
    @ApiOperation("根据 id 删除用户")
    @GetMapping("/api/admin/deleteUser")
    public CommonResponse<String> deleteUser(Integer userId){
        try {
            tbAdminService.deleteUser(userId);
            return new CommonResponse(200,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"修改失败",null);
        }
    }
    //根据 id 重置密码
    @ApiOperation("根据 id 重置密码")
    @GetMapping("/api/admin/initUserPassword")
    public CommonResponse<String> initUserPassword(Integer userId){
        try {
            tbAdminService.initUserPassword(userId);
            return new CommonResponse(200,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"修改失败",null);
        }
    }
    //删除论坛
    @ApiOperation("根据 id 删除论坛")
    @GetMapping("/api/admin/deleteForum")
    public CommonResponse<String> deleteForum(Integer forumId){
        try {
            tbAdminService.deleteForum(forumId);
            return new CommonResponse(200,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"删除失败",null);
        }
    }
    //删除博客
    @ApiOperation("根据 id 删除博客")
    @GetMapping("/api/admin/deleteBlog")
    public CommonResponse<String> deleteBlog(Integer blogId){
        try {
            tbAdminService.deleteBlog(blogId);
            return new CommonResponse(200,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"删除失败",null);
        }
    }
}
