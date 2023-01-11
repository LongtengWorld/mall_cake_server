package com.junbaobao.mall.api.order.entity.Vo;

import lombok.Data;

/**
 * @Classname UserOrderCounts
 * @Description
 * @Date: Created in 2023/1/5 10:51
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class UserOrderCounts {
    private int delivery;

    private int payment;


    private int received;


    private int refund;


}
