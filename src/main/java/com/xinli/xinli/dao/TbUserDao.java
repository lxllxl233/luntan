package com.xinli.xinli.dao;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface
TbUserDao extends JpaRepository<TbUserEntity,Integer> , QueryByExampleExecutor<TbUserEntity> {
    TbUserEntity findByUserPhoneAndUserPassword(String userPhone,String password);
    TbUserEntity findByUserPhone(String userPhone);
    @Transactional
    void deleteByUserPhone(String userPhone);
    TbUserEntity findByUserId(Integer id);
}
