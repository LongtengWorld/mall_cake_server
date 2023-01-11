package com.junbaobao.mall.api.user.entity.Dto;

import lombok.Data;

/**
 * @Classname WxUserInfoPartyDto
 * @Description
 * @Date: Created in 2023/1/3 22:09
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class WxUserPartyDto {
    private String code;

    private String oauth;


    private WxUserInfoDto userInfo;
}
