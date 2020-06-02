package com.xinli.xinli.controller;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbAllAdvisory;
import com.xinli.xinli.dao.TbMasterDao;
import com.xinli.xinli.request.MasterLoginRequest;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.service.AdminService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Api(tags = "管理员操作Api")
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    TbMasterDao tbMasterDao;

    @ApiOperation("添加(管理员0/督导师1/咨询师2)账号")
    @PostMapping("/api/admin/addAccount")
    public CommonResponse<TbMasterEntity> addAccount(@RequestBody TbMasterEntity tbMasterEntity){
        try {
            String masterPhone = tbMasterEntity.getMasterPhone();
            TbMasterEntity byMasterPhone = tbMasterDao.findByMasterPhone(masterPhone);
            if (null == byMasterPhone){
                //对密码加 md5
                tbMasterEntity.setMasterPassword(DigestUtils.md5DigestAsHex(tbMasterEntity.getMasterPassword().getBytes()));
                tbMasterEntity = adminService.addAccount(tbMasterEntity);
            }else {
                return new CommonResponse(600,"该手机号已经注册,请尝试其他手机号",tbMasterEntity);
            }
        }catch (Exception e){
            return new CommonResponse(500,"添加失败",tbMasterEntity);
        }
        return new CommonResponse<TbMasterEntity>(200,"添加成功",tbMasterEntity);
    }

    @ApiOperation("修改(管理员0/督导师1/咨询师2)账号资料,需要传入已经存在的id")
    @PostMapping("/api/admin/updateAccount")
    public CommonResponse<TbMasterEntity> updateAccount(@RequestBody TbMasterEntity tbMasterEntity){
        if (null != tbMasterEntity.getMasterPassword()){
            tbMasterEntity.setMasterPassword(DigestUtils.md5DigestAsHex(tbMasterEntity.getMasterPassword().getBytes()));
        }
        try {
            tbMasterEntity = adminService.addAccount(tbMasterEntity);
        }catch (Exception e){
            return new CommonResponse(500,"修改失败",tbMasterEntity);
        }
        return new CommonResponse<TbMasterEntity>(200,"修改成功",tbMasterEntity);
    }

    @ApiOperation("删除(管理员0/督导师1/咨询师2)账号,需要传入已经存在的id")
    @PostMapping("/api/admin/deleteAccount")
    public CommonResponse<TbMasterEntity> deleteAccount(@RequestBody TbMasterEntity tbMasterEntity){
        try {
            adminService.deleteAccount(tbMasterEntity);
        }catch (Exception e){
            return new CommonResponse(500,"删除失败",tbMasterEntity);
        }
        return new CommonResponse<TbMasterEntity>(200,"删除成功",tbMasterEntity);
    }

    @GetMapping("/api/admin/getAllAccount")
    @ApiOperation("不分页 获取所有(管理员0/督导师1/咨询师2)账号资料")
    public CommonResponse<List<TbMasterEntity>> getAllAccount(Integer authority){
        List<TbMasterEntity> tbMasterEntityList = null;
        try {
             //tbMasterEntityList = adminService.getAllAccount();
             tbMasterEntityList = adminService.getAllAccountByAuthority(authority);
        }catch (Exception e){
            return new CommonResponse(500,"获取失败",tbMasterEntityList);
        }
        return new CommonResponse<List<TbMasterEntity>>(200,"获取成功",tbMasterEntityList);
    }

    @GetMapping("/api/admin/getAllAccountByPage")
    @ApiOperation("分页 获取所有(管理员0/督导师1/咨询师2)账号资料")
    public CommonResponse<Page<TbMasterEntity>> getAllAccountPage(Integer authority,Integer currentPage,Integer size){
        Page<TbMasterEntity> allByGroupIdUsePage = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("masterDeadline"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbMasterEntity tbMasterEntity = new TbMasterEntity();
            tbMasterEntity.setMasterAuthority(authority);
            Example<TbMasterEntity> example = Example.of(tbMasterEntity);
            allByGroupIdUsePage = adminService.findAllByExample(example,pageable);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500,"获取失败",allByGroupIdUsePage);
        }
        return new CommonResponse<Page<TbMasterEntity>>(200,"获取成功",allByGroupIdUsePage);
    }

    @ApiOperation("管理员/督导师/咨询师登录")
    @PostMapping("/api/admin/login")
    public CommonResponse<TbMasterEntity> login(@RequestBody MasterLoginRequest loginRequest, HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip)) {
            ip = request.getRemoteAddr();
            if (StringUtils.isBlank(ip)) {
                ip = "127.0.0.1";
            }
        }
        TbMasterEntity tbMasterEntity = null;
        try {
            //转化md5比对
            loginRequest.setPassword(DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes()));
            tbMasterEntity = adminService.findAccount(loginRequest);
        }catch (Exception e){
            return new CommonResponse(500,"登录失败",tbMasterEntity);
        }
        if (null == tbMasterEntity){
            return new CommonResponse<TbMasterEntity>(200, "用户名或密码错误", tbMasterEntity);
        }else {
            if (tbMasterEntity.getMasterAuthority()!=0 && TimeUtil.getTime().getTime() > tbMasterEntity.getMasterDeadline().getTime()){
                return new CommonResponse<TbMasterEntity>(500, "该账号已过期,请联系管理员", tbMasterEntity);
            }
            Map<String,Object> map = new HashMap<>();
            map.put("username",loginRequest.getUserPhone());
            map.put("password",loginRequest.getPassword());
            String token = TokenUtil.encode(tbMasterEntity.getMasterId() + "", map, ip);
            return new CommonResponse<TbMasterEntity>(200, "{\"token\":\""+token+"\"}", tbMasterEntity);
        }
    }

    @ApiOperation("获取所有学员的账号信息")
    @GetMapping("/api/admin/getAllUser")
    public CommonResponse<List<TbUserEntity>> getAllUser(){
        List<TbUserEntity> tbUserEntityList = null;
        try {
            tbUserEntityList = userService.getAllUser();
            tbUserEntityList.forEach(
                    e->e.setUserPassword("********")
            );
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<List<TbUserEntity>>(500,"获取失败",tbUserEntityList);
        }
        return new CommonResponse<List<TbUserEntity>>(200,"获取成功",tbUserEntityList);
    }

    @ApiOperation("获取所有学员的账号信息(分页)")
    @GetMapping("/api/admin/getAllUserByPage")
    public CommonResponse<Page<TbUserEntity>> getAllUserByPage(Integer currentPage,Integer size){
        Page<TbUserEntity> allByGroupIdUsePage = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("userDeadline"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbUserEntity tbUserEntity = new TbUserEntity();
            Example<TbUserEntity> example = Example.of(tbUserEntity);
            allByGroupIdUsePage = adminService.findAllUser(example,pageable);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<Page<TbUserEntity>>(500,"获取失败",allByGroupIdUsePage);
        }
        return new CommonResponse<Page<TbUserEntity>>(200,"获取成功",allByGroupIdUsePage);
    }

    @ApiOperation("获取所有咨询记录")
    @GetMapping("/api/admin/getAllAdvisory")
    public CommonResponse<List<TbAdvisoryEntity>> getAllAdvisory(){
        List<TbAdvisoryEntity> tbAdvisoryEntityList = null;
        try {
            tbAdvisoryEntityList = adminService.getAllAdvisory();
        }catch (Exception e){
            return new CommonResponse<>(500,"获取失败",tbAdvisoryEntityList);
        }
        return new CommonResponse<>(200,"获取成功",tbAdvisoryEntityList);
    }

    @ApiOperation("获取所有咨询记录 (分页)")
    @GetMapping("/api/admin/getAllAdvisoryByPage")
    public CommonResponse<Page<TbAdvisoryEntity>> getAllAdvisoryByPage(Integer currentPage,Integer size){
        Page<TbAdvisoryEntity> allAdvisoryByPage = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("adId"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbAdvisoryEntity tbAdvisoryEntity = new TbAdvisoryEntity();
            Example<TbAdvisoryEntity> example = Example.of(tbAdvisoryEntity);
            allAdvisoryByPage = adminService.getAllAdvisoryByPage(example, pageable);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",allAdvisoryByPage);
        }
        return new CommonResponse<>(200,"获取成功",allAdvisoryByPage);
    }

    @ApiOperation("/获取所有咨询结果,具有连表查询所有数据,没有分页")
    @GetMapping("/api/admin/getAllAdvisoryHasJoin")
    public CommonResponse<List<TbAllAdvisory>> getAllAdvisoryHasJoin(){
        List<TbAllAdvisory> tbAllAdvisoryList = null;
        try {
            tbAllAdvisoryList = adminService.findAllAdvisory();
            return new CommonResponse<>(200,"获取成功",tbAllAdvisoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbAllAdvisoryList);
        }
    }

    @ApiOperation("/获取所有咨询结果,具有连表查询所有数据,有分页,级联")
    @GetMapping("/api/admin/getAllAdvisoryHasJoinAndPage")
    public CommonResponse<Page<TbAllAdvisory>> getAllAdvisoryHasJoinAndPage(Integer currentPage,Integer size){
        Page<TbAllAdvisory> tbAllAdvisoryList = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("adTime"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbAllAdvisory tbAdvisoryEntity = new TbAllAdvisory();
            Example<TbAllAdvisory> example = Example.of(tbAdvisoryEntity);
            tbAllAdvisoryList = adminService.findAllAdvisoryByPage(example, pageable);
            return new CommonResponse<>(200,"获取成功",tbAllAdvisoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbAllAdvisoryList);
        }
    }

    @ApiOperation("/获取 咨询师0/督导师1/学员2 所有咨询结果,具有连表查询所有数据,有分页,级联")
    @GetMapping("/api/admin/getAllResultsHasJoinAndPage")
    public CommonResponse<Page<TbAllAdvisory>> getAllAdvisoryHasJoinAndPage(Integer currentPage,Integer size,Integer identity,Integer id){
        Page<TbAllAdvisory> tbAllAdvisoryList = null;
        try {
            Sort sort = Sort.by(Sort.Order.desc("adTime"));
            Pageable pageable = PageRequest.of(currentPage-1, size, sort);
            TbAllAdvisory tbAdvisoryEntity = new TbAllAdvisory();

            if (identity.equals(0)){
                tbAdvisoryEntity.setMasterConsultantId(id);
            }
            if (identity.equals(1)){
                tbAdvisoryEntity.setMasterSupervisorId(id);
            }
            if (identity.equals(2)){
                tbAdvisoryEntity.setUserId(id);
            }

            Example<TbAllAdvisory> example = Example.of(tbAdvisoryEntity);
            tbAllAdvisoryList = adminService.findAllAdvisoryByPage(example, pageable);
            return new CommonResponse<>(200,"获取成功",tbAllAdvisoryList);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse<>(500,"获取失败",tbAllAdvisoryList);
        }
    }
}







