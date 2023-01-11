package com.junbaobao.mall.api.user.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author junbaobao
 * @date 2023-01-03 22:28:06
 * @description 用户记录表(CakeUser实体类)
 */
@Data
@TableName("cake_user")
@ApiModel(value = "用户记录表", description = "用户记录表对象 cakeUser")
public class CakeUserDo {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    @TableId(value="user_id",type= IdType.AUTO)
    private Integer userId;
    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String mobile;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    /**
     * 头像文件ID
     */
    @ApiModelProperty(value = "头像文件ID")
    private Integer avatarId;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 默认收货地址
     */
    @ApiModelProperty(value = "默认收货地址")
    private Integer addressId;
    /**
     * 用户可用余额
     */
    @ApiModelProperty(value = "用户可用余额")
    private BigDecimal balance;
    /**
     * 用户可用积分
     */
    @ApiModelProperty(value = "用户可用积分")
    private Integer points;
    /**
     * 用户总支付的金额
     */
    @ApiModelProperty(value = "用户总支付的金额")
    private BigDecimal payMoney;
    /**
     * 实际消费的金额(不含退款)
     */
    @ApiModelProperty(value = "实际消费的金额(不含退款)")
    private BigDecimal expendMoney;
    /**
     * 会员等级ID
     */
    @ApiModelProperty(value = "会员等级ID")
    private Integer gradeId;
    /**
     * 注册来源的平台 (APP、H5、小程序等)
     */
    @ApiModelProperty(value = "注册来源的平台 (APP、H5、小程序等)")
    private String platform;
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private Integer lastLoginTime;
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
