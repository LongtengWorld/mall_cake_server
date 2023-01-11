package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Classname CakePageGoodsList
 * @Description
 * @Date: Created in 2022/12/29 22:19
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CakePageGoodsList {

    @Alias("goodsId")
    private int goods_id;

    @Alias("goodsName")
    private String goods_name;

    @Alias("goodsPriceMax")
    private double goods_price_max;

    @Alias("goodsPriceMin")
    private double goods_price_min;

    @Alias("linePriceMax")
    private double line_price_max;

    @Alias("linePriceMin")
    private double line_price_min;

    @Alias("sellingPoint")
    private String selling_point;

    @Alias("goods_sales")
    private int goods_sales;


    private String goods_image;
}
