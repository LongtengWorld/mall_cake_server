package com.junbaobao.mall.api.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junbaobao
 * @date 2023-01-03 22:28:06
 *
 * @description 用户记录表
 */
@Mapper
public interface CakeUserMapper extends BaseMapper<CakeUserDo> {

}

