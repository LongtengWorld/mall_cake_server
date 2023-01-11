package com.junbaobao.mall.api.order.entity.Vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname SettingVo
 * @Description
 * @Date: Created in 2023/1/8 17:54
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class SettingVo {

    /**
     * deliveryType : [10]
     * points_name : 积分
     * points_describe : a) 积分不可兑现、不可转让,仅可在本平台使用;
     b) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;
     c) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)
     d) 买家在完成该笔交易(订单状态为“已签收”)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;
     */

    private String points_name;
    private String points_describe;
    private List<Integer> deliveryType;
}
