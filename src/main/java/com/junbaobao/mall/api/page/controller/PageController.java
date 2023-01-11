package com.junbaobao.mall.api.page.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.junbaobao.mall.store.entity.Vo.PageDetailVo;
import com.junbaobao.mall.store.goods.service.CakeGoodsService;
import com.junbaobao.mall.store.service.CakePageService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import com.junbaobao.mall.util.enums.PageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname PageController
 * @Description
 * @Date: Created in 2022/12/28 21:46
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/page/")
@Slf4j
public class PageController {
    @Resource
    private CakePageService cakePageService;

    @Resource
    private CakeGoodsService cakeGoodsService;


    @GetMapping("/detail")
    public StoreJsonResult<Map<String, JSONObject>> detail(int pageId) {
        Map<String, JSONObject> map = new HashMap<>();
        PageDetailVo pageDetail = cakePageService.getPageDetail(pageId);


        if (ObjectUtil.isEmpty(pageDetail)) {
            throw new RuntimeException("很抱歉，未找到该页面");
        }
        JSONObject pageData = pageDetail.getPage_data();
        JSONArray itemsArray = pageData.getJSONArray("items");

        for (int i = 0; i < itemsArray.size(); i++) {
            JSONObject jsonObject = itemsArray.getJSONObject(i);
            String type = jsonObject.getString("type");

            //删除defaultData这个默认数据key
            if (jsonObject.containsKey("defaultData")) {
                jsonObject.remove("defaultData");
            }

            if (StrUtil.equals(type, "window")) {
                log.info("type{}", type);
            } else if (StrUtil.equals(type, "goods")) {
                jsonObject.put("data",  cakeGoodsService.getPageGoodsList(jsonObject));
                log.info("type{}", type);
            } else if (StrUtil.equals(type, "coupon")) {
                log.info("type{}", type);
            } else if (StrUtil.equals(type, "article")) {
                log.info("type{}", type);
            } else if (StrUtil.equals(type, "special")) {
                log.info("type{}", type);
            }
        }
        map.put("pageData", pageDetail.getPage_data());

        System.out.println(pageId);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
