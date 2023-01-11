package com.junbaobao.mall.api.user.entity.Dto;

import lombok.Data;

/**
 * @Classname WxUserInfoDto
 * @Description
 * @Date: Created in 2023/1/3 22:10
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class WxUserInfoDto {
    private String avatarUrl;

    private String city;

    private String country;


    private int gender;


    private boolean is_demote;

    private String language;


    private String nickName;

    private String province;


}
