package com.junbaobao.mall.store.entity.Vo;

import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classname StorePageVo
 * @Description
 * @Date: Created in 2022/12/27 10:42
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StorePageVo {

    /**
     * 页面ID
     */
    @ApiModelProperty(value = "页面ID")
    @Alias("pageId")
    private Integer page_id;

    /**
     * 页面类型(10首页 20自定义页)
     */
    @ApiModelProperty(value = "页面类型(10首页 20自定义页)")
    @Alias("pageType")
    private Integer page_type;
    /**
     * 页面名称
     */
    @ApiModelProperty(value = "页面名称")
    @Alias("pageName")
    private String page_name;

    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    @Alias("storeId")
    private Integer store_id;
    /**
     * 软删除
     */
    @ApiModelProperty(value = "软删除")
    @Alias("isDelete")
    private Integer is_delete;


}
