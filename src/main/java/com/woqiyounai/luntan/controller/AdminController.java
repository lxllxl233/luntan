package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.entity.TbBlogCatalogV1;
import com.woqiyounai.luntan.entity.TbBlogCatalogV2;
import com.woqiyounai.luntan.entity.TbForumCatalogV1;
import com.woqiyounai.luntan.entity.TbForumCatalogV2;
import com.woqiyounai.luntan.response.CommonResponse;
import com.woqiyounai.luntan.service.TbAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @PostMapping("/api/admin/addBlogCatalogV1")
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
    @PostMapping("/api/admin/addForumCatalogV1")
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
    @PostMapping("/api/admin/addBlogCatalogV2")
    public CommonResponse<String> addBlogCatalogV2(String name){
        try {
            tbAdminService.addBlogCatalogV2(name);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }

    @ApiOperation("增加论坛二级分类")
    @PostMapping("/api/admin/addForumCatalogV2")
    public CommonResponse<String> addForumCatalogV2(String name){
        try {
            tbAdminService.addForumCatalogV2(name);
            return new CommonResponse<>(200,"添加成功","success");
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"添加失败1","fail");
        }
    }
    //修改一级分类名称
    //修改二级分类名称
    //删除一级分类,连带删除二级分类
    //删除二级分类
    //获取网站所有的用户信息
    //网站等级设置
}
