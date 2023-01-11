package com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder;

import lombok.Data;

/**
 * @Classname CheckoutOrderAddressRegionVo
 * @Description
 * @Date: Created in 2023/1/8 14:50
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CheckoutOrderAddressRegionVo {
    /**
     * province : 北京
     * city : 北京市
     * region : 东城区
     */

    private String province;
    private String city;
    private String region;
}
