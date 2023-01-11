package com.junbaobao.mall.store.goods.entity.Do;

import com.baomidou.mybatisplus.annotation.*;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname CakeGoodsStoreDo
 * @Description
 * @Date: Created in 2022/12/4 15:42
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
@TableName("cake_goods")
@ApiModel(value = "商品记录表", description = "商品记录表对象 cakeGoods")
public class CakeGoodsDo {
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    @TableId(value="goods_id",type= IdType.AUTO)
    private Integer goodsId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    /**
     * 商品编码
     */
    @ApiModelProperty(value = "商品编码")
    private String goodsNo;
    /**
     * 主图视频ID
     */
    @ApiModelProperty(value = "主图视频ID")
    private Integer videoId;
    /**
     * 主图视频ID
     */
    @ApiModelProperty(value = "主图视频ID")
    private Integer videoCoverId;
    /**
     * 商品卖点
     */
    @ApiModelProperty(value = "商品卖点")
    private String sellingPoint;
    /**
     * 商品规格(10单规格 20多规格)
     */
    @ApiModelProperty(value = "商品规格(10单规格 20多规格)")
    private Integer specType;
    /**
     * 商品价格(最低)
     */
    @ApiModelProperty(value = "商品价格(最低)")
    private BigDecimal goodsPriceMin;
    /**
     * 商品价格(最高)
     */
    @ApiModelProperty(value = "商品价格(最高)")
    private BigDecimal goodsPriceMax;
    /**
     * 划线价格(最低)
     */
    @ApiModelProperty(value = "划线价格(最低)")
    private BigDecimal linePriceMin;
    /**
     * 划线价格(最高)
     */
    @ApiModelProperty(value = "划线价格(最高)")
    private BigDecimal linePriceMax;
    /**
     * 库存总量(包含所有sku)
     */
    @ApiModelProperty(value = "库存总量(包含所有sku)")
    private Integer stockTotal;
    /**
     * 库存计算方式(10下单减库存 20付款减库存)
     */
    @ApiModelProperty(value = "库存计算方式(10下单减库存 20付款减库存)")
    private Integer deductStockType;
    /**
     * 商品详情
     */
    @ApiModelProperty(value = "商品详情")

    private String content;
    /**
     * 初始销量
     */
    @ApiModelProperty(value = "初始销量")

    private Integer salesInitial;
    /**
     * 实际销量
     */
    @ApiModelProperty(value = "实际销量")

    private Integer salesActual;
    /**
     * 配送模板ID
     */
    @ApiModelProperty(value = "配送模板ID")
    private Integer deliveryId;
    /**
     * 是否开启积分赠送(1开启 0关闭)
     */
    @ApiModelProperty(value = "是否开启积分赠送(1开启 0关闭)")
    private Integer isPointsGift;
    /**
     * 是否允许使用积分抵扣(1允许 0不允许)
     */
    @ApiModelProperty(value = "是否允许使用积分抵扣(1允许 0不允许)")
    private Integer isPointsDiscount;
    /**
     * 积分抵扣设置(0默认抵扣 1单独设置抵扣)
     */
    @ApiModelProperty(value = "积分抵扣设置(0默认抵扣 1单独设置抵扣)")
    private Integer isAlonePointsDiscount;
    /**
     * 单独设置积分抵扣的配置
     */
    @ApiModelProperty(value = "单独设置积分抵扣的配置")
    private String pointsDiscountConfig;
    /**
     * 是否开启会员折扣(1开启 0关闭)
     */
    @ApiModelProperty(value = "是否开启会员折扣(1开启 0关闭)")
    private Integer isEnableGrade;
    /**
     * 会员折扣设置(0默认等级折扣 1单独设置折扣)
     */
    @ApiModelProperty(value = "会员折扣设置(0默认等级折扣 1单独设置折扣)")
    private Integer isAloneGrade;
    /**
     * 单独设置折扣的配置
     */
    @ApiModelProperty(value = "单独设置折扣的配置")
    private String aloneGradeEquity;
    /**
     * 商品状态(10上架 20下架)
     */
    @ApiModelProperty(value = "商品状态(10上架 20下架)")
    private Integer status;
    /**
     * 排序(数字越小越靠前)
     */
    @ApiModelProperty(value = "排序(数字越小越靠前)")
    private Integer sort;


    /**
     * 是否删除 1正在使用，0删除
     */
    @TableLogic(value ="1",delval = "0")
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;


    @TableField(exist = false)
    private List<CakeUploadFileDo> goodsImages;



    @TableField(exist = false)
    private CakeUploadFileDo videoCover;


    @TableField(exist = false)
    private CakeUploadFileDo video;

    //销售数据
    @TableField(exist = false)
    private int goods_sales;
}
