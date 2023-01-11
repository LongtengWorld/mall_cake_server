package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-11 15:34:46
 * @description 商品规格值记录表(CakeSpecValue实体类)
 */
@Data
@TableName("cake_spec_value")
@ApiModel(value = "商品规格值记录表", description = "商品规格值记录表对象 cakeSpecValue")
public class CakeSpecValueDo {
    /**
     * 规格值ID
     */
    @ApiModelProperty(value = "规格值ID")
    @TableId(value="spec_value_id",type= IdType.AUTO)
    private Integer specValueId;
    /**
     * 规格值
     */
    @ApiModelProperty(value = "规格值")
    private String specValue;
    /**
     * 规格组ID
     */
    @ApiModelProperty(value = "规格组ID")
    private Integer specId;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
}
