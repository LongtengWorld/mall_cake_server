package com.junbaobao.mall.api.user.entity.Vo;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import lombok.Data;

/**
 * @Classname UserInfo
 * @Description
 * @Date: Created in 2023/1/4 17:16
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class UserInfoVo {
    @Alias("addressId")
    private int address_id;

    private FileInfoVo avatar;


    @Alias("avatarId")
    private int avatar_id;

    private String avatar_url;


    private String balance;

    private String city;


    private String country;

    private CurrentOauthVo currentOauth;


    @Alias("expendMoney")
    private String expend_money;


    private String gender;


    private String grade;


    @Alias("gradeId")
    private int grade_id;


    @Alias("lastLoginTime")
    private int last_login_time;


    private String mobile;


    @Alias("nickName")
    private String nick_name;


    @Alias("payMoney")
    private String pay_money;

    private String platform;


    private int points;

    private String province;


    @Alias("userId")
    private int user_id;


}
