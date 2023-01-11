package com.junbaobao.mall.api.address.controller;

import cn.hutool.core.bean.BeanUtil;
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
}
