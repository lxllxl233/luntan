package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TbModelDao extends JpaRepository<TbModelEntity,Integer> {
    List<TbModelEntity> findAllByV2Id(Integer v2Id);
    @Transactional
    void deleteByMdId(Integer mdId);

    TbModelEntity getByMdId(Integer modelId);
}
