package com.junbaobao.mall.api.address.entity.Do;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.junbaobao.mall.api.address.entity.AddressRegion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2023-01-05 16:51:18
 * @description 用户收货地址表(CakeUserAddress实体类)
 */
@Data
@TableName("cake_user_address")
@ApiModel(value = "用户收货地址表", description = "用户收货地址表对象 cakeUserAddress")
public class CakeUserAddressDo {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value="address_id",type= IdType.AUTO)
    private Integer addressId;
    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String name;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;
    /**
     * 省份ID
     */
    @ApiModelProperty(value = "省份ID")
    private Integer provinceId;


    /**
     * 城市ID
     */
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;


    /**
     * 区/县ID
     */
    @ApiModelProperty(value = "区/县ID")
    @TableField(value = "region_id")
    private Integer regionId;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detail;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;


    @TableField(exist = false)
    private AddressRegion region;
}
