package com.junbaobao.mall.api.cart.service;

import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.util.StoreJsonResult;

import java.util.List;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-05 11:15:58
 * @description 购物车记录表
 */
public interface CakeCartService {

    Map<String, Object> addUserCart(int goodsId, String goodsSkuId, int goodsNum, int userId);

    Map<String, Object> getUserCartList(int userId);

    Map<String, Object> userClearCart(Integer[] cartIds, int userId);

    Map<String, Object> updUserCart(int goodsId, String goodsSkuId, int goodsNum, int userId);


    List<ApiCheckOutOrderGoodsInfoLIstVo> getUserCartByCartIdAndUserId(Integer[] cartIds, int userId);

}

