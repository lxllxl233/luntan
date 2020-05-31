package com.xinli.xinli.service.impl;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbApplicationAll;
import com.xinli.xinli.bean.other.TbApplicationResult;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.dao.TbApplicationDao;
import com.xinli.xinli.dao.TbUserDao;
import com.xinli.xinli.dao.other.TbApplicationAllDao;
import com.xinli.xinli.dao.other.TbApplicationResultDao;
import com.xinli.xinli.request.MasterLoginRequest;
import com.xinli.xinli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TbUserDao tbUserDao;
    @Autowired
    TbApplicationDao tbApplicationDao;
    @Autowired
    TbAdvisoryDao tbAdvisoryDao;

    @Autowired
    TbApplicationAllDao tbApplicationAllDao;
    @Autowired
    TbApplicationResultDao tbApplicationResultDao;

    @Override
    public TbUserEntity addAccount(TbUserEntity tbUserEntity) {
        TbUserEntity save = tbUserDao.save(tbUserEntity);
        return save;
    }

    @Override
    public TbUserEntity findAccount(MasterLoginRequest loginRequest) {
        TbUserEntity byUserNameAndUserPassword = tbUserDao.findByUserPhoneAndUserPassword(loginRequest.getUserPhone(), loginRequest.getPassword());
        return byUserNameAndUserPassword;
    }

    @Override
    public List<TbUserEntity> getAllUser() {
        List<TbUserEntity> all = tbUserDao.findAll();
        return all;
    }

    @Override
    public TbApplicationEntity commitRequest(TbApplicationEntity tbApplicationEntity) {
        TbApplicationEntity save = tbApplicationDao.save(tbApplicationEntity);
        return save;
    }

    @Override
    public List<TbApplicationEntity> myRequest(Integer userId) {
        List<TbApplicationEntity> allByUserId = tbApplicationDao.findAllByUserId(userId);
        return allByUserId;
    }

    @Override
    public void commitEvaluation(String evaluation, Integer adId) {
        tbAdvisoryDao.commitUserEvaluation(evaluation, adId);
    }

    @Override
    public Page<TbAdvisoryEntity> myResult(Example<TbAdvisoryEntity> example, Pageable pageable) {
        Page<TbAdvisoryEntity> all = tbAdvisoryDao.findAll(example, pageable);
        List<TbAdvisoryEntity> content = all.getContent();
        for (TbAdvisoryEntity tbAdvisoryEntity : content) {
            tbAdvisoryEntity.setAdConsultantRecording(null);
        }
        Page<TbAdvisoryEntity> page = new Page<TbAdvisoryEntity>() {
            @Override
            public int getTotalPages() {
                return all.getTotalPages();
            }

            @Override
            public long getTotalElements() {
                return all.getTotalElements();
            }

            @Override
            public <U> Page<U> map(Function<? super TbAdvisoryEntity, ? extends U> function) {
                return all.map(function);
            }

            @Override
            public int getNumber() {
                return all.getNumber();
            }

            @Override
            public int getSize() {
                return all.getSize();
            }

            @Override
            public int getNumberOfElements() {
                return all.getNumberOfElements();
            }

            @Override
            public List<TbAdvisoryEntity> getContent() {
                return content;
            }

            @Override
            public boolean hasContent() {
                return all.hasContent();
            }

            @Override
            public Sort getSort() {
                return all.getSort();
            }

            @Override
            public boolean isFirst() {
                return all.isFirst();
            }

            @Override
            public boolean isLast() {
                return all.isLast();
            }

            @Override
            public boolean hasNext() {
                return all.hasNext();
            }

            @Override
            public boolean hasPrevious() {
                return all.hasPrevious();
            }

            @Override
            public Pageable nextPageable() {
                return all.nextPageable();
            }

            @Override
            public Pageable previousPageable() {
                return all.previousPageable();
            }

            @Override
            public Iterator<TbAdvisoryEntity> iterator() {
                return all.iterator();
            }
        };
        return page;
    }

    @Override
    public List<TbApplicationAll> getMyRequest(Integer userId) {
        return tbApplicationAllDao.getAllByUserId(userId);
    }

    @Override
    public Page<TbApplicationResult> getMyResult(Example<TbApplicationResult> example, Pageable pageable) {
        Page<TbApplicationResult> all = tbApplicationResultDao.findAll(example, pageable);
        List<TbApplicationResult> content = all.getContent();
        for (TbApplicationResult tbAdvisoryEntity : content) {
            tbAdvisoryEntity.setAdConsultantRecording(null);
        }
        Page<TbApplicationResult> page = new Page<TbApplicationResult>() {
            @Override
            public int getTotalPages() {
                return all.getTotalPages();
            }

            @Override
            public long getTotalElements() {
                return all.getTotalElements();
            }

            @Override
            public <U> Page<U> map(Function<? super TbApplicationResult, ? extends U> function) {
                return all.map(function);
            }

            @Override
            public int getNumber() {
                return all.getNumber();
            }

            @Override
            public int getSize() {
                return all.getSize();
            }

            @Override
            public int getNumberOfElements() {
                return all.getNumberOfElements();
            }

            @Override
            public List<TbApplicationResult> getContent() {
                return content;
            }

            @Override
            public boolean hasContent() {
                return all.hasContent();
            }

            @Override
            public Sort getSort() {
                return all.getSort();
            }

            @Override
            public boolean isFirst() {
                return all.isFirst();
            }

            @Override
            public boolean isLast() {
                return all.isLast();
            }

            @Override
            public boolean hasNext() {
                return all.hasNext();
            }

            @Override
            public boolean hasPrevious() {
                return all.hasPrevious();
            }

            @Override
            public Pageable nextPageable() {
                return all.nextPageable();
            }

            @Override
            public Pageable previousPageable() {
                return all.previousPageable();
            }

            @Override
            public Iterator<TbApplicationResult> iterator() {
                return all.iterator();
            }
        };
        return page;
    }

    @Override
    public List<TbAdvisoryEntity> getAllAdvisory(Integer userId) {
        return tbAdvisoryDao.getByUserId(userId);
    }
}
