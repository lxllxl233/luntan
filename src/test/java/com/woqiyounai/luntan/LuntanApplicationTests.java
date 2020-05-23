package com.woqiyounai.luntan;

import com.woqiyounai.luntan.entity.TbUser;
import com.woqiyounai.luntan.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuntanApplicationTests {

    @Autowired
    TbUserService tbUserService;
    @Test
    void contextLoads() {
        TbUser byId = tbUserService.getById(1);
        System.out.println(byId);
    }

}
