package com.xinli.xinli.controller;

import com.xinli.xinli.bean.TbAuthorityEntity;
import com.xinli.xinli.dao.TbAuthorityDao;
import com.xinli.xinli.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@Api(tags = "权限表操作API")
@RestController
public class AuthorityController {

    @Autowired
    TbAuthorityDao tbAuthorityDao;

    @ApiOperation("获取权限信息")
    @GetMapping("/api/authority/getAuthority")
    public CommonResponse<List<TbAuthorityEntity>> getAuthority(){

        List<TbAuthorityEntity> all = null;
        try {
            all = tbAuthorityDao.findAll();
            return new CommonResponse<List<TbAuthorityEntity>>(200,"获取成功",all);
        }catch (Exception e){
            return new CommonResponse<List<TbAuthorityEntity>>(200,"获取成功",all);
        }

    }

    @ApiOperation("修改权限信息")
    @GetMapping("/api/authority/updateAuthority")
    public CommonResponse<TbAuthorityEntity> getAuthority(TbAuthorityEntity tbAuthorityEntity){

        try {
            TbAuthorityEntity save = tbAuthorityDao.save(tbAuthorityEntity);
            return new CommonResponse<TbAuthorityEntity>(200,"修改成功",save);
        }catch (Exception e){
            return new CommonResponse<TbAuthorityEntity>(200,"修改失败",tbAuthorityEntity);
        }

    }
}
