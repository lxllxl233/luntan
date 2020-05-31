package com.xinli.xinli.controller;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.service.InfoService;
import com.xinli.xinli.service.MasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(tags = "根据 id 获取一些信息")
@RestController
public class InfoController {

    @Autowired
    InfoService infoService;

    @Autowired
    MasterService masterService;

    @ApiOperation("根据 id 获取咨询师/督导师信息")
    @GetMapping("/api/info/getMaster")
    public CommonResponse<TbMasterEntity> getAllMasterById(Integer id){
        TbMasterEntity tbMasterEntity = null;
        try {
            tbMasterEntity = infoService.getMasterById(id);
            return new CommonResponse<TbMasterEntity>(200,"获取成功",tbMasterEntity);
        }catch (Exception e){
            return new CommonResponse<TbMasterEntity>(500,"获取失败",tbMasterEntity);
        }
    }

    @ApiOperation("根据 id 获取咨询结果")
    @GetMapping("/api/info/getAdvisory")
    public CommonResponse<TbAdvisoryEntity> getAllAdvisoryById(Integer id){
        TbAdvisoryEntity tbAdvisoryEntity = null;
        try {
            tbAdvisoryEntity = infoService.getAdvisoryById(id);
            return new CommonResponse<TbAdvisoryEntity>(200,"获取成功",tbAdvisoryEntity);
        }catch (Exception e){
            return new CommonResponse<TbAdvisoryEntity>(200,"获取成功",tbAdvisoryEntity);
        }
    }

    @ApiOperation("根据 id 获取学员")
    @GetMapping("/api/info/getUser")
    public CommonResponse<TbUserEntity> getAllUser(Integer id){
        TbUserEntity tbUserEntity = null;
        try {
            tbUserEntity = infoService.getUserById(id);
            return new CommonResponse<TbUserEntity>(200,"获取成功",tbUserEntity);
        }catch (Exception e){
            return new CommonResponse<TbUserEntity>(200,"获取成功",tbUserEntity);
        }
    }

    @ApiOperation("根据 id 获取申请信息")
    @GetMapping("/api/info/getApplication")
    public CommonResponse<TbApplicationEntity> getAllApplication(Integer id){
        TbApplicationEntity tbApplicationEntity = null;
        try {
            tbApplicationEntity = infoService.getApplicationById(id);
            return new CommonResponse<TbApplicationEntity>(200,"获取成功",tbApplicationEntity);
        }catch (Exception e){
            return new CommonResponse<TbApplicationEntity>(200,"获取成功",tbApplicationEntity);
        }
    }

    @ApiOperation("获取咨询信息")
    @GetMapping("/api/master/getCurrentAdvisory")
    public CommonResponse<TbAdvisoryEntity> getCurrentAdvisory(Integer appId){
        TbAdvisoryEntity tbAdvisoryEntity = null;
        try {
            tbAdvisoryEntity = masterService.getCurrentAdvisory(appId);
        }catch (Exception e){
            return new CommonResponse<TbAdvisoryEntity>(500,"获取失败",tbAdvisoryEntity);
        }
        return new CommonResponse<TbAdvisoryEntity>(200,"获取成功",tbAdvisoryEntity);
    }
}
