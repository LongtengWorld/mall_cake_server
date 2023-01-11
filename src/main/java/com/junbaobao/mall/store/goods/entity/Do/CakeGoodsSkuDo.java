package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author junbaobao
 * @date 2022-12-07 22:19:16
 * @description 商品规格表(CakeGoodsSku实体类)
 */
@Data
@TableName("cake_goods_sku")
@ApiModel(value = "商品规格表", description = "商品规格表对象 cakeGoodsSku")
public class CakeGoodsSkuDo {
    /**
     * 记录ID
     */
    @ApiModelProperty(value = "记录ID")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    /**
     * 商品sku唯一标识 (由规格id组成)
     */
    @ApiModelProperty(value = "商品sku唯一标识 (由规格id组成)")
    private String goodsSkuId;
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
    /**
     * 规格图片ID
     */
    @ApiModelProperty(value = "规格图片ID")
    private Integer imageId;
    /**
     * 商品sku编码
     */
    @ApiModelProperty(value = "商品sku编码")
    private String goodsSkuNo;
    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private String goodsPrice;
    /**
     * 商品划线价
     */
    @ApiModelProperty(value = "商品划线价")
    private String linePrice;
    /**
     * 当前库存数量
     */
    @ApiModelProperty(value = "当前库存数量")
    private Integer stockNum;
    /**
     * 商品重量(Kg)
     */
    @ApiModelProperty(value = "商品重量(Kg)")
    private Double goodsWeight;
    /**
     * SKU的规格属性(json格式)
     */
    @ApiModelProperty(value = "SKU的规格属性(json格式)")
    private String goodsProps;
    /**
     * 规格值ID集(json格式)
     */
    @ApiModelProperty(value = "规格值ID集(json格式)")
    private String specValueIds;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;



}
