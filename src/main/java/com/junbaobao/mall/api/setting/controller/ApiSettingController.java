package com.junbaobao.mall.api.setting.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.junbaobao.mall.store.entity.Do.CakeStoreDo;
import com.junbaobao.mall.store.entity.Do.CakeStoreSettingDo;
import com.junbaobao.mall.store.entity.Vo.CakeStoreVo;
import com.junbaobao.mall.store.service.CakeStoreService;
import com.junbaobao.mall.store.service.CakeStoreSettingService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ApisettingController
 * @Description
 * @Date: Created in 2022/12/30 15:13
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/setting/")
@Slf4j
public class ApiSettingController {

    @Resource
    private CakeStoreSettingService cakeStoreSettingService;


    @Resource
    private CakeStoreService cakeStoreService;

    @GetMapping("data")
    public StoreJsonResult< Map<String, Map<String, Object>> > setSettingData() {
        Map<String, Map<String, Object>> map = new HashMap<>();
        CakeStoreDo cakeStoreDo = cakeStoreService.getByStoreId(10001);


        CakeStoreVo cakeStoreVo = BeanUtil.toBean(cakeStoreDo, CakeStoreVo.class);
        cakeStoreVo.setImage_url(null);
        cakeStoreVo.setLogoImage(null);

        Map<String, Object> dataMap = cakeStoreSettingService.getSettingDefaultData();
        //分类模板
        CakeStoreSettingDo pageCategoryTemplate = cakeStoreSettingService.getSettingDoByKey("page_category_template");

        //账号设置
        CakeStoreSettingDo registerTemplate = cakeStoreSettingService.getSettingDoByKey("register");

        dataMap.put("page_category_template",  JSONUtils.parse(pageCategoryTemplate.getValues()));

        dataMap.put("register",  JSONUtils.parse(registerTemplate.getValues()));
        dataMap.put("store",cakeStoreVo);

        map.put("setting",dataMap);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
