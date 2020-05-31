package com.xinli.xinli.controller;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.service.MasterService;
import com.xinli.xinli.service.UserService;
import com.xinli.xinli.websocket.NewWebsocket;
import com.xinli.xinli.websocket.bean.Room;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Api(tags = "咨询师/督导师操作Api")
@RestController
public class MasterController {

    @Autowired
    MasterService masterService;

    @Autowired
    UserService userService;

    @ApiOperation("查看申请,输入")
    @GetMapping("/api/master/getApplication")
    public CommonResponse<List<TbApplicationEntity>> getApplication(Integer masterId){
        List<TbApplicationEntity> tbApplicationEntityList = null;
        try {
            tbApplicationEntityList = masterService.getApplication(masterId);
        }catch (Exception e){
            return new CommonResponse<List<TbApplicationEntity>>(500,"获取失败",tbApplicationEntityList);
        }
        return new CommonResponse<List<TbApplicationEntity>>(200,"获取成功",tbApplicationEntityList);
    }

    @ApiOperation("添加督导师 && 通过申请,修改状态值,在修改前需要先查出来 (0未阅读,1通过,2拒绝,3已完成,4中止,5延期)")
    @PostMapping("/api/master/updateApplication")
    public CommonResponse<TbApplicationEntity> updateApplication(@RequestBody TbApplicationEntity tbApplicationEntity){
        try {
            tbApplicationEntity = userService.commitRequest(tbApplicationEntity);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<TbApplicationEntity>(500,"审批失败",tbApplicationEntity);
        }
        return new CommonResponse<TbApplicationEntity>(200,"审批成功",tbApplicationEntity);
    }

    @ApiOperation("咨询师查看咨询的结果")
    @GetMapping("/api/master/getConsultationResults")
    public CommonResponse<List<TbAdvisoryEntity>> getConsultationResults(Integer masterId){
        List<TbAdvisoryEntity> tbAdvisoryEntityList = null;
        try {
            tbAdvisoryEntityList = masterService.getConsultationResults(masterId);
        }catch (Exception e){
            return new CommonResponse<List<TbAdvisoryEntity>>(500,"获取失败",tbAdvisoryEntityList);
        }
        return new CommonResponse<List<TbAdvisoryEntity>>(200,"获取成功",tbAdvisoryEntityList);
    }

    @ApiOperation("咨询师提交评价")
    @PostMapping("/api/master/commitEvaluation")
    public CommonResponse commitEvaluation(String evaluation,Integer adId){
        try {
            masterService.commitEvaluation(evaluation,adId);
        }catch (Exception e){
            return new CommonResponse(500,"提交评价失败",null);
        }
        return new CommonResponse(200,"提交评价成功",null);
    }

    @ApiOperation("咨询师提交记录")
    @PostMapping("/api/master/commitRecording")
    public CommonResponse commitRecording(String recording,Integer adId){
        try {
            masterService.commitRecording(recording,adId);
        }catch (Exception e){
            return new CommonResponse(500,"提交记录失败",null);
        }
        return new CommonResponse(200,"提交记录成功",null);
    }

    @ApiOperation("督导师查看咨询的结果")
    @GetMapping("/api/master/getSupervisionResults")
    public CommonResponse<List<TbAdvisoryEntity>> getSupervisionResults(Integer masterId){
        List<TbAdvisoryEntity> tbAdvisoryEntityList = null;
        try {
            tbAdvisoryEntityList = masterService.getSupervisionResults(masterId);
        }catch (Exception e){
            return new CommonResponse<List<TbAdvisoryEntity>>(500,"获取失败",tbAdvisoryEntityList);
        }
        return new CommonResponse<List<TbAdvisoryEntity>>(200,"获取成功",tbAdvisoryEntityList);
    }


    @ApiOperation("提交图片 url")
    @PostMapping("/api/master/commitUrl")
    public CommonResponse commitUrl(Integer appId,String url1,String url2){
        try {
            TbAdvisoryEntity tbAdvisoryEntity = masterService.getAdvisoryByAppId(appId);
            tbAdvisoryEntity.setAdImgUrl1(url1);
            tbAdvisoryEntity.setAdImgUrl2(url2);
            masterService.addAdvisory(tbAdvisoryEntity);
            return new CommonResponse(200,"提交url成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"提交url失败",null);
        }
    }

    @ApiOperation("添加咨询记录")
    @PostMapping("/api/master/addOneAdvisory")
    public CommonResponse addOneAdvisory(@RequestBody TbAdvisoryEntity tbAdvisoryEntity){
        try {
              masterService. addOneAdvisory(tbAdvisoryEntity);
            return new CommonResponse(200,"提交成功",null);
        }catch (Exception e){
            return new CommonResponse(500,"提交失败",null);
        }
    }

    @ApiOperation("督导师查看自己可以进入的房间")
    @GetMapping("/api/master/getRoom")
    public CommonResponse<List<Room>> getRoom(Integer supervisorId){
        List<Room> room = NewWebsocket.hotel.findRoom(supervisorId);
        return new CommonResponse<List<Room>>(200,"获取成功",room);
    }

    //1. / 这个接口修改成可以对id进行模糊查找的
    //
    //2. /api/master/getConsultationResults 这个接口修改成可以对id进行模糊查找的

}













