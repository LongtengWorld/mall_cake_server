package com.junbaobao.mall.api.address.controller;

import com.junbaobao.mall.api.address.service.CakeRegionService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname APiRegionController
 * @Description
 * @Date: Created in 2023/1/9 22:38
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/region")
public class APiRegionController {
    @Resource
    private CakeRegionService cakeRegionService;

    @GetMapping("/tree")
    public StoreJsonResult<Map<String, Object>> getRegionTree() {
        Map<String, Object> map = new HashMap<>();

        map.put("list", cakeRegionService.getRegionTree());
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

}
