package com.junbaobao.mall.store.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.junbaobao.mall.store.entity.Do.CakePageDo;
import com.junbaobao.mall.store.entity.Vo.*;
import com.junbaobao.mall.store.entity.Vo.defaultDataVo.PageDataVo;
import com.junbaobao.mall.store.service.CakePageService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname StorePageController
 * @Description
 * @Date: Created in 2022/12/27 10:23
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/page/")
@Slf4j
public class StorePageController {
    @Resource
    private CakePageService cakePageService;

    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> getPageList(int page, String name) {
        Map<String, Object> map = new HashMap<>();
        StorePageListVo storePageListVo = new StorePageListVo();
        List<StorePageVo> storePageVos = BeanUtil.copyToList(cakePageService.getByPageByNamePageDo(page, name), StorePageVo.class);

        storePageListVo.setCurrent_page(1);
        storePageListVo.setData(storePageVos);
        storePageListVo.setLast_page(1);
        storePageListVo.setPer_page(15);
        storePageListVo.setTotal(10);
        map.put("list", storePageListVo);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @GetMapping("/defaultData")
    public StoreJsonResult<JSONObject> getDefaultData() {
//        JSONObject pageDefaultData1 = cakePageService.getPageDefaultData();
//        PageDataVo pageDefaultData = (PageDataVo) pageDefaultData1;
        return Result.storeSuccess(cakePageService.getPageDefaultData(), ResultCode.STORE_ACCESS);
    }


    @GetMapping("/detail")
    public StoreJsonResult<Map<String, PageDetailVo>> getPageDetail(int pageId) {
        Map<String, PageDetailVo> map = new HashMap<>();
        map.put("detail", cakePageService.getPageDetail(pageId));
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @PostMapping("/edit")
    @Transactional
    public StoreJsonResult<String> pageEdit(@RequestBody PageEditVo pageEditVo) {
        CakePageDo cakePageDo = new CakePageDo();
        cakePageDo.setPageData(JSONUtil.toJsonStr(pageEditVo.getForm()));
        cakePageService.updPageById(pageEditVo.getPageId(),cakePageDo);

        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }


    @PostMapping("/add")
    @Transactional
    public  StoreJsonResult<String>  pageAdd(@RequestBody PageAddVo pageAddVo){
        CakePageDo cakePageDo = new CakePageDo();
        JSONObject form = pageAddVo.getForm();
        JSONObject page = form.getJSONObject("page");
        JSONObject params = page.getJSONObject("params");
        String name = params.getString("name");


        cakePageDo.setPageType(20);
        cakePageDo.setPageName(name);
        cakePageDo.setPageData(JSONUtils.toJSONString(form));
        cakePageDo.setStoreId(10001);
        cakePageService.addPage(cakePageDo);
        return Result.storeSuccess(null, ResultCode.STORE_INSERT_ACCESS);
    }

    @PostMapping("/setHome")
    @Transactional
    public  StoreJsonResult<String> setHome(@RequestBody SetHomeVo setHomeVo){
        //修改所有type为10的
        cakePageService.updPageTypeBy();

        System.out.println(setHomeVo);
        CakePageDo cakePageDo = new CakePageDo();
        cakePageDo.setPageType(10);
        cakePageService.updPageById(setHomeVo.getPageId(),cakePageDo);

        return Result.storeSuccess(null, ResultCode.STORE_UPDATE_ACCESS);
    }

}
