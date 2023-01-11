package com.junbaobao.mall.api.goods.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.junbaobao.mall.api.goods.entity.Vo.ApiGoodsSpecDto;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreSpecVo;
import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsDetailInfoVo;
import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsInfoVo;
import com.junbaobao.mall.store.goods.entity.vo.searchGoodsListVo.SearchGoodsVo;
import com.junbaobao.mall.store.goods.service.CakeCategoryService;
import com.junbaobao.mall.store.goods.service.CakeGoodsService;
import com.junbaobao.mall.store.goods.service.CakeGoodsSkuService;
import com.junbaobao.mall.store.goods.service.CakeSpecService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ApiGoodsController
 * @Description
 * @Date: Created in 2022/12/30 14:32
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api/goods")
@Slf4j
public class ApiGoodsController {
    @Resource
    private CakeGoodsService cakeGoodsService;

    @Resource
    private CakeCategoryService cakeCategoryService;

    @Resource
    private CakeGoodsSkuService cakeGoodsSkuService;


    @Resource
    private CakeSpecService cakeSpecService;

    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> searchGoodsList(int categoryId, int page) {
        log.info("搜索GoodsList");

        List<CakeGoodsDo> goodsList = cakeGoodsService.getGoodsList(0, null, categoryId);

        List<StoreGoodsInfoVo> storeGoodsInfoVos = BeanUtil.copyToList(goodsList, StoreGoodsInfoVo.class);
        storeGoodsInfoVos.forEach(a -> {
            //设置商品图片
            if (ObjectUtil.isNotEmpty(a.getGoods_images())) {
                FileInfoVo fileInfoVo = a.getGoods_images().get(0);
                a.setGoods_image(fileInfoVo.getExternal_url());
                return;
            }

        });

        Map<String, Object> map = new HashMap<>();
        SearchGoodsVo searchGoodsVo = new SearchGoodsVo();
        searchGoodsVo.setCurrent_page(1);
        searchGoodsVo.setLast_page(1);
        searchGoodsVo.setData(storeGoodsInfoVos);
        searchGoodsVo.setPer_page(15);
        searchGoodsVo.setTotal(3);
        map.put("list", searchGoodsVo);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @GetMapping("/detail")
    public StoreJsonResult<Map<String, Object>> getApiGoodsDetail(int goodsId) {
        Map<String, Object> map = new HashMap<>();
        //TODO 修改改成获取当个
        //获取商品信息
        List<CakeGoodsDo> goodsList = cakeGoodsService.getGoodsList(goodsId, null, 0);
        CakeGoodsDo CakeGoods = goodsList.get(0);

        StoreGoodsDetailInfoVo storeGoodsDetailInfoVo = null;
        if (ObjectUtil.isNotEmpty(CakeGoods)) {
            storeGoodsDetailInfoVo = BeanUtil.toBean(CakeGoods, StoreGoodsDetailInfoVo.class);

            //获取商品所属的分类的ID
            int[] goodsCategoryId = cakeCategoryService.getGoodsCategoryId(goodsId);
            storeGoodsDetailInfoVo.setCategoryIds(goodsCategoryId);

            //设置图片goods_image 属性值
            String url = storeGoodsDetailInfoVo.getGoods_images().get(0).getDomain() + storeGoodsDetailInfoVo.getGoods_images().get(0).getFile_path();
            storeGoodsDetailInfoVo.setGoods_image(url);

            //设置服务与承诺
            int[] serviceIds = new int[]{10001, 10003};
            storeGoodsDetailInfoVo.setServiceIds(serviceIds);

            //sku设置
            List<CakeStoreGoodsSkuVo> cakeStoreGoodsSkuVos = cakeGoodsSkuService.listGoodsSku(goodsId);
            storeGoodsDetailInfoVo.setSkuList(cakeStoreGoodsSkuVos);

            //specList设置
            List<CakeStoreSpecVo> cakeSpecList = cakeSpecService.getCakeSpecList(goodsId);
            storeGoodsDetailInfoVo.setSpecList(cakeSpecList);

        }

        map.put("detail", storeGoodsDetailInfoVo);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
    //specData

    @GetMapping("/specData")
    public StoreJsonResult<Map<String, Object>> getApiGoodsSpec(int goodsId) {
        Map<String, Object> map = new HashMap<>();
        ApiGoodsSpecDto  apiGoodsSpecDto = new ApiGoodsSpecDto();
        apiGoodsSpecDto.setSkuList(cakeGoodsSkuService.listGoodsSku(goodsId));
        apiGoodsSpecDto.setSpecList(cakeSpecService.getCakeSpecList(goodsId));

        map.put("specData",apiGoodsSpecDto);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
