package com.junbaobao.mall.store.entity.Do;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-28 17:22:25
 * @description 商家设置记录表(CakeStoreSetting实体类)
 */
@Data
@TableName("cake_store_setting")
@ApiModel(value = "商家设置记录表", description = "商家设置记录表对象 cakeStoreSetting")
public class CakeStoreSettingDo {
    /**
     * 设置项标示
     */
    @ApiModelProperty(value = "设置项标示")
    @Alias("key")
    @TableField("`key`")
    private String key;
    /**
     * 设置项描述
     */
    @ApiModelProperty(value = "设置项描述")
    @Alias("describe")
    @TableField("`describe`")
    private String describe;
    /**
     * 设置内容（json格式）
     */
    @ApiModelProperty(value = "设置内容（json格式）")
    @Alias("values")
    @TableField("`values`")
    private String values;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    @Alias("store_id")
    @TableField("`store_id`")
    private Integer storeId;
}
