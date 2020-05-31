package com.xinli.xinli.service;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;

import java.util.List;

public interface MasterService {
    List<TbApplicationEntity> getApplication(Integer masterId);

    List<TbAdvisoryEntity> getConsultationResults(Integer masterId);

    List<TbAdvisoryEntity> getSupervisionResults(Integer masterId);

    void commitEvaluation(String evaluation, Integer adId);

    void commitRecording(String recording, Integer adId);

    void addAdvisory(TbAdvisoryEntity tbAdvisoryEntity);

    TbAdvisoryEntity getAdvisoryByAppId(Integer appId);

    void addOneAdvisory(TbAdvisoryEntity tbAdvisoryEntity);

    TbAdvisoryEntity getCurrentAdvisory(Integer appId);

}
