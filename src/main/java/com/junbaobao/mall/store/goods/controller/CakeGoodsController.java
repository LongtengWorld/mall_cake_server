package com.junbaobao.mall.store.goods.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.file.service.CakeGoodsImageService;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import com.junbaobao.mall.store.goods.entity.dto.CakeGoodsSkuDto;
import com.junbaobao.mall.store.goods.entity.dto.GoodsEditDto;
import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;
import com.junbaobao.mall.store.goods.entity.dto.GoodsAddDto;
import com.junbaobao.mall.store.goods.entity.dto.goodsAddDto.GoodsAddFormDto;
import com.junbaobao.mall.store.goods.entity.dto.goodsDelDto.GoodsIds;
import com.junbaobao.mall.store.goods.entity.dto.goodsEditDto.GoodsEditFormDto;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreSpecVo;
import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsDetailInfoVo;
import com.junbaobao.mall.store.goods.entity.vo.searchGoodsListVo.SearchGoodsVo;
import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsInfoVo;
import com.junbaobao.mall.store.goods.service.*;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import com.junbaobao.mall.util.enums.EventTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;


/**
 * @Classname PassportController
 * @Description
 * @Date: Created in 2022/9/19 21:10
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/goods")
@Slf4j
public class CakeGoodsController {

    @Resource
    private CakeGoodsService cakeGoodsService;


    @Resource
    private CakeCategoryService cakeCategoryService;


    @Resource
    private CakeGoodsSkuService cakeGoodsSkuService;


    @Resource
    private CakeSpecService cakeSpecService;

    @Resource
    private CakeGoodsCategoryRelService cakeGoodsCategoryRelService;


    @Resource
    private CakeGoodsImageService cakeGoodsImageService;

    @Resource
    private CakeGoodsSpecRelService cakeGoodsSpecRelService;


    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> SearchGoodsList(int page, String listType,String goodsName) {
        log.info("page{},listType{}", page, listType);


        List<CakeGoodsDo> goodsList = cakeGoodsService.getGoodsList(0,goodsName,0);

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
    public StoreJsonResult<Map<String, Object>> getGoodsDetail(int goodsId) {
        Map<String, Object> map = new HashMap<>();
        //TODO 修改改成获取当个
        //获取商品信息
        List<CakeGoodsDo> goodsList = cakeGoodsService.getGoodsList(goodsId,null,0);
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

        map.put("goodsInfo", storeGoodsDetailInfoVo);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }


    @PostMapping("/edit")
    @Transactional
    public StoreJsonResult<String> getGoodsEdit(@RequestBody GoodsEditDto goodsEditDto) {

        //修改商品信息
        int goodsId = goodsEditDto.getGoodsId();
        GoodsEditFormDto form = goodsEditDto.getForm();
        CakeGoodsDo cakeGoodsDo = BeanUtil.toBean(form, CakeGoodsDo.class);
        cakeGoodsDo.setGoodsId(goodsId);

        //修改商品基本信息 成功后才进行下一步
        CakeGoodsDo CakeGoods = cakeGoodsService.updByIdGoods(cakeGoodsDo);
        if (ObjectUtil.isNotEmpty(CakeGoods)) {
            Integer storeId = CakeGoods.getStoreId();
            int specType = form.getSpec_type();

            //修改分类 操作cakeGoodsCategoryRel这个表  删除新增操作
            cakeGoodsCategoryRelService.updByGoodsId(goodsId, form.getCategoryIds(), storeId);


            //修改图片 操作cake_goods_image这个表
            cakeGoodsImageService.updByGoodsId(goodsId, form.getImagesIds(), storeId);

            //修改sku数据 操作cake_goods_sku 删除新增操作
            if (EventTypeEnum.SINGLE.getValue().intValue() == specType) {
                //单规格
                CakeGoodsSkuDo cakeGoodsSkuDo = new CakeGoodsSkuDo();
                cakeGoodsSkuDo.setGoodsSkuId("0");
                cakeGoodsSkuDo.setGoodsId(goodsId);
                cakeGoodsSkuDo.setImageId(0);
                cakeGoodsSkuDo.setGoodsPrice(form.getGoods_price());
                cakeGoodsSkuDo.setLinePrice(form.getLine_price());
                cakeGoodsSkuDo.setStockNum(form.getStock_num());
                cakeGoodsSkuDo.setGoodsWeight(form.getGoods_weight());
                cakeGoodsSkuDo.setStoreId(storeId);
                cakeGoodsSkuService.addCakeGoodsSku(cakeGoodsSkuDo);

                cakeGoodsDo.setGoodsPriceMin(new BigDecimal(form.getGoods_price()));
                //最大
                cakeGoodsDo.setGoodsPriceMax(new BigDecimal(form.getGoods_price()));

                //划线最大
                cakeGoodsDo.setLinePriceMax(new BigDecimal(form.getGoods_price()));
                //划线最大
                cakeGoodsDo.setLinePriceMin(new BigDecimal(form.getGoods_price()));
                //总库存
                cakeGoodsDo.setStockTotal(form.getStock_num());
            } else {
                //修改规格key和value  操作cake_goods_spec_rel这个表 如果这个key存在于cake_spec 使用旧的 如果不存在进行新增  这个数据处理过的
                List<CakeSpecDto> newSpecListDto = cakeGoodsSpecRelService.updByGoodsId(goodsId, storeId, form.getSpecData().getSpecList());


                //最小价格
                cakeGoodsDo.setGoodsPriceMin(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getGoods_price).min().getAsDouble()));
                //最大
                cakeGoodsDo.setGoodsPriceMax(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getGoods_price).max().getAsDouble()));

                //划线最大
                cakeGoodsDo.setLinePriceMax(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getLine_price).max().getAsDouble()));
                //划线最大
                cakeGoodsDo.setLinePriceMin(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getLine_price).min().getAsDouble()));

                //总库存
                cakeGoodsDo.setStockTotal((int) form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getStock_num).sum());
                //多规格
                cakeGoodsSkuService.updByGoodsId(goodsId, storeId, form.getSpecData().getSkuList(), newSpecListDto);
            }

            cakeGoodsService.updByIdGoods(cakeGoodsDo);
        }


        return Result.storeSuccess("", ResultCode.STORE_ACCESS);
    }


    @PostMapping("/add")
    @Transactional
    public StoreJsonResult<String> addGoods(@RequestBody GoodsAddDto goodsAddDto) {
        GoodsAddFormDto form = goodsAddDto.getForm();
        CakeGoodsDo cakeGoodsDtoToDo = BeanUtil.toBean(form, CakeGoodsDo.class);
        cakeGoodsDtoToDo.setStoreId(10001);
        CakeGoodsDo cakeGoodsDo = cakeGoodsService.addGoods(cakeGoodsDtoToDo);
        if (ObjectUtil.isNotEmpty(cakeGoodsDo)) {

            Integer goodsId = cakeGoodsDo.getGoodsId();
            Integer storeId = cakeGoodsDtoToDo.getStoreId();
            Integer specType = cakeGoodsDtoToDo.getSpecType();
            //修改分类 操作cakeGoodsCategoryRel这个表  删除新增操作
            cakeGoodsCategoryRelService.updByGoodsId(goodsId, form.getCategoryIds(), storeId);

            //修改图片 操作cake_goods_image这个表
            cakeGoodsImageService.updByGoodsId(goodsId, form.getImagesIds(), storeId);


            //修改sku数据 操作cake_goods_sku 删除新增操作
            if (EventTypeEnum.SINGLE.getValue().intValue() == specType) {
                //单规格
                CakeGoodsSkuDo cakeGoodsSkuDo = new CakeGoodsSkuDo();
                cakeGoodsSkuDo.setGoodsSkuId("0");
                cakeGoodsSkuDo.setGoodsId(goodsId);
                cakeGoodsSkuDo.setImageId(0);
                cakeGoodsSkuDo.setGoodsPrice(form.getGoods_price());
                cakeGoodsSkuDo.setLinePrice(form.getLine_price());
                cakeGoodsSkuDo.setStockNum(form.getStock_num());
                cakeGoodsSkuDo.setGoodsWeight(form.getGoods_weight());
                cakeGoodsSkuDo.setStoreId(storeId);
                cakeGoodsSkuService.addCakeGoodsSku(cakeGoodsSkuDo);

                cakeGoodsDo.setGoodsPriceMin(new BigDecimal(form.getGoods_price()));
                //最大
                cakeGoodsDo.setGoodsPriceMax(new BigDecimal(form.getGoods_price()));

                //划线最大
                cakeGoodsDo.setLinePriceMax(new BigDecimal(form.getGoods_price()));
                //划线最大
                cakeGoodsDo.setLinePriceMin(new BigDecimal(form.getGoods_price()));
                //总库存
                cakeGoodsDo.setStockTotal(form.getStock_num());

            } else {
                cakeGoodsDo.setGoodsPriceMin(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getGoods_price).min().getAsDouble()));
                //最大
                cakeGoodsDo.setGoodsPriceMax(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getGoods_price).max().getAsDouble()));

                //划线最大
                cakeGoodsDo.setLinePriceMax(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getLine_price).max().getAsDouble()));
                //划线最大
                cakeGoodsDo.setLinePriceMin(new BigDecimal(form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getLine_price).min().getAsDouble()));

                //总库存
                cakeGoodsDo.setStockTotal((int) form.getSpecData().getSkuList().stream().mapToDouble(CakeGoodsSkuDto::getStock_num).sum());


                //修改规格key和value  操作cake_goods_spec_rel这个表 如果这个key存在于cake_spec 使用旧的 如果不存在进行新增  这个数据处理过的
                List<CakeSpecDto> newSpecListDto = cakeGoodsSpecRelService.updByGoodsId(goodsId, storeId, form.getSpecData().getSpecList());
                //多规格
                cakeGoodsSkuService.updByGoodsId(goodsId, storeId, form.getSpecData().getSkuList(), newSpecListDto);
            }
            cakeGoodsService.updByIdGoods(cakeGoodsDo);
        }


        return Result.storeSuccess(null, ResultCode.STORE_INSERT_ACCESS);
    }


    @PostMapping("/delete")
    @Transactional
    public StoreJsonResult<String> deleteGoods(@RequestBody GoodsIds goodsIds) {
        cakeGoodsService.delGoods(goodsIds.getGoodsIds());

        return Result.storeSuccess(null, ResultCode.STORE_DELETE_ACCESS);
    }

}
