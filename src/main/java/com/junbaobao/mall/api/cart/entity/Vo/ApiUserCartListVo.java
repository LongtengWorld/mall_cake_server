package com.junbaobao.mall.api.cart.entity.Vo;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCartListGoodsInfoVo;
import lombok.Data;

/**
 * @Classname ApiUserCartListVo
 * @Description
 * @Date: Created in 2023/1/5 14:51
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiUserCartListVo {
    private String create_time;

    private ApiCartListGoodsInfoVo goods;

    @Alias("goodsId")
    private int goods_id;

    @Alias("goodsNum")
    private int goods_num;

    @Alias("goodsSkuId")
    private String goods_sku_id;


    private int id;

    @Alias("isDelete")
    private int is_delete;

    @Alias("storeId")
    private int store_id;


    private String update_time;

    @Alias("userId")
    private int user_id;

}
