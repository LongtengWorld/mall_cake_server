package com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobile;

import com.junbaobao.mall.api.user.entity.Dto.WxUserPartyDto;
import lombok.Data;

/**
 * @Classname WxUserInfoDto
 * @Description
 * @Date: Created in 2023/1/3 22:07
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class WxLoginMpMobileFormDto {

    private String code;

    private String encryptedData;

    private Boolean isParty;

    private String iv;


    private WxUserPartyDto partyData;


}
