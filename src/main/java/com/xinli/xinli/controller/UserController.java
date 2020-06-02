package com.xinli.xinli.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbApplicationAll;
import com.xinli.xinli.bean.other.TbApplicationResult;
import com.xinli.xinli.dao.TbUserDao;
import com.xinli.xinli.request.MasterLoginRequest;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.service.UserService;
import com.xinli.xinli.util.TimeUtil;
import com.xinli.xinli.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mx.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Api(tags = "学员操作Api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TbUserDao tbUserDao;

    @ApiOperation("删除学员")
    @PostMapping("/api/user/deleteAccount")
    public CommonResponse<TbUserEntity> deleteAccount(String userPhone){
        TbUserEntity byUserPhone = null;
        try {
            byUserPhone = tbUserDao.findByUserPhone(userPhone);
            tbUserDao.deleteByUserPhone(userPhone);
            return new CommonResponse<TbUserEntity>(200,"删除成功",byUserPhone);
        }catch (Exception e){
            return new CommonResponse<TbUserEntity>(500,"删除失败",byUserPhone);
        }
    }

    @ApiOperation("学员注册")
    @PostMapping("/api/user/addAccount")
    public CommonResponse<TbUserEntity> addAccount(@RequestBody TbUserEntity tbUserEntity){
        try {
            String userPhone = tbUserEntity.getUserPhone();
            TbUserEntity byUserPhone = tbUserDao.findByUserPhone(userPhone);
            if (null == byUserPhone) {
                //保存 md5 到数据库
                tbUserEntity.setUserPassword(DigestUtils.md5DigestAsHex(tbUserEntity.getUserPassword().getBytes()));
                tbUserEntity = userService.addAccount(tbUserEntity);
            }else {
                return new CommonResponse<TbUserEntity>(500,"该手机号已被使用",tbUserEntity);
            }
        }catch (Exception e){
            return new CommonResponse<TbUserEntity>(500,"注册失败",tbUserEntity);
        }
        return new CommonResponse<TbUserEntity>(200,"注册成功",tbUserEntity);
    }

    @ApiOperation("学员修改个人信息,需要传入已经存在的个人id")
    @PostMapping("/api/user/updateAccount")
    public CommonResponse<TbUserEntity> updateAccount(@RequestBody TbUserEntity tbUserEntity){
        if (null != tbUserEntity.getUserPassword()){
            tbUserEntity.setUserPassword(DigestUtils.md5DigestAsHex(tbUserEntity.getUserPassword().getBytes()));
        }
        try {
            tbUserEntity = userService.addAccount(tbUserEntity);
        }catch (Exception e){
            return new CommonResponse<TbUserEntity>(500,"修改失败",tbUserEntity);
        }
        return new CommonResponse<TbUserEntity>(200,"修改成功",tbUserEntity);
    }

    @ApiOperation("学员登录")
    @PostMapping("/api/user/login")
    public CommonResponse<TbUserEntity> login(@RequestBody MasterLoginRequest loginRequest, HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
            if (StringUtils.isBlank(ip)) {
                ip = "127.0.0.1";
            }
        }
        //转换 md5
        loginRequest.setPassword(DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes()));
        TbUserEntity tbUserEntity = null;
        try {
             tbUserEntity = userService.findAccount(loginRequest);
        }catch (Exception e){
            return new CommonResponse(500,"登录失败",tbUserEntity);
        }
        if (null == tbUserEntity){
            return new CommonResponse<TbUserEntity>(200, "用户名或密码错误", tbUserEntity);
        }else {
            if (TimeUtil.getTime().getTime() > tbUserEntity.getUserDeadline().getTime()){
                return new CommonResponse<TbUserEntity>(500, "该账号已经过期,请联系管理员", tbUserEntity);
            }
            Map<String,Object> map = new HashMap<>();
            map.put("username",loginRequest.getUserPhone());
            map.put("password",loginRequest.getPassword());
            String token = TokenUtil.encode(tbUserEntity.getUserId() + "", map, ip);
            return new CommonResponse<TbUserEntity>(200, "{\"token\":\""+token+"\"}", tbUserEntity);
        }
    }

    @ApiOperation("提交咨询申请")
    @PostMapping("/api/user/commitRequest")
    public CommonResponse<TbApplicationEntity> commitRequest(@RequestBody TbApplicationEntity tbApplicationEntity){
        try {
            tbApplicationEntity = userService.commitRequest(tbApplicationEntity);
        }catch (Exception e){
            return new CommonResponse<TbApplicationEntity>(500,"提交失败",tbApplicationEntity);
        }
        return new CommonResponse<TbApplicationEntity>(200,"提交成功",tbApplicationEntity);
    }

    @ApiOperation("修改,延期咨询申请,id需要已经存在")
    @PostMapping("/api/user/updateRequest")
    public CommonResponse<TbApplicationEntity> updateRequest(@RequestBody TbApplicationEntity tbApplicationEntity){
        try {
            tbApplicationEntity = userService.commitRequest(tbApplicationEntity);
        }catch (Exception e){
            return new CommonResponse<TbApplicationEntity>(500,"修改失败",tbApplicationEntity);
        }
        return new CommonResponse<TbApplicationEntity>(200,"修改成功",tbApplicationEntity);
    }

    @ApiOperation("查看自己已经提交的申请")
    @GetMapping("/api/user/myRequest")
    public CommonResponse<List<TbApplicationEntity>> myRequest(Integer userId){
        List<TbApplicationEntity> tbApplicationEntityList = null;
        try {
            tbApplicationEntityList = userService.myRequest(userId);
        }catch (Exception e){
            return new CommonResponse<List<TbApplicationEntity>>(500,"获取失败",tbApplicationEntityList);
        }
        return new CommonResponse<List<TbApplicationEntity>>(200,"获取成功",tbApplicationEntityList);
    }

    @ApiOperation("查看自己已经提交的申请------(级联)")
    @GetMapping("/api/user/getMyRequest")
    public CommonResponse<List<TbApplicationAll>> getMyRequest(Integer userId){
        List<TbApplicationAll> tbApplicationEntityList = null;
        try {
            tbApplicationEntityList = userService.getMyRequest(userId);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<List<TbApplicationAll>>(500,"获取失败",tbApplicationEntityList);
        }
        return new CommonResponse<List<TbApplicationAll>>(200,"获取成功",tbApplicationEntityList);
    }

    @ApiOperation("获取自己的咨询结果(分页)")
    @GetMapping("/api/user/myResult")
    public CommonResponse<Page<TbAdvisoryEntity>> getMyResult(Integer userId,Integer currentPage,Integer size){
        Page<TbAdvisoryEntity> tbAdvisoryEntityPage = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("adTime"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbAdvisoryEntity tbAdvisoryEntity = new TbAdvisoryEntity();
            tbAdvisoryEntity.setUserId(userId);
            Example<TbAdvisoryEntity> example = Example.of(tbAdvisoryEntity);
            tbAdvisoryEntityPage = userService.myResult(example,pageable);
        }catch (Exception e){
            return new CommonResponse<Page<TbAdvisoryEntity>>(500,"获取失败",tbAdvisoryEntityPage);
        }
        return new CommonResponse<Page<TbAdvisoryEntity>>(200,"获取成功",tbAdvisoryEntityPage);
    }

    @ApiOperation("获取自己的咨询结果(不分页,对结果集进行过滤)")
    @GetMapping("/api/user/myResultNoPage")
    public CommonResponse<List<TbAdvisoryEntity>> myResultNoPage(Integer userId){
        List<TbAdvisoryEntity> tbAdvisoryEntityList = null;
        try {
            tbAdvisoryEntityList = userService.getAllAdvisory(userId);
            return new CommonResponse<List<TbAdvisoryEntity>>(200,"获取成功",tbAdvisoryEntityList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<List<TbAdvisoryEntity>>(500,"获取失败",tbAdvisoryEntityList);
        }
    }


    @ApiOperation("获取自己的咨询结果(分页)------------(级联)")
    @GetMapping("/api/user/getMyResult")
    public CommonResponse<Page<TbApplicationResult>> myResult(Integer userId, Integer currentPage, Integer size){
        Page<TbApplicationResult> tbAdvisoryEntityPage = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("adTime"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbApplicationResult tbAdvisoryEntity = new TbApplicationResult();
            tbAdvisoryEntity.setUserId(userId);
            Example<TbApplicationResult> example = Example.of(tbAdvisoryEntity);
            tbAdvisoryEntityPage = userService.getMyResult(example,pageable);
        }catch (Exception e){
            return new CommonResponse<Page<TbApplicationResult>>(500,"获取失败",tbAdvisoryEntityPage);
        }
        return new CommonResponse<Page<TbApplicationResult>>(200,"获取成功",tbAdvisoryEntityPage);
    }

    @ApiOperation("学员提交评价")
    @PostMapping("/api/user/commitEvaluation")
    public CommonResponse commitEvaluation(String evaluation,Integer adId){
        try {
            userService.commitEvaluation(evaluation,adId);
        }catch (Exception e){
            return new CommonResponse(500,"提交评价失败",null);
        }
        return new CommonResponse(200,"提交评价成功",null);
    }

    @ApiOperation("上传文件")
    @PostMapping("/api/upload/uploadFile")
    public CommonResponse<String> uploadFile(@RequestParam("file") MultipartFile file,String fileName){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "";
        String accessKeySecret = "";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = null;
        try {
            putObjectRequest = new PutObjectRequest("", "/"+fileName,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);
        // 上传文件。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        System.out.println(putObjectResult.getETag());
        ossClient.shutdown();
        String result = ""+fileName;
        return new CommonResponse<>(200,"上传成功",result);
    }

}
