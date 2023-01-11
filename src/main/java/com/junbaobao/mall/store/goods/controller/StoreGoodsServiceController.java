package com.junbaobao.mall.store.goods.controller;


import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsServiceVo;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname GoodsServiceController
 * @Description
 * @Date: Created in 2022/9/24 16:21
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/goods.service")
@Slf4j
public class StoreGoodsServiceController {

    @GetMapping("/all")
    public StoreJsonResult<Map<String,Object>> all() {
        Map<String,Object> map = new HashMap<>();
        List<StoreGoodsServiceVo> storeGoodsServiceVoList = new ArrayList<>();

        StoreGoodsServiceVo storeGoodsServiceVo = new StoreGoodsServiceVo();
        storeGoodsServiceVo.setCreate_time("2021-03-01 08:00:00");
        storeGoodsServiceVo.setIs_default(1);
        storeGoodsServiceVo.setIs_delete(0);
        storeGoodsServiceVo.setName("七天无理由退货");
        storeGoodsServiceVo.setService_id(10001);
        storeGoodsServiceVo.setSort(100);
        storeGoodsServiceVo.setStatus(1);
        storeGoodsServiceVo.setStore_id(10001);
        storeGoodsServiceVo.setSummary("满足相应条件时，消费者可申请7天无理由退货");
        storeGoodsServiceVo.setUpdate_time("2021-03-01 08:00:00");

        StoreGoodsServiceVo storeGoodsServiceVo1 = new StoreGoodsServiceVo();
        storeGoodsServiceVo1.setCreate_time("2021-03-01 08:00:00");
        storeGoodsServiceVo1.setIs_default(0);
        storeGoodsServiceVo1.setIs_delete(0);
        storeGoodsServiceVo1.setName("全场包邮");
        storeGoodsServiceVo1.setService_id(10002);
        storeGoodsServiceVo1.setSort(100);
        storeGoodsServiceVo1.setStatus(1);
        storeGoodsServiceVo1.setStore_id(10001);
        storeGoodsServiceVo1.setSummary("所有商品包邮（偏远地区除外）");
        storeGoodsServiceVo1.setUpdate_time("2021-03-01 08:00:00");


        StoreGoodsServiceVo storeGoodsServiceVo2 = new StoreGoodsServiceVo();
        storeGoodsServiceVo2.setCreate_time("2021-03-01 08:00:00");
        storeGoodsServiceVo2.setIs_default(1);
        storeGoodsServiceVo2.setIs_delete(0);
        storeGoodsServiceVo2.setName("48小时发货");
        storeGoodsServiceVo2.setService_id(10003);
        storeGoodsServiceVo2.setSort(100);
        storeGoodsServiceVo2.setStatus(1);
        storeGoodsServiceVo2.setStore_id(10001);
        storeGoodsServiceVo2.setSummary("下单后48小时之内发货");
        storeGoodsServiceVo2.setUpdate_time("2021-03-01 08:00:00");

        storeGoodsServiceVoList.add(storeGoodsServiceVo);
        storeGoodsServiceVoList.add(storeGoodsServiceVo1);
        storeGoodsServiceVoList.add(storeGoodsServiceVo2);
        map.put("list",storeGoodsServiceVoList);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

}
