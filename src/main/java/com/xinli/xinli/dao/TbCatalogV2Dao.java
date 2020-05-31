package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbCatalogV2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface TbCatalogV2Dao extends JpaRepository<TbCatalogV2Entity,Integer> {
    List<TbCatalogV2Entity> findAllByV1Id(Integer v1Id);
    @Modifying
    @Transactional
    @Query("update TbCatalogV2Entity tcve set tcve.v2Name=?1 where tcve.v2Id=?2")
    void updateV2Name(String v2Name,Integer v2Id);
    @Transactional
    void deleteByV2Id(Integer v2Id);
}
