package com.junbaobao.mall.api.address.service;

import com.junbaobao.mall.api.address.entity.Do.CakeUserAddressDo;
import com.junbaobao.mall.api.address.entity.Dto.ApiAddressEditDto;

import java.util.List;

/**
 * @author junbaobao
 * @date 2023-01-05 16:51:18
 *
 * @description 用户收货地址表
 */
public interface CakeUserAddressService  {




  CakeUserAddressDo getUserDefaultAddress(int userId);


  List<CakeUserAddressDo> getUserAddressList(int userId);


  CakeUserAddressDo getUserAddressDetail(int userId,int addressId);

  int userAddressEdit(int userId, ApiAddressEditDto apiAddressEditDto);

  int userAddressAdd(int userId, ApiAddressEditDto apiAddressEditDto);



}

