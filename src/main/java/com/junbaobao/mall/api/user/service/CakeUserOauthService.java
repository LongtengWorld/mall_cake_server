package com.junbaobao.mall.api.user.service;

import com.junbaobao.mall.api.user.entity.Do.CakeUserOauthDo;

/**
 * @author junbaobao
 * @date 2023-01-03 22:49:44
 *
 * @description 第三方用户信息表
 */
public interface CakeUserOauthService {

    /**
     *  判断当前openId是否存在
     * @param openId
     * @param oauthType
     * @return
     */
    CakeUserOauthDo getUserIdByOauthIdAndOauthType(String openId,String oauthType);



    int addUserOauth(CakeUserOauthDo cakeUserOauthDo);


    CakeUserOauthDo getCakeUserOauthDoByUserId(int userId);
}

