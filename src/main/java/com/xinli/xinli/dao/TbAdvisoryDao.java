package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TbAdvisoryDao extends JpaRepository<TbAdvisoryEntity,Integer> , QueryByExampleExecutor<TbAdvisoryEntity> {
    //咨询师 查记录
    List<TbAdvisoryEntity> findAllByMasterConsultantId(Integer masterConsultantId);
    //督导师 查记录
    List<TbAdvisoryEntity> findAllByMasterSupervisorId(Integer masterSupervisorId);

    @Modifying
    @Transactional
    @Query("update TbAdvisoryEntity tae set tae.adConsultantEvaluation=?1 where tae.adId=?2")
    void commitEvaluation(String evaluation, Integer adId);
    @Modifying
    @Transactional
    @Query("update TbAdvisoryEntity tae set tae.adConsultantRecording=?1 where tae.adId=?2")
    void commitRecoding(String recoding, Integer adId);
    @Modifying
    @Transactional
    @Query("update TbAdvisoryEntity tae set tae.adUserEvaluation=?1 where tae.adId=?2")
    void commitUserEvaluation(String evaluation, Integer adId);

    TbAdvisoryEntity findByAdId(Integer id);

    TbAdvisoryEntity findByAppId(Integer appId);
    List<TbAdvisoryEntity> getByUserId(Integer userId);
}
