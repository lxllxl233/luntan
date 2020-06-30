package com.woqiyounai.luntan.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserChangePasswordRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import com.woqiyounai.luntan.response.CommonResponse;
import com.woqiyounai.luntan.response.other.LoginResponse;
import com.woqiyounai.luntan.response.other.OneBlogCatalogResponse;
import com.woqiyounai.luntan.response.other.OneForumCatalogResponse;
import com.woqiyounai.luntan.response.other.SearchResponse;
import com.woqiyounai.luntan.response.other.info.OneBlogCatalog;
import com.woqiyounai.luntan.response.other.info.OneForumCatalog;
import com.woqiyounai.luntan.service.TbUserService;
import com.woqiyounai.luntan.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Api(tags = "用户操作 api")
public class TbUserController {

    @Autowired
    TbUserService tbUserService;

    @Autowired
    OSS ossClient;

    //用户注册
    @ApiOperation("用户注册")
    @PostMapping("/api/user/userRegistered")
    public CommonResponse userRegistered(@RequestBody UserRegisteredRequest userRegisteredRequest){
        try {
            tbUserService.registeredUser(userRegisteredRequest);
            userRegisteredRequest.setUserPassword("****");
            return new CommonResponse(200,"创建用户成功",userRegisteredRequest);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"该手机号已经注册过了,换个手机号试试?",null);
        }
    }

    //用户登录
    @ApiOperation("用户登录")
    @PostMapping("/api/user/userLogin")
    public CommonResponse<LoginResponse> userRegistered(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        TbUser tbUser = null;
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip)) {
            ip = request.getRemoteAddr();
            if (StringUtils.isEmpty(ip)) {
                ip = "127.0.0.1";
            }
        }
        try {
            tbUser = tbUserService.userLogin(userLoginRequest);
            if (null != tbUser) {
                Map<String, Object> map = new HashMap<>();
                map.put("username", userLoginRequest.getUserPhone());
                map.put("password", userLoginRequest.getPassword());
                String token = TokenUtil.encode(tbUser.getId() + "", map, ip);
                LoginResponse loginResponse = new LoginResponse(tbUser.getId(), token);
                return new CommonResponse(200, "登录成功", loginResponse);
            }else {
                return new CommonResponse(500,"用户名或密码错误",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"用户登录失败",null);
        }
    }
    //用户查看自己的信息
    @ApiOperation("用户查看自己的信息")
    @GetMapping("/api/user/lookUserInfo")
    public CommonResponse<TbUser> lookUserInfo(String userPhone){
        TbUser tbUser = null;
        try {
            tbUser = tbUserService.findUserByUserPhone(userPhone);
            if (null != tbUser){
                tbUser.setUserPassword("******");
                return new CommonResponse(200,"获取成功",tbUser);
            }else {
                return new CommonResponse(500,"未找到该用户信息",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"服务器出现了问题",null);
        }
    }
    //根据id查看用户的信息
    @ApiOperation("根据id查看用户的信息")
    @GetMapping("/api/user/lookUserInfoById")
    public CommonResponse<TbUser> lookUserInfo(Integer userId){
        TbUser tbUser = null;
        try {
            tbUser = tbUserService.findUserByUserId(userId);
            if (null != tbUser){
                tbUser.setUserPassword("******");
                return new CommonResponse(200,"获取成功",tbUser);
            }else {
                return new CommonResponse(500,"未找到该用户信息",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"服务器出现了问题",null);
        }
    }
    //用户修改自己的信息
    @ApiOperation("用户修改自己的信息")
    @PostMapping("/api/user/userChangeInfo")
    public CommonResponse userChangeInfo(@RequestBody UserChangeInfoRequest userChangeInfoRequest){
        try {
            tbUserService.updateUserInfo(userChangeInfoRequest);
            return new CommonResponse(200,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"修改失败",null);
        }
    }
    //用户修改密码
    @ApiOperation("用户修改密码")
    @PostMapping("/api/user/userChangePassword")
    public CommonResponse userChangePassword(@RequestBody UserChangePasswordRequest userChangePasswordRequest){
        try {
            boolean isRight = tbUserService.selectUserByPassword(userChangePasswordRequest.getbPassword(), userChangePasswordRequest.getUserId());
            if (isRight){
                tbUserService.updateUserPassword(userChangePasswordRequest.getUserId(),userChangePasswordRequest.getPassword());
                return new CommonResponse(200,"修改成功",null);
            }else {
                return new CommonResponse(300,"修改前密码错误",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"修改失败",null);
        }
    }

    //用户上传头像
    @ApiOperation("上传文件")
    @PostMapping("/api/upload/uploadFile")
    public CommonResponse<String> uploadFile(@RequestParam("file") MultipartFile file, String fileName){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        //https://woqiyounai.oss-cn-beijing.aliyuncs.com/test/background.jpg
        try {
            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest("woqiyounai", "test/"+fileName,file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
            String result = "https://woqiyounai.oss-cn-beijing.aliyuncs.com/test/"+fileName;
            return new CommonResponse<>(200,"上传成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(200,"上传失败",null);
        }
    }

    //获取博客所有分类
    @ApiOperation("获取博客所有分类")
    @GetMapping("/api/user/getAllBlogCatalog")
    public CommonResponse<List<OneBlogCatalog>> getAllBlogCatalog(){
        OneBlogCatalogResponse oneBlogCatalogResponse = null;
        try {
            oneBlogCatalogResponse = tbUserService.getAllBlogCatalog();
            return new CommonResponse<>(200,"获取成功",oneBlogCatalogResponse.getBlogCatalogList());
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",null);
        }
    }
    //获取论坛所有分类
    @ApiOperation("获取论坛所有分类")
    @GetMapping("/api/user/getAllForumCatalog")
    public CommonResponse<List<OneForumCatalog>> getAllForumCatalog(){
        OneForumCatalogResponse oneForumCatalogResponse = null;
        try {
            oneForumCatalogResponse = tbUserService.getAllForumCatalog();
            return new CommonResponse<>(200,"获取成功",oneForumCatalogResponse.getForumCatalogList());
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",null);
        }
    }

    //模糊搜索，与此关键词有关的人，论坛，博客
    @ApiOperation("模糊搜索与此关键词有关的人，博客，论坛")
    @GetMapping("/api/user/searchAll")
    public CommonResponse<SearchResponse> searchAll(String searchName){
        SearchResponse searchResponse = null;
        try {
            searchResponse = tbUserService.searchAll(searchName);
            return new CommonResponse<>(200,"搜索成功",searchResponse);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"搜索失败",null);
        }
    }
}
