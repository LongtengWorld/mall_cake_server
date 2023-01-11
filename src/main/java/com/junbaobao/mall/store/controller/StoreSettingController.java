package com.junbaobao.mall.store.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.junbaobao.mall.store.entity.Do.CakeStoreSettingDo;
import com.junbaobao.mall.store.entity.Vo.UpdSettingVo;
import com.junbaobao.mall.store.goods.entity.vo.DeliveryVo;
import com.junbaobao.mall.store.service.CakeStoreSettingService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname StoreSettingController
 * @Description
 * @Date: Created in 2022/12/28 17:24
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/")
@Slf4j
public class StoreSettingController {

    @Resource
    private CakeStoreSettingService cakeStoreSettingService;


    @GetMapping("/setting.delivery/all")
    public StoreJsonResult<Map<String, Object>> all() {
        Map<String, Object> map = new HashMap<>();

        List<DeliveryVo> deliveryVoList = new ArrayList<>();
        DeliveryVo deliveryVo = new DeliveryVo();
        deliveryVo.setCreate_time("2021-03-01 08:00:00");
        deliveryVo.setDelivery_id(10001);
        deliveryVo.setIs_delete(0);
        deliveryVo.setMethod(10);
        deliveryVo.setName("全国包邮（除偏远地区）");
        deliveryVo.setSort(100);
        deliveryVo.setStore_id(10001);
        deliveryVo.setUpdate_time("2021-03-01 08:00:00");
        deliveryVoList.add(deliveryVo);
        map.put("list", deliveryVoList);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @GetMapping("/setting/detail")
    public StoreJsonResult<Map<String, Object>> getSettingDetail(String key) {

        Map<String, Object> map = new HashMap<>();
        CakeStoreSettingDo settingDoByKey = cakeStoreSettingService.getSettingDoByKey(key);
        map.put("values", JSONUtils.parse(settingDoByKey.getValues()));
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }


    @PostMapping("/setting/update")
    public StoreJsonResult<String> settingUpdate(@RequestBody UpdSettingVo updSettingVo) {
        CakeStoreSettingDo settingDo = new CakeStoreSettingDo();
        settingDo.setValues(JSONUtils.toJSONString(updSettingVo.getForm()));


        cakeStoreSettingService.updSettingDoByKey(settingDo, updSettingVo.getKey());


        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }

}
