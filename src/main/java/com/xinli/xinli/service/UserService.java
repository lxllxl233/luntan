package com.xinli.xinli.service;

import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.bean.TbApplicationEntity;
import com.xinli.xinli.bean.TbUserEntity;
import com.xinli.xinli.bean.other.TbApplicationAll;
import com.xinli.xinli.bean.other.TbApplicationResult;
import com.xinli.xinli.request.MasterLoginRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    TbUserEntity addAccount(TbUserEntity tbUserEntity);

    TbUserEntity findAccount(MasterLoginRequest loginRequest);

    List<TbUserEntity> getAllUser();

    TbApplicationEntity commitRequest(TbApplicationEntity tbApplicationEntity);

    List<TbApplicationEntity> myRequest(Integer userId);

    void commitEvaluation(String evaluation, Integer adId);

    Page<TbAdvisoryEntity> myResult(Example<TbAdvisoryEntity> example, Pageable pageable);

    List<TbApplicationAll> getMyRequest(Integer userId);

    Page<TbApplicationResult> getMyResult(Example<TbApplicationResult> example, Pageable pageable);

    List<TbAdvisoryEntity> getAllAdvisory(Integer userId);
}
