package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-18 14:49:26
 * @description 商品与分类关系记录表(CakeGoodsCategoryRel实体类)
 */
@Data
@TableName("cake_goods_category_rel")
@ApiModel(value = "商品与分类关系记录表", description = "商品与分类关系记录表对象 cakeGoodsCategoryRel")
public class CakeGoodsCategoryRelDo {
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
     * 商品分类ID
     */
    @ApiModelProperty(value = "商品分类ID")
    private Integer categoryId;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
}
