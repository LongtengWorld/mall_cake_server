package com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Classname CheckoutOrderAddressVo
 * @Description
 * @Date: Created in 2023/1/8 14:42
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

@NoArgsConstructor
@Data
public class CheckoutOrderAddressVo {
    /**
     * address_id : 10003
     * name : a
     * phone : 13027961340
     * province_id : 1
     * city_id : 2
     * region_id : 3
     * detail : 1232
     * user_id : 10004
     * region : {"province":"北京","city":"北京市","region":"东城区"}
     */

    private int address_id;
    private String name;
    private String phone;
    private int province_id;
    private int city_id;
    private int region_id;
    private String detail;
    private int user_id;
    private CheckoutOrderAddressRegionVo region;

}
