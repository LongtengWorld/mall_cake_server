package com.junbaobao.mall.api.address.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.address.entity.Do.CakeUserAddressDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author junbaobao
 * @date 2023-01-05 16:51:18
 *
 * @description 用户收货地址表
 */
@Mapper
public interface CakeUserAddressMapper extends BaseMapper<CakeUserAddressDo> {

    CakeUserAddressDo getAddressById(@Param("addressId")int addressId);

    List<CakeUserAddressDo> getUserAddressList(@Param("userId")int userId);
}

