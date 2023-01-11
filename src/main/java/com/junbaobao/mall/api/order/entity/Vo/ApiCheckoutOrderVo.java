package com.junbaobao.mall.api.order.entity.Vo;

import com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder.CheckoutOrderVo;
import lombok.Data;

/**
 * @Classname ApiCheckoutOrderVo
 * @Description
 * @Date: Created in 2023/1/7 10:38
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiCheckoutOrderVo {

    private CheckoutOrderVo order;

    private PersonalVo personal;
    private SettingVo setting;
}
