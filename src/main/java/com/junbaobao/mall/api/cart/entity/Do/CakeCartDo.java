package com.junbaobao.mall.api.cart.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2023-01-05 11:15:58
 * @description 购物车记录表(CakeCart实体类)
 */
@Data
@TableName("cake_cart")
@ApiModel(value = "购物车记录表", description = "购物车记录表对象 cakeCart")
public class CakeCartDo {
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
     * 商品sku唯一标识
     */
    @ApiModelProperty(value = "商品sku唯一标识")
    private String goodsSkuId;
    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer goodsNum;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableLogic(value ="1",delval = "0")

    private Integer isDelete;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
}
