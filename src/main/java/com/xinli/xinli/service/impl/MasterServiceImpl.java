package com.xinli.xinli.service.impl;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.dao.TbApplicationDao;
import com.xinli.xinli.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    TbApplicationDao tbApplicationDao;
    @Autowired
    TbAdvisoryDao tbAdvisoryDao;

    @Override
    public List<TbApplicationEntity> getApplication(Integer masterId) {
        List<TbApplicationEntity> allByMasterConsultantId = tbApplicationDao.findAllByMasterConsultantId(masterId);
        return allByMasterConsultantId;
    }

    @Override
    public List<TbAdvisoryEntity> getConsultationResults(Integer masterId) {
        List<TbAdvisoryEntity> allByMasterConsultantId = tbAdvisoryDao.findAllByMasterConsultantId(masterId);
        return allByMasterConsultantId;
    }

    @Override
    public List<TbAdvisoryEntity> getSupervisionResults(Integer masterId) {
        List<TbAdvisoryEntity> allByMasterSupervisorId = tbAdvisoryDao.findAllByMasterSupervisorId(masterId);
        return allByMasterSupervisorId;
    }

    @Override
    public void commitEvaluation(String evaluation, Integer adId) {
        tbAdvisoryDao.commitEvaluation(evaluation,adId);
    }

    @Override
    public void commitRecording(String recording, Integer adId) {
        tbAdvisoryDao.commitRecoding(recording, adId);
    }

    @Override
    public void addAdvisory(TbAdvisoryEntity tbAdvisoryEntity) {
        tbAdvisoryDao.save(tbAdvisoryEntity);
    }

    @Override
    public TbAdvisoryEntity getAdvisoryByAppId(Integer appId) {
        return tbAdvisoryDao.findByAppId(appId);
    }

    @Override
    public void addOneAdvisory(TbAdvisoryEntity tbAdvisoryEntity) {
        tbAdvisoryDao.save(tbAdvisoryEntity);
    }

    @Override
    public TbAdvisoryEntity getCurrentAdvisory(Integer appId) {
        return tbAdvisoryDao.findByAppId(appId);
    }
}
