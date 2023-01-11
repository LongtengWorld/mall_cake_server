package com.junbaobao.mall.store.entity.Do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-30 17:04:51
 * @description 商家(商户)记录表(CakeStore实体类)
 */
@Data
@TableName("cake_store")
@ApiModel(value = "商家(商户)记录表", description = "商家(商户)记录表对象 cakeStore")
public class CakeStoreDo {
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
    /**
     * 商城名称
     */
    @ApiModelProperty(value = "商城名称")
    private String storeName;
    /**
     * 商城简介
     */
    @ApiModelProperty(value = "商城简介")
    @TableField("`describe`")
    private String describe;
    /**
     * 商城logo文件ID
     */
    @ApiModelProperty(value = "商城logo文件ID")
    private Integer logoImageId;
    /**
     * 排序(数字越小越靠前)
     */
    @ApiModelProperty(value = "排序(数字越小越靠前)")
    private Integer sort;
    /**
     * 是否回收
     */
    @ApiModelProperty(value = "是否回收")
    private Integer isRecycle;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
}
