package com.junbaobao.mall.api.address.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.address.entity.Do.CakeUserAddressDo;
import com.junbaobao.mall.api.address.entity.Dto.ApiAddressEditDto;
import com.junbaobao.mall.api.address.entity.Dto.ApiAddressFormDto;
import com.junbaobao.mall.api.address.mapper.CakeUserAddressMapper;
import com.junbaobao.mall.api.address.service.CakeUserAddressService;
import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import com.junbaobao.mall.api.user.mapper.CakeUserMapper;
import com.junbaobao.mall.api.user.service.CakeUserService;
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

    @Resource
    private CakeUserService cakeUserService;

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

    @Override
    public CakeUserAddressDo getUserAddressDetail(int userId, int addressId) {
        //在查询地址信息
        return cakeUserAddressMapper.getAddressById(addressId);
    }

    @Override
    public int userAddressEdit(int userId, ApiAddressEditDto apiAddressEditDto) {
        String addressId = apiAddressEditDto.getAddressId();
        QueryWrapper<CakeUserAddressDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("address_id",addressId);
        queryWrapper.eq("user_id",userId);
        CakeUserAddressDo cakeUserAddressDo = new CakeUserAddressDo();


        ApiAddressFormDto form = apiAddressEditDto.getForm();
        cakeUserAddressDo.setPhone(form.getPhone());
        cakeUserAddressDo.setName(form.getName());
        cakeUserAddressDo.setDetail(form.getDetail());
        cakeUserAddressDo.setProvinceId(form.getRegion().get(0).getValue());
        cakeUserAddressDo.setCityId(form.getRegion().get(1).getValue());
        cakeUserAddressDo.setRegionId( form.getRegion().get(2).getValue());
        return cakeUserAddressMapper.update(cakeUserAddressDo,queryWrapper);
    }

    @Override
    public int userAddressAdd(int userId, ApiAddressEditDto apiAddressEditDto) {
        //需要判断当前user的地址是否是第一次新增地址 如果是第一次新增为默认
        CakeUserDo cakeUserDo = cakeUserMapper.selectById(userId);


        CakeUserAddressDo cakeUserAddressDo = new CakeUserAddressDo();
        ApiAddressFormDto form = apiAddressEditDto.getForm();
        cakeUserAddressDo.setUserId(userId);
        cakeUserAddressDo.setPhone(form.getPhone());
        cakeUserAddressDo.setName(form.getName());
        cakeUserAddressDo.setDetail(form.getDetail());
        cakeUserAddressDo.setProvinceId(form.getRegion().get(0).getValue());
        cakeUserAddressDo.setCityId(form.getRegion().get(1).getValue());
        cakeUserAddressDo.setRegionId( form.getRegion().get(2).getValue());
        cakeUserAddressMapper.insert(cakeUserAddressDo);

        if (cakeUserDo.getAddressId()==0){
            cakeUserService.updUserDefaultAddress(userId,cakeUserAddressDo.getAddressId());
        }
        return 1;
    }




}
