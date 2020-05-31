package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface TbMasterDao extends JpaRepository<TbMasterEntity,Integer> , QueryByExampleExecutor<TbMasterEntity> {
    TbMasterEntity findByMasterPhoneAndMasterPassword(String masterPhone,String masterPassword);
    List<TbMasterEntity> getAllByMasterAuthority(Integer authority);
    TbMasterEntity findByMasterPhone(String masterPhone);
    TbMasterEntity findByMasterId(Integer masterId);
}
