package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-11 14:59:06
 * @description 商品规格组记录表(CakeSpec实体类)
 */
@Data
@TableName("cake_spec")
@ApiModel(value = "商品规格组记录表", description = "商品规格组记录表对象 cakeSpec")
public class CakeSpecDo {
    /**
     * 规格组ID
     */
    @ApiModelProperty(value = "规格组ID")
    @TableId(value="spec_id",type= IdType.AUTO)
    private Integer specId;
    /**
     * 规格组名称
     */
    @ApiModelProperty(value = "规格组名称")
    private String specName;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;

    @TableField(exist = false)
    private List<CakeSpecValueDo> specValueList;
}
