package com.xinli.xinli.service;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbMasterEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbAllAdvisory;
import com.xinli.xinli.request.MasterLoginRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    TbMasterEntity addAccount(TbMasterEntity tbMasterEntity);

    TbMasterEntity findAccount(MasterLoginRequest loginRequest);

    List<TbMasterEntity> getAllAccount();

    void deleteAccount(TbMasterEntity tbMasterEntity);

    List<TbMasterEntity> getAllAccountByAuthority(Integer authority);

    Page<TbMasterEntity> findAllByExample(Example<TbMasterEntity> example, Pageable pageable);

    Page<TbUserEntity> findAllUser(Example<TbUserEntity> example, Pageable pageable);

    List<TbAdvisoryEntity> getAllAdvisory();

    Page<TbAdvisoryEntity> getAllAdvisoryByPage(Example<TbAdvisoryEntity> example, Pageable pageable);

    List<TbAllAdvisory> findAllAdvisory();
}
