package com.junbaobao.mall.api.order.entity.Do;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author junbaobao
 * @date 2023-01-08 14:54:54
 * @description 订单记录表(CakeOrder实体类)
 */
@Data
@TableName("cake_order")
@ApiModel(value = "订单记录表", description = "订单记录表对象 cakeOrder")
public class CakeOrderDo {
    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    /**
     * 商品总金额(不含优惠折扣)
     */
    @ApiModelProperty(value = "商品总金额(不含优惠折扣)")
    private BigDecimal totalPrice;
    /**
     * 订单金额(含优惠折扣)
     */
    @ApiModelProperty(value = "订单金额(含优惠折扣)")
    private BigDecimal orderPrice;
    /**
     * 优惠券ID
     */
    @ApiModelProperty(value = "优惠券ID")
    private Integer couponId;
    /**
     * 优惠券抵扣金额
     */
    @ApiModelProperty(value = "优惠券抵扣金额")
    private BigDecimal couponMoney;
    /**
     * 积分抵扣金额
     */
    @ApiModelProperty(value = "积分抵扣金额")
    private BigDecimal pointsMoney;
    /**
     * 积分抵扣数量
     */
    @ApiModelProperty(value = "积分抵扣数量")
    private Integer pointsNum;
    /**
     * 实际付款金额(包含运费)
     */
    @ApiModelProperty(value = "实际付款金额(包含运费)")
    private BigDecimal payPrice;
    /**
     * 后台修改的订单金额（差价）
     */
    @ApiModelProperty(value = "后台修改的订单金额（差价）")
    private BigDecimal updatePrice;
    /**
     * 买家留言
     */
    @ApiModelProperty(value = "买家留言")
    private String buyerRemark;
    /**
     * 支付方式(10余额支付 20微信支付)
     */
    @ApiModelProperty(value = "支付方式(10余额支付 20微信支付)")
    private Integer payType;
    /**
     * 付款状态(10未付款 20已付款)
     */
    @ApiModelProperty(value = "付款状态(10未付款 20已付款)")
    private Integer payStatus;
    /**
     * 付款时间
     */
    @ApiModelProperty(value = "付款时间")
    private Integer payTime;
    /**
     * 配送方式(10快递配送)
     */
    @ApiModelProperty(value = "配送方式(10快递配送)")
    private Integer deliveryType;
    /**
     * 运费金额
     */
    @ApiModelProperty(value = "运费金额")
    private BigDecimal expressPrice;
    /**
     * 物流公司ID
     */
    @ApiModelProperty(value = "物流公司ID")
    private Integer expressId;
    /**
     * 物流公司
     */
    @ApiModelProperty(value = "物流公司")
    private String expressCompany;
    /**
     * 物流单号
     */
    @ApiModelProperty(value = "物流单号")
    private String expressNo;
    /**
     * 发货状态(10未发货 20已发货)
     */
    @ApiModelProperty(value = "发货状态(10未发货 20已发货)")
    private Integer deliveryStatus;
    /**
     * 发货时间
     */
    @ApiModelProperty(value = "发货时间")
    private Integer deliveryTime;
    /**
     * 收货状态(10未收货 20已收货)
     */
    @ApiModelProperty(value = "收货状态(10未收货 20已收货)")
    private Integer receiptStatus;
    /**
     * 收货时间
     */
    @ApiModelProperty(value = "收货时间")
    private Integer receiptTime;
    /**
     * 订单状态(10进行中 20取消 21待取消 30已完成)
     */
    @ApiModelProperty(value = "订单状态(10进行中 20取消 21待取消 30已完成)")
    private Integer orderStatus;
    /**
     * 赠送的积分数量
     */
    @ApiModelProperty(value = "赠送的积分数量")
    private Integer pointsBonus;
    /**
     * 订单是否已结算(0未结算 1已结算)
     */
    @ApiModelProperty(value = "订单是否已结算(0未结算 1已结算)")
    private Integer isSettled;
    /**
     * 微信支付交易号
     */
    @ApiModelProperty(value = "微信支付交易号")
    private String transactionId;
    /**
     * 是否已评价(0否 1是)
     */
    @ApiModelProperty(value = "是否已评价(0否 1是)")
    private Integer isComment;
    /**
     * 订单来源(10普通订单)
     */
    @ApiModelProperty(value = "订单来源(10普通订单)")
    private Integer orderSource;
    /**
     * 来源记录ID
     */
    @ApiModelProperty(value = "来源记录ID")
    private Integer orderSourceId;
    /**
     * 来源客户端 (APP、H5、小程序等)
     */
    @ApiModelProperty(value = "来源客户端 (APP、H5、小程序等)")
    private String platform;
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
}
