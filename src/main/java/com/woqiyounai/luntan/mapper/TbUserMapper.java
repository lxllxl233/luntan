package com.woqiyounai.luntan.mapper;

import com.woqiyounai.luntan.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 小龙
 * @since 2020-05-23
 */
@Mapper
@Repository
public interface TbUserMapper extends BaseMapper<TbUser> {

}
