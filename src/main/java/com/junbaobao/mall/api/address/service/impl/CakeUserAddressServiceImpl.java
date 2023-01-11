package com.junbaobao.mall.api.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.address.entity.Do.CakeUserAddressDo;
import com.junbaobao.mall.api.address.mapper.CakeUserAddressMapper;
import com.junbaobao.mall.api.address.service.CakeUserAddressService;
import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import com.junbaobao.mall.api.user.mapper.CakeUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author junbaobao
 * @date 2023-01-05 16:51:18
 *
 * @description 用户收货地址表
 */
@Service
public class CakeUserAddressServiceImpl extends ServiceImpl<CakeUserAddressMapper, CakeUserAddressDo> implements CakeUserAddressService {


	@Resource
    private CakeUserAddressMapper cakeUserAddressMapper;

    @Resource
    private CakeUserMapper cakeUserMapper;

    @Override
    public CakeUserAddressDo getUserDefaultAddress(int userId) {
        //先获取到user的默认地址ID
        CakeUserDo cakeUserDo = cakeUserMapper.selectById(userId);
        Integer addressId = cakeUserDo.getAddressId();
        //在查询地址信息
        return cakeUserAddressMapper.getAddressById(addressId);

    }

    @Override
    public List<CakeUserAddressDo> getUserAddressList(int userId) {

        return cakeUserAddressMapper.getUserAddressList(userId);
    }
}
