package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-24 17:14:11
 * @description 商品与规格值关系记录表(CakeGoodsSpecRel实体类)
 */
@Data
@TableName("cake_goods_spec_rel")
@ApiModel(value = "商品与规格值关系记录表", description = "商品与规格值关系记录表对象 cakeGoodsSpecRel")
public class CakeGoodsSpecRelDo {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;
    /**
     * 规格组ID
     */
    @ApiModelProperty(value = "规格组ID")
    private Integer specId;
    /**
     * 规格值ID
     */
    @ApiModelProperty(value = "规格值ID")
    private Integer specValueId;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
}
