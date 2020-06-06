package com.woqiyounai.luntan;

import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class LuntanApplicationTests {

    @Autowired
    TbUserService tbUserService;
    @Test
    void contextLoads() {
        System.out.println(DigestUtils.md5DigestAsHex("string".getBytes()));
    }

}
