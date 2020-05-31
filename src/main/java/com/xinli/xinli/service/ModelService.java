package com.xinli.xinli.service;

import com.xinli.xinli.bean.TbCatalogV1Entity;
import com.xinli.xinli.bean.TbCatalogV2Entity;
import com.xinli.xinli.bean.TbModelEntity;
import com.xinli.xinli.bean.other.TbAllCatalog;
import com.xinli.xinli.response.data.CataLog;

import java.util.List;

public interface ModelService {
    TbCatalogV1Entity addCatalogV1(TbCatalogV1Entity tbCatalogV1Entity);

    TbCatalogV2Entity addCatalogV2(TbCatalogV2Entity tbCatalogV2Entity);

    TbModelEntity addModel(TbModelEntity tbModelEntity);

    List<TbCatalogV1Entity> getAllCatalogV1();

    List<TbCatalogV2Entity> getAllV2ByV1(Integer v1Id);

    List<TbModelEntity> getModel(Integer v2Id);
    
    void deleteCatalogV1(TbCatalogV1Entity tbCatalogV1Entity);

    void deleteCatalogV2(TbCatalogV2Entity tbCatalogV2Entity);

    void deleteModel(TbModelEntity tbModelEntity);

    List<TbAllCatalog> getAllCatalog();

    TbModelEntity getOneModel(Integer modelId);
}
