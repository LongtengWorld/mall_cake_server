package com.junbaobao.mall.api.address.entity.Do;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2023-01-09 22:40:29
 * @description 省市区数据表(CakeRegion实体类)
 */
@Data
@TableName("cake_region")
@ApiModel(value = "省市区数据表", description = "省市区数据表对象 cakeRegion")
public class CakeRegionDo {
    /**
     * 区划信息ID
     */
    @ApiModelProperty(value = "区划信息ID")
    private Integer id;
    /**
     * 区划名称
     */
    @ApiModelProperty(value = "区划名称")
    private String name;
    /**
     * 父级ID
     */
    @ApiModelProperty(value = "父级ID")
    private Integer pid;
    /**
     * 区划编码
     */
    @ApiModelProperty(value = "区划编码")
    private String code;
    /**
     * 层级(1省级 2市级 3区/县级)
     */
    @ApiModelProperty(value = "层级(1省级 2市级 3区/县级)")
    private Integer level;
}
