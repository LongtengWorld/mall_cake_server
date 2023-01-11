package com.junbaobao.mall.api.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.user.entity.Do.CakeUserOauthDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junbaobao
 * @date 2023-01-03 22:49:44
 *
 * @description 第三方用户信息表
 */
@Mapper
public interface CakeUserOauthMapper extends BaseMapper<CakeUserOauthDo> {

}

