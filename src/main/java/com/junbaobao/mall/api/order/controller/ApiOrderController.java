package com.junbaobao.mall.api.order.controller;

import com.junbaobao.mall.api.order.entity.Vo.UserOrderCounts;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ApiOrderController
 * @Description
 * @Date: Created in 2023/1/3 21:35
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class ApiOrderController {


    @ApiOperation("订单数量")
    @GetMapping("/todoCounts")
    public StoreJsonResult<Map<String, Object>> getUserAssets() {
        Map<String, Object> map = new HashMap<>();
        UserOrderCounts userOrderCounts = new UserOrderCounts();
        userOrderCounts.setDelivery(0);
        userOrderCounts.setPayment(0);
        userOrderCounts.setReceived(0);
        userOrderCounts.setRefund(0);

        map.put("counts", userOrderCounts);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }




}
