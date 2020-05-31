package com.xinli.xinli.dao.other;

import com.xinli.xinli.bean.other.TbApplicationAll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbApplicationAllDao extends JpaRepository<TbApplicationAll,Integer> {
    List<TbApplicationAll> getAllByUserId(Integer userId);
}
