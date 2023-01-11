package com.junbaobao.mall.api.cart.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.cart.entity.Do.CakeCartDo;
import com.junbaobao.mall.api.cart.entity.Vo.ApiUserCartListVo;
import com.junbaobao.mall.api.cart.mapper.CakeCartMapper;
import com.junbaobao.mall.api.cart.service.CakeCartService;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCartGoodsSkuVo;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCartListGoodsInfoVo;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import com.junbaobao.mall.api.goods.service.ApiGoodsSkuService;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import com.junbaobao.mall.store.goods.service.CakeGoodsService;
import com.junbaobao.mall.store.goods.service.CakeGoodsSkuService;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author junbaobao
 * @date 2023-01-05 11:15:58
 * @description 购物车记录表
 */
@Service
@Slf4j
public class CakeCartServiceImpl extends ServiceImpl<CakeCartMapper, CakeCartDo> implements CakeCartService {


    @Resource
    private CakeCartMapper cakeCartMapper;

    @Resource
    private CakeGoodsService cakeGoodsService;

    @Resource
    private ApiGoodsSkuService apiGoodsSkuService;


    @Resource
    private CakeGoodsSkuService cakeGoodsSkuService;

    @Override
    public Map<String, Object> addUserCart(int goodsId, String goodsSkuId, int goodsNum, int userId) {
        Map<String, Object> map = new HashMap<>();
        int storeId = 10001;
        //判断当前商品是否有存在购物车
        CakeCartDo cakeCartDo = cakeCartMapper.getUserCartDoByGoodsIdAndGoodsSkuId(goodsId, goodsSkuId);

        //TODO 需要判断当前商品的状态 比如库存，是否存在，是否有有效
        if (ObjectUtil.isNotEmpty(cakeCartDo)) {
            goodsNum += cakeCartDo.getGoodsNum();
            cakeCartDo.setGoodsNum(goodsNum);
            cakeCartMapper.updateById(cakeCartDo);
        } else {
            cakeCartDo = new CakeCartDo();
            cakeCartDo.setGoodsId(goodsId);
            cakeCartDo.setGoodsSkuId(goodsSkuId);
            cakeCartDo.setGoodsNum(goodsNum);
            cakeCartDo.setUserId(userId);
            cakeCartDo.setStoreId(10001);
            cakeCartMapper.insert(cakeCartDo);
        }

        //返回总共购物车数量
        int countGoodsNum = cakeCartMapper.countUserGoodsNumByUserId(userId);
        map.put("cartTotal", countGoodsNum);
        return map;
    }

    @Override
    public Map<String, Object> getUserCartList(int userId) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<CakeCartDo> getUserCartListByUserId = new QueryWrapper<>();
        getUserCartListByUserId.eq("user_id", userId);

        List<ApiUserCartListVo> apiUserCartListVos = BeanUtil.copyToList(cakeCartMapper.selectList(getUserCartListByUserId), ApiUserCartListVo.class);

        for (ApiUserCartListVo cartListVo : apiUserCartListVos) {
            log.info("cartListVo{}", cartListVo);
            CakeGoodsDo goodsInfo = cakeGoodsService.getGoodsList(cartListVo.getGoods_id(), "", 0).get(0);
            if (ObjectUtil.isNotEmpty(goodsInfo)) {
                log.info("goodsInfo{}", goodsInfo);
                ApiCartListGoodsInfoVo apiCartListGoodsInfoVo = BeanUtil.toBean(goodsInfo, ApiCartListGoodsInfoVo.class);
                //设置商品图片
                if (ObjectUtil.isNotEmpty(apiCartListGoodsInfoVo.getGoods_images())) {
                    FileInfoVo fileInfoVo = apiCartListGoodsInfoVo.getGoods_images().get(0);
                    apiCartListGoodsInfoVo.setGoods_image(fileInfoVo.getExternal_url());
                }

                apiCartListGoodsInfoVo.setSkuInfo(apiGoodsSkuService.getGoodsSkuByGoodsIdAndSkuId(cartListVo.getGoods_id(), cartListVo.getGoods_sku_id()));
                cartListVo.setGoods(apiCartListGoodsInfoVo);

            }
        }


        //获取数量
        int countGoodsNum = cakeCartMapper.countUserGoodsNumByUserId(userId);
        map.put("cartTotal", countGoodsNum);
        map.put("list", apiUserCartListVos);
        return map;
    }

    @Override
    public Map<String, Object> userClearCart(Integer[] cartIds, int userId) {
        Map<String, Object> map = new HashMap<>();
        cakeCartMapper.deleteBatchIds(Arrays.asList(cartIds));
        //获取数量
        int countGoodsNum = cakeCartMapper.countUserGoodsNumByUserId(userId);
        map.put("cartTotal", countGoodsNum);
        return map;
    }

    @Override
    public Map<String, Object> updUserCart(int goodsId, String goodsSkuId, int goodsNum, int userId) {
        Map<String, Object> map = new HashMap<>();
        int storeId = 10001;
        //判断当前商品是否有存在购物车
        CakeCartDo cakeCartDo = cakeCartMapper.getUserCartDoByGoodsIdAndGoodsSkuId(goodsId, goodsSkuId);

        //TODO 需要判断当前商品的状态 比如库存，是否存在，是否有有效
        if (ObjectUtil.isNotEmpty(cakeCartDo)) {
            cakeCartDo.setGoodsNum(goodsNum);
            cakeCartMapper.updateById(cakeCartDo);
        }
        //返回总共购物车数量
        int countGoodsNum = cakeCartMapper.countUserGoodsNumByUserId(userId);
        map.put("cartTotal", countGoodsNum);
        return map;
    }

    @Override
    public  List<ApiCheckOutOrderGoodsInfoLIstVo> getUserCartByCartIdAndUserId(Integer[] cartIds, int userId) {
        List<ApiCheckOutOrderGoodsInfoLIstVo> apiCheckOutOrderGoodsInfoList = new ArrayList<>();
        List<CakeCartDo> cakeCartDoList = cakeCartMapper.selectBatchIds(Arrays.asList(cartIds));
        for (CakeCartDo cakeCartDo : cakeCartDoList) {
            CakeGoodsDo cakeGoodsDo = cakeGoodsService.getGoodsList(cakeCartDo.getGoodsId(), null, 0).get(0);

            ApiCheckOutOrderGoodsInfoLIstVo apiCheckOutOrderGoodsInfoLIstVo = BeanUtil.toBean(cakeGoodsDo, ApiCheckOutOrderGoodsInfoLIstVo.class);


            //根据单或者多规格取获取sku数据
            CakeGoodsSkuDo goodsSKuData = cakeGoodsSkuService.getGoodsSkuDoByGoodsIdOrSkuId(cakeCartDo.getGoodsSkuId(), cakeCartDo.getGoodsId(), cakeGoodsDo.getSpecType());
            //当前sku价格
            apiCheckOutOrderGoodsInfoLIstVo.setGoods_price(goodsSKuData.getGoodsPrice());
            //当前sku库存
            apiCheckOutOrderGoodsInfoLIstVo.setStock_total(goodsSKuData.getStockNum());

            //设置商品图片
            if (ObjectUtil.isNotEmpty(apiCheckOutOrderGoodsInfoLIstVo.getGoods_images())) {
                FileInfoVo fileInfoVo = apiCheckOutOrderGoodsInfoLIstVo.getGoods_images().get(0);
                apiCheckOutOrderGoodsInfoLIstVo.setGoods_image(fileInfoVo.getExternal_url());
            }
            apiCheckOutOrderGoodsInfoLIstVo.setSkuInfo(apiGoodsSkuService.getGoodsSkuByGoodsIdAndSkuId(cakeCartDo.getGoodsId(), cakeCartDo.getGoodsSkuId()));

            //数量
            apiCheckOutOrderGoodsInfoLIstVo.setTotal_num(cakeCartDo.getGoodsNum());
            //sku索引
            apiCheckOutOrderGoodsInfoLIstVo.setGoods_sku_id(cakeCartDo.getGoodsSkuId());
            //总共需要金额 这个需要计算优惠或者优惠券之类的
            apiCheckOutOrderGoodsInfoLIstVo.setTotal_pay_price(Double.valueOf(apiCheckOutOrderGoodsInfoLIstVo.getSkuInfo().getGoods_price())*cakeCartDo.getGoodsNum()+"");

            //TODO 订单实付款  + 运费
            //总共需要支付金额
            apiCheckOutOrderGoodsInfoLIstVo.setTotal_price(Double.valueOf(apiCheckOutOrderGoodsInfoLIstVo.getSkuInfo().getGoods_price())*cakeCartDo.getGoodsNum()+"");
            log.info("cakeGoodsDo{}",cakeGoodsDo);
            apiCheckOutOrderGoodsInfoList.add(apiCheckOutOrderGoodsInfoLIstVo);
        }

        return apiCheckOutOrderGoodsInfoList;
    }


}
