package com.junbaobao.mall.api.goods.service;

import com.junbaobao.mall.api.goods.entity.Vo.ApiCartGoodsSkuVo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;

import java.util.List;

/**
 * @Classname ApiGoodsSkuService
 * @Description
 * @Date: Created in 2023/1/5 15:27
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public interface ApiGoodsSkuService {

    ApiCartGoodsSkuVo getGoodsSkuByGoodsIdAndSkuId(int goodsId, String skuId);
}
