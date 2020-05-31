package com.xinli.xinli;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbCatalogV2Entity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.other.TbAllCatalog;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.dao.TbCatalogV1Dao;
import com.xinli.xinli.dao.TbMasterDao;
import com.xinli.xinli.dao.other.TbAllCatalogDao;
import com.xinli.xinli.response.data.CataLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XinliApplicationTests {

    @Autowired
    TbMasterDao tbMasterDao;

    @Autowired
    TbCatalogV1Dao tbCatalogV1Dao;

    @Autowired
    TbAllCatalogDao tbAllCatalogDao;

    @Autowired
    TbAdvisoryDao tbAdvisoryDao;

    @Test
    void contextLoads() {
        TbAdvisoryEntity byAdId = tbAdvisoryDao.findByAdId(49);
        System.out.println(byAdId);
    }

}
