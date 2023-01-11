package com.junbaobao.mall.store.goods.entity.dto;

import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Classname CakeStoreGoodsEditSkuDto
 * @Description
 * @Date: Created in 2022/11/20 11:54
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CakeGoodsSkuDto {


    @ApiModelProperty("商品价格")
    @Alias("goodsPrice")
    private double goods_price;



    @ApiModelProperty("商品sku编码")
    @Alias("goodsSkuNo")
    private String goods_sku_no;

    @ApiModelProperty("商品重量(Kg)")
    @Alias("goodsWeight")
    private int goods_weight;

    @ApiModelProperty("规格图片ID")
    @Alias("imageId")
    private Integer image_id;


    @ApiModelProperty("商品划线价")
    @Alias("linePrice")
    private double line_price;



    private String skuKey;


    private List<Map<String,Integer>> skuKeys;


    private String spec_value_0;


    private String spec_value_1;

    @Alias("stockNum")
    private  Integer stock_num;
}
