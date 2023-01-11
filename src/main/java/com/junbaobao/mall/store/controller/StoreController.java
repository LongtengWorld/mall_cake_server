package com.junbaobao.mall.store.controller;


import com.junbaobao.mall.store.entity.Vo.StoreInfoVo;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname StoreController
 * @Description
 * @Date: Created in 2022/9/28 22:24
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/store/")
@Slf4j
public class StoreController {

    @GetMapping("/info")
    public StoreJsonResult<Map<String, Object>> storeInfo() {
        Map<String, Object> map = new HashMap<>();
        StoreInfoVo storeInfoVo = new StoreInfoVo();
        storeInfoVo.setCreate_time("2021-03-01 08:00:00");
        storeInfoVo.setDescribe("蛋糕商城是一款基于萤火商城二次开发的商城");
        storeInfoVo.setIs_delete(0);
        storeInfoVo.setIs_recycle(0);
        storeInfoVo.setLogoImage(null);
        storeInfoVo.setLogo_image_id(0);
        storeInfoVo.setSort(100);
        storeInfoVo.setStore_id(10001);
        storeInfoVo.setStore_name("蛋糕商城");
        storeInfoVo.setUpdate_time("2021-03-01 08:00:00");

        map.put("storeInfo", storeInfoVo);


        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }



}
