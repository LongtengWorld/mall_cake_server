package com.junbaobao.mall.store.file.entity.Do;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("cake_goods_image")
@ApiModel(value = "商品图片记录表", description = "商品图片记录表对象 cakeGoodsImage")
public class CakeGoodsImageDo {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @Alias("id")
    @TableId(value="goods_id",type= IdType.AUTO)
    private Integer id;
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    @Alias("goods_id")
    private Integer goodsId;
    /**
     * 图片id(关联文件记录表)
     */
    @ApiModelProperty(value = "图片id(关联文件记录表)")
    @Alias("image_id")
    private Integer imageId;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    @Alias("store_id")
    private Integer storeId;
}
