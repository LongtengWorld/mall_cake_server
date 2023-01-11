package com.junbaobao.mall.api.user.entity.Vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Classname CurrentOauth
 * @Description
 * @Date: Created in 2023/1/4 22:31
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CurrentOauthVo {
    private int id;

    @Alias("oauthId")
    private String oauth_id;

    @Alias("oauthType")
    private String oauth_type;


    private String unionid;

    @Alias("userId")
    private int user_id;
}
