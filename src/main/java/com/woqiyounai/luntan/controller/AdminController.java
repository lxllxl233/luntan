package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.service.TbAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(tags = "后台管理 api")
public class AdminController {

    @Autowired
    TbAdminService tbAdminService;
}
