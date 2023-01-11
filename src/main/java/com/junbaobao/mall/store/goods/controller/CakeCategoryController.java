package com.junbaobao.mall.store.goods.controller;

import cn.hutool.core.bean.BeanUtil;

import com.junbaobao.mall.store.goods.entity.Do.CakeCategoryDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeCategoryListVo;
import com.junbaobao.mall.store.goods.service.CakeCategoryService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CategoryController
 * @Description
 * @Date: Created in 2022/9/21 21:16
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("store/category")
@Slf4j
public class CakeCategoryController {

    @Resource
    private CakeCategoryService cakeCategoryService;

    @GetMapping("/list")
    public StoreJsonResult<Map<String,Object>> categoryList() {

        List<CakeCategoryDo> storeCategoryList = cakeCategoryService.getCategoryList();

        List<CakeCategoryListVo> categoryListVos = BeanUtil.copyToList(storeCategoryList, CakeCategoryListVo.class);


        Map<String,Object> map = new HashMap<>();

        map.put("list",categoryListVos);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }



}
