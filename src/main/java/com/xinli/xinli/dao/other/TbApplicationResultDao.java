package com.xinli.xinli.dao.other;

import com.xinli.xinli.bean.other.TbApplicationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TbApplicationResultDao extends JpaRepository<TbApplicationResult,Integer> , QueryByExampleExecutor<TbApplicationResult> {
}
