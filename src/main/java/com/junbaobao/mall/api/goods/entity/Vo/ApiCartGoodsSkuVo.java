package com.junbaobao.mall.api.goods.entity.Vo;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.goods.entity.vo.GoodsPropsVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 商品规格表
 * </p>
 *
 * @author junbaobao
 * @since 2022-09-25
 */
@Data
public class ApiCartGoodsSkuVo {



    @ApiModelProperty("商品ID")
    @Alias("goodsId")
    private Integer goods_id;



    @ApiModelProperty("商品价格")
    @Alias("goodsPrice")
    private String goods_price;


    @ApiModelProperty("当前库存数量")
    @Alias("stockNum")
    private Integer stock_num;

    @ApiModelProperty("商品sku唯一标识 (由规格id组成)")
    @Alias("goodsSkuId")
    private String goods_sku_id;

    @ApiModelProperty("商品sku编码")
    @Alias("goodsSkuNo")
    private String goods_sku_no;

    @ApiModelProperty("商品重量(Kg)")
    @Alias("goodsWeight")
    private int goods_weight;

    @ApiModelProperty("记录ID")
    private Integer id;


    @ApiModelProperty("规格图片ID")
    @Alias("imageId")
    private Integer image_id;


    @ApiModelProperty("商品划线价")
    @Alias("linePrice")
    private String line_price;

    @ApiModelProperty("规格值ID集(json格式)")
    @Alias("specValueIdsVo")
    private List<Integer> spec_value_ids;

    @ApiModelProperty("SKU的规格属性(json格式)")
    @Alias("goodsPropsVo")
    private List<GoodsPropsVo> goods_props;
    //private String goodsProps;



    @ApiModelProperty("商城ID")
    @Alias("storeId")
    private Integer store_id;



}
