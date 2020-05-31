package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbCatalogV1Entity;
import com.xinli.xinli.response.data.CataLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TbCatalogV1Dao extends JpaRepository<TbCatalogV1Entity,Integer> {
    @Modifying
    @Transactional
    @Query("update TbCatalogV1Entity tcve set tcve.v1Name=?1 where tcve.v1Id=?2")
    void updateV1Name(String v1Name,Integer v1Id);

    @Transactional
    void deleteByV1Id(Integer v1Id);
}
