package com.junbaobao.mall.api.order.entity.Vo;

import lombok.Data;

/**
 * @Classname PersonalVo
 * @Description
 * @Date: Created in 2023/1/8 17:49
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PersonalVo {

    /**
     * user_id : 10004
     * balance : 0.00
     * points : 0
     * address_id : 10003
     */

    private int user_id;
    private String balance;
    private int points;
    private int address_id;
}
