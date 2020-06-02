package com.xinli.xinli.service.impl;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbAllAdvisory;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.dao.TbMasterDao;
import com.xinli.xinli.dao.TbUserDao;
import com.xinli.xinli.dao.other.TbAllAdvisoryDao;
import com.xinli.xinli.request.MasterLoginRequest;
import com.xinli.xinli.service.AdminService;
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
public class AdminServiceImpl implements AdminService {
    @Autowired
    TbMasterDao tbMasterDao;
    @Autowired
    TbUserDao tbUserDao;
    @Autowired
    TbAdvisoryDao tbAdvisoryDao;
    @Autowired
    TbAllAdvisoryDao tbAllAdvisoryDao;

    @Override
    public TbMasterEntity addAccount(TbMasterEntity tbMasterEntity) {
        TbMasterEntity save = tbMasterDao.save(tbMasterEntity);
        return save;
    }

    @Override
    public TbMasterEntity findAccount(MasterLoginRequest loginRequest) {
        TbMasterEntity byMasterNameAndMasterPassword = tbMasterDao.findByMasterPhoneAndMasterPassword(loginRequest.getUserPhone(), loginRequest.getPassword());
        return byMasterNameAndMasterPassword;
    }

    @Override
    public List<TbMasterEntity> getAllAccount() {
        List<TbMasterEntity> all = tbMasterDao.findAll();
        return all;
    }

    @Override
    public void deleteAccount(TbMasterEntity tbMasterEntity) {
        tbMasterDao.delete(tbMasterEntity);
    }

    @Override
    public List<TbMasterEntity> getAllAccountByAuthority(Integer authority) {
        List<TbMasterEntity> allByMasterAgeAndMasterAuthority = tbMasterDao.getAllByMasterAuthority(authority);
        return allByMasterAgeAndMasterAuthority;
    }

    @Override
    public Page<TbMasterEntity> findAllByExample(Example<TbMasterEntity> example, Pageable pageable) {
        Page<TbMasterEntity> all = tbMasterDao.findAll(example, pageable);
        return all;
    }

    @Override
    public Page<TbUserEntity> findAllUser(Example<TbUserEntity> example, Pageable pageable) {
        Page<TbUserEntity> all = tbUserDao.findAll(example, pageable);
        List<TbUserEntity> content = all.getContent();
        content.forEach(e -> e.setUserPassword("*******"));
        content.forEach(e-> System.out.println(e.getUserPassword()));
        Page<TbUserEntity> page = new Page<TbUserEntity>() {
            @Override
            public int getTotalPages() {
                return all.getTotalPages();
            }

            @Override
            public long getTotalElements() {
                return all.getTotalElements();
            }

            @Override
            public <U> Page<U> map(Function<? super TbUserEntity, ? extends U> function) {
                return null;
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
            public List<TbUserEntity> getContent() {
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
            public Iterator<TbUserEntity> iterator() {
                return all.iterator();
            }
        };
        return page;
    }

    @Override
    public List<TbAdvisoryEntity> getAllAdvisory() {
        return tbAdvisoryDao.findAll();
    }

    @Override
    public Page<TbAdvisoryEntity> getAllAdvisoryByPage(Example<TbAdvisoryEntity> example, Pageable pageable) {
        return tbAdvisoryDao.findAll(example,pageable);
    }

    @Override
    public List<TbAllAdvisory> findAllAdvisory() {
        return tbAllAdvisoryDao.findAll();
    }

    @Override
    public Page<TbAllAdvisory> findAllAdvisoryByPage(Example<TbAllAdvisory> example, Pageable pageable) {
        return tbAllAdvisoryDao.findAll(example,pageable);
    }

}
