package com.woqiyounai.luntan.controller;

import com.woqiyounai.luntan.entity.TbBlog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(tags = "用户操作 api")
public class TbUserController {

    @PostMapping("/hello")
    public TbBlog hello(@RequestBody TbBlog tbBlog){
        return tbBlog;
    }
}
