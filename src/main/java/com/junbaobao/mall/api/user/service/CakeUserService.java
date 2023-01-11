package com.junbaobao.mall.api.user.service;

import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobile.WxLoginMpMobileFormDto;
import com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobileDto;
import com.junbaobao.mall.api.user.entity.Dto.WxUserPartyDto;
import com.junbaobao.mall.api.user.entity.Vo.UserInfoVo;
import com.junbaobao.mall.util.StoreJsonResult;

import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-03 22:28:06
 *
 * @description 用户记录表
 */
public interface CakeUserService {



    StoreJsonResult<Map<String,Object>> loginWx(WxUserPartyDto partyData);

    /**
     * 绑定手机号码并且新增user数据
     */
    Map<String,Object>  loginMpWxMobile( WxLoginMpMobileFormDto wxLoginMpMobileFormDto,String platform);


    UserInfoVo getUserDoByUserId(int userId);


    CakeUserDo getUserInfoByUserId(int userId);
}

