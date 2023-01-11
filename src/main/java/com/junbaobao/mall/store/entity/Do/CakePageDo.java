package com.junbaobao.mall.store.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-27 10:25:24
 * @description 店铺页面记录表(CakePage实体类)
 */
@Data
@TableName("cake_page")
@ApiModel(value = "店铺页面记录表", description = "店铺页面记录表对象 cakePage")
public class CakePageDo {
    /**
     * 页面ID
     */
    @ApiModelProperty(value = "页面ID")
    @TableId(value="page_id",type= IdType.AUTO)
    private Integer pageId;
    /**
     * 页面类型(10首页 20自定义页)
     */
    @ApiModelProperty(value = "页面类型(10首页 20自定义页)")
    private Integer pageType;
    /**
     * 页面名称
     */
    @ApiModelProperty(value = "页面名称")
    private String pageName;
    /**
     * 页面数据
     */
    @ApiModelProperty(value = "页面数据")
    private String pageData;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
    /**
     * 软删除
     */
    @ApiModelProperty(value = "软删除")
    private Integer isDelete;
}
