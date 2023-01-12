package com.junbaobao.mall.api.address.controller;

import cn.hutool.core.bean.BeanUtil;
import com.junbaobao.mall.api.address.entity.Dto.ApiAddressEditDto;
import com.junbaobao.mall.api.address.entity.Dto.ApiAddressUPdDefault;
import com.junbaobao.mall.api.address.entity.Vo.CakeUserAddressVo;
import com.junbaobao.mall.api.address.service.CakeUserAddressService;
import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import com.junbaobao.mall.api.user.service.CakeUserService;
import com.junbaobao.mall.util.RedisUtil;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-05 16:51:18
 * @description 用户收货地址表
 */
@Slf4j
@RestController
@RequestMapping("/api/address")
@Api(value = "cakeUserAddress", tags = "用户收货地址表管理模块")
public class CakeUserAddressController {

    @Resource
    private CakeUserAddressService cakeUserAddressService;
    @Resource
    private CakeUserService cakeUserService;


    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/defaultId")
    public StoreJsonResult<Map<String, Object>> userAddressDefaultId(@RequestHeader(value = "Access-Token") String accessToken) {
        Map<String, Object> map = new HashMap<>();
        Integer userId = (Integer) redisUtil.get(accessToken);
        CakeUserDo userInfo = cakeUserService.getUserInfoByUserId(userId);

        map.put("defaultId", userInfo.getAddressId());
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> userAddressList(@RequestHeader(value = "Access-Token") String accessToken) {
        Map<String, Object> map = new HashMap<>();
        Integer userId = (Integer) redisUtil.get(accessToken);
        List<CakeUserAddressVo> userAddressList = BeanUtil.copyToList(cakeUserAddressService.getUserAddressList(userId), CakeUserAddressVo.class);
        map.put("list",userAddressList);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @GetMapping("/detail")
    public StoreJsonResult<Map<String, Object>> userAddressDetail(@RequestHeader(value = "Access-Token") String accessToken,Integer addressId) {
        Map<String, Object> map = new HashMap<>();
        Integer userId = (Integer) redisUtil.get(accessToken);
        map.put("detail", BeanUtil.toBean(cakeUserAddressService.getUserAddressDetail(userId,addressId),CakeUserAddressVo.class));
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }



    @PostMapping("/edit")
    @Transactional
    public StoreJsonResult<String> userAddressEdit(@RequestHeader(value = "Access-Token") String accessToken,@RequestBody ApiAddressEditDto apiAddressEditDto) {
        Integer userId = (Integer) redisUtil.get(accessToken);
        cakeUserAddressService.userAddressEdit(userId,apiAddressEditDto);

        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }

    @PostMapping("/add")
    @Transactional
    public StoreJsonResult<String> userAddressAdd(@RequestHeader(value = "Access-Token") String accessToken,@RequestBody ApiAddressEditDto apiAddressEditDto) {
        Integer userId = (Integer) redisUtil.get(accessToken);
        cakeUserAddressService.userAddressAdd(userId,apiAddressEditDto);
        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }

    @PostMapping("/setDefault")
    @Transactional
    public StoreJsonResult<String> updUserDefaultAddress(@RequestHeader(value = "Access-Token") String accessToken,@RequestBody ApiAddressUPdDefault apiAddressUPdDefault) {
        Integer userId = (Integer) redisUtil.get(accessToken);
        cakeUserService.updUserDefaultAddress(userId,apiAddressUPdDefault.getAddressId());
        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }
}
