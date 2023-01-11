package com.junbaobao.mall.api.address.entity.Vo;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class CakeUserAddressVo {
    @Alias("addressId")
    private int address_id;

    @Alias("name")
    private String name;

    @Alias("phone")
    private String phone;

    @Alias("provinceId")
    private int province_id;

    @Alias("cityId")
    private int city_id;

    @Alias("regionId")
    private int region_id;

    @Alias("detail")
    private String detail;

    @Alias("userId")
    private int user_id;

    private AddressRegion region;

}
