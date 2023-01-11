package com.junbaobao.mall.api.category.controller;

import cn.hutool.core.bean.BeanUtil;
import com.junbaobao.mall.api.category.entity.ApiCategoryListVo;
import com.junbaobao.mall.store.goods.entity.Do.CakeCategoryDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeCategoryListVo;
import com.junbaobao.mall.store.goods.service.CakeCategoryService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ApiCategoryController
 * @Description
 * @Date: Created in 2022/12/30 16:31
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/category/")
@Slf4j
public class ApiCategoryController {

    @Resource
    private CakeCategoryService cakeCategoryService;

    @GetMapping("list")
    public StoreJsonResult<Map<String,Object> > getCategoryList(){


        List<CakeCategoryDo> storeCategoryList = cakeCategoryService.getCategoryList();

        List<ApiCategoryListVo> categoryListVos = BeanUtil.copyToList(storeCategoryList, ApiCategoryListVo.class);


        Map<String,Object> map = new HashMap<>();

        map.put("list",categoryListVos);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);


    }
}
