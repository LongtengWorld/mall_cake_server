package com.junbaobao.mall.api.order.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.junbaobao.mall.api.address.entity.Vo.CakeUserAddressVo;
import com.junbaobao.mall.api.address.service.CakeUserAddressService;
import com.junbaobao.mall.api.cart.service.CakeCartService;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import com.junbaobao.mall.api.order.entity.Vo.ApiCheckoutOrderVo;
import com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder.CheckoutOrderVo;
import com.junbaobao.mall.api.order.entity.Vo.PersonalVo;
import com.junbaobao.mall.api.order.entity.Vo.SettingVo;
import com.junbaobao.mall.api.order.service.CakeOrderService;
import com.junbaobao.mall.util.RedisUtil;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname ApiCheckOutOrderController
 * @Description
 * @Date: Created in 2023/1/5 21:30
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/checkout")
@Slf4j
public class ApiCheckOutOrderController {
    @Resource
    private CakeCartService cakeCartService;

    @Resource
    private RedisUtil redisUtil;


    @Resource
    private CakeOrderService cakeOrderService;

    @Resource
    private CakeUserAddressService cakeUserAddressService;

    @ApiOperation("获取结算台数据")
    @GetMapping("/order")
    public StoreJsonResult<ApiCheckoutOrderVo> getCheckOutOrder(@RequestHeader(value = "Access-Token") String accessToken, String mode, int delivery, int couponId, int isUsePoints, Integer[] cartIds) {
        Map<String, Object> map = new HashMap<>();
        Integer userId = (Integer) redisUtil.get(accessToken);
        ApiCheckoutOrderVo apiCheckoutOrderVo = new ApiCheckoutOrderVo();

        //order
        CheckoutOrderVo checkoutOrderVo = cakeOrderService.ApiCheckOUtOrderData(cakeCartService.getUserCartByCartIdAndUserId(cartIds, userId));
        CakeUserAddressVo addressInfo = BeanUtil.toBean(cakeUserAddressService.getUserDefaultAddress(userId), CakeUserAddressVo.class);

        // 是否存在收货地址
        checkoutOrderVo.setExistAddress(ObjectUtil.isNotEmpty(addressInfo));

        checkoutOrderVo.setAddress(addressInfo);

        PersonalVo personalVo = new PersonalVo();
        personalVo.setUser_id(userId);
        personalVo.setBalance("0.00");
        personalVo.setPoints(0);
        personalVo.setAddress_id(addressInfo.getAddress_id());


        SettingVo settingVo = new SettingVo();
        settingVo.setPoints_name("积分");
        settingVo.setPoints_describe("a) 积分不可兑现、不可转让,仅可在本平台使用;↵b) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;↵c) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)↵d) 买家在完成该笔交易(订单状态为“已签收”)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;");
        List<Integer> listDeliveryType = new LinkedList<>();
        listDeliveryType.add(10);
        settingVo.setDeliveryType(listDeliveryType);

        apiCheckoutOrderVo.setOrder(checkoutOrderVo);
        apiCheckoutOrderVo.setPersonal(personalVo);
        apiCheckoutOrderVo.setSetting(settingVo);

        return Result.storeSuccess(apiCheckoutOrderVo, ResultCode.STORE_ACCESS);
    }
}
