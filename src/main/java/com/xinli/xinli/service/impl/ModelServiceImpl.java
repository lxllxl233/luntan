package com.xinli.xinli.service.impl;

import com.xinli.xinli.bean.TbCatalogV1Entity;
import com.xinli.xinli.bean.TbCatalogV2Entity;
import com.xinli.xinli.bean.TbModelEntity;
import com.xinli.xinli.bean.other.TbAllCatalog;
import com.xinli.xinli.dao.TbCatalogV1Dao;
import com.xinli.xinli.dao.TbCatalogV2Dao;
import com.xinli.xinli.dao.TbModelDao;
import com.xinli.xinli.dao.other.TbAllCatalogDao;
import com.xinli.xinli.response.data.CataLog;
import com.xinli.xinli.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    TbCatalogV1Dao tbCatalogV1Dao;
    @Autowired
    TbCatalogV2Dao tbCatalogV2Dao;
    @Autowired
    TbModelDao tbModelDao;
    @Autowired
    TbAllCatalogDao tbAllCatalogDao;

    @Override
    public TbCatalogV1Entity addCatalogV1(TbCatalogV1Entity tbCatalogV1Entity) {
        TbCatalogV1Entity save = tbCatalogV1Dao.save(tbCatalogV1Entity);
        return save;
    }

    @Override
    public TbCatalogV2Entity addCatalogV2(TbCatalogV2Entity tbCatalogV2Entity) {
        TbCatalogV2Entity save = tbCatalogV2Dao.save(tbCatalogV2Entity);
        return save;
    }

    @Override
    public TbModelEntity addModel(TbModelEntity tbModelEntity) {
        TbModelEntity save = tbModelDao.save(tbModelEntity);
        return save;
    }

    @Override
    public List<TbCatalogV1Entity> getAllCatalogV1() {
        List<TbCatalogV1Entity> all = tbCatalogV1Dao.findAll();
        return all;
    }

    @Override
    public List<TbCatalogV2Entity> getAllV2ByV1(Integer v1Id) {
        List<TbCatalogV2Entity> byV1Id = tbCatalogV2Dao.findAllByV1Id(v1Id);
        return byV1Id;
    }

    @Override
    public List<TbModelEntity> getModel(Integer v2Id) {
        List<TbModelEntity> allByV2Id = tbModelDao.findAllByV2Id(v2Id);
        return allByV2Id;
    }

    @Override
    public void deleteCatalogV1(TbCatalogV1Entity tbCatalogV1Entity) {
        tbCatalogV1Dao.delete(tbCatalogV1Entity);
    }

    @Override
    public void deleteCatalogV2(TbCatalogV2Entity tbCatalogV2Entity) {
        tbCatalogV2Dao.delete(tbCatalogV2Entity);
    }

    @Override
    public void deleteModel(TbModelEntity tbModelEntity) {
        tbModelDao.delete(tbModelEntity);
    }

    @Override
    public List<TbAllCatalog> getAllCatalog() {
        return tbAllCatalogDao.findAll();
    }

    @Override
    public TbModelEntity getOneModel(Integer modelId) {
        return tbModelDao.getByMdId(modelId);
    }


}
