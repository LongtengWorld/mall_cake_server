package com.junbaobao.mall.store.user.entity.vo;

import lombok.Data;

/**
 * @Classname UserInfoVo
 * @Description
 * @Date: Created in 2022/9/19 21:53
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class UserInfoVo {
    private  String create_time;

    private  Integer is_delete;

    private  Integer is_super;

    private  String real_name;

    private  Integer sort;

    private  Integer store_id;

    private  Integer store_user_id;

    private  String update_time;

    private  String user_name;
}
