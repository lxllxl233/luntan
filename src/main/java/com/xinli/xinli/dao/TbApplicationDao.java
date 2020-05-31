package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbApplicationDao extends JpaRepository<TbApplicationEntity,Integer> {
    List<TbApplicationEntity> findAllByUserId(Integer userId);
    List<TbApplicationEntity> findAllByMasterConsultantId(Integer masterConsultantId);
    TbApplicationEntity findByAppId(Integer id);
}
