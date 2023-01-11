package com.junbaobao.mall.api.user.entity.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2023-01-03 22:49:44
 * @description 第三方用户信息表(CakeUserOauth实体类)
 */
@Data
@TableName("cake_user_oauth")
@ApiModel(value = "第三方用户信息表", description = "第三方用户信息表对象 cakeUserOauth")
public class CakeUserOauthDo {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    /**
     * 第三方登陆类型(MP-WEIXIN)
     */
    @ApiModelProperty(value = "第三方登陆类型(MP-WEIXIN)")
    private String oauthType;
    /**
     * 第三方用户唯一标识 (uid openid)
     */
    @ApiModelProperty(value = "第三方用户唯一标识 (uid openid)")
    private String oauthId;
    /**
     * 微信unionID
     */
    @ApiModelProperty(value = "微信unionID")
    private String unionid;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
}
