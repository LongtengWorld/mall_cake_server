package com.junbaobao.mall.api.order.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import com.junbaobao.mall.api.order.entity.Do.CakeOrderDo;
import com.junbaobao.mall.api.order.entity.Vo.ApiCheckoutOrderVo;
import com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder.CheckoutOrderVo;
import com.junbaobao.mall.api.order.mapper.CakeOrderMapper;
import com.junbaobao.mall.api.order.service.CakeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author junbaobao
 * @date 2023-01-08 14:54:54
 * @description 订单记录表
 */
@Service
public class CakeOrderServiceImpl extends ServiceImpl<CakeOrderMapper, CakeOrderDo> implements CakeOrderService {


    @Resource
    private CakeOrderMapper cakeOrderMapper;

    @Override
    public CheckoutOrderVo ApiCheckOUtOrderData(List<ApiCheckOutOrderGoodsInfoLIstVo> orderGoodsInfoLIstVos) {
        CheckoutOrderVo checkoutOrderVo = new CheckoutOrderVo();


        //商品总数量
        checkoutOrderVo.setOrderTotalNum(orderGoodsInfoLIstVos.stream().mapToInt(ApiCheckOutOrderGoodsInfoLIstVo::getTotal_num).sum());

        //TODO 订单金额(含优惠折扣)
        checkoutOrderVo.setOrderTotalPrice(orderGoodsInfoLIstVos.stream().mapToDouble(a -> Double.valueOf(a.getTotal_pay_price())).sum() + "");
        checkoutOrderVo.setOrderPayPrice(orderGoodsInfoLIstVos.stream().mapToDouble(a -> Double.valueOf(a.getTotal_pay_price())).sum() + "");


        //TODO 订单金额(含优惠折扣)
        checkoutOrderVo.setOrderPrice(orderGoodsInfoLIstVos.stream().mapToDouble(a -> Double.valueOf(a.getTotal_price())).sum() + "");

        checkoutOrderVo.setGoodsList(orderGoodsInfoLIstVos);


        //支付方式
        checkoutOrderVo.setPayType(10);
        // 赠送的积分数量
        checkoutOrderVo.setPointsBonus(0);
        // 积分抵扣金额
        checkoutOrderVo.setPointsMoney(0);
        // 是否使用积分抵扣
        checkoutOrderVo.setIsUsePoints("0");

        // 是否允许使用积分抵扣
        checkoutOrderVo.setIsAllowPoints(false);

        //   // 当前用户收货城市是否存在配送规则中
        checkoutOrderVo.setIntraRegion(true);
        // 配送费用
        checkoutOrderVo.setExpressPrice("0.00");

        // 当前配送类型
        checkoutOrderVo.setDelivery(10);

        return  checkoutOrderVo;
    }
}
