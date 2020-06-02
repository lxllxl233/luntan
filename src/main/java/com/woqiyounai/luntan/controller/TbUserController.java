package com.woqiyounai.luntan.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserLoginRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import com.woqiyounai.luntan.response.CommonResponse;
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
    public CommonResponse userRegistered(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
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
                return new CommonResponse(200, "用户登录成功", token);
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
    @PostMapping("/api/user/lookUserInfo")
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
    public CommonResponse userChangePassword(Integer userId,String password){
        try {
            tbUserService.updateUserPassword(userId,password);
            return new CommonResponse(200,"修改成功",null);
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
}

















