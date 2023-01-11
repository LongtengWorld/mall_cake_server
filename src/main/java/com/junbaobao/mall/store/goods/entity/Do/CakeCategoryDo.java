package com.junbaobao.mall.store.goods.entity.Do;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Classname CakeCategoryDo
 * @Description
 * @Date: Created in 2022/12/4 14:54
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
@TableName("cake_category")
@ApiModel(value = "", description = "分类表")
public class CakeCategoryDo {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类ID
     */
    @ApiModelProperty(value = "商品分类ID")
    @Alias("category_id")
    private Integer categoryId;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    @Alias("name")
    private String name;
    /**
     * 上级分类ID
     */
    @ApiModelProperty(value = "上级分类ID")
    @Alias("parent_id")
    private Integer parentId;
    /**
     * 分类图片ID
     */
    @ApiModelProperty(value = "分类图片ID")
    @Alias("image_id")
    private Integer imageId;
    /**
     * 状态(1显示 0隐藏)
     */
    @ApiModelProperty(value = "状态(1显示 0隐藏)")
    @Alias("status")
    private Integer status;
    /**
     * 排序方式(数字越小越靠前)
     */
    @ApiModelProperty(value = "排序方式(数字越小越靠前)")
    @Alias("sort")
    private Integer sort;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    @Alias("store_id")
    private Integer storeId;


}
