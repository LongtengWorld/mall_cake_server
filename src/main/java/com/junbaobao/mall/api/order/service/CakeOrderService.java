package com.junbaobao.mall.api.order.service;

import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import com.junbaobao.mall.api.order.entity.Vo.ApiCheckoutOrderVo;
import com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder.CheckoutOrderVo;

import java.util.List;

/**
 * @author junbaobao
 * @date 2023-01-08 14:54:54
 *
 * @description 订单记录表
 */
public interface CakeOrderService  {


    /**
     * 初始化结算台数据
     */
    CheckoutOrderVo ApiCheckOUtOrderData(List<ApiCheckOutOrderGoodsInfoLIstVo> orderGoodsInfoLIstVos);


}

