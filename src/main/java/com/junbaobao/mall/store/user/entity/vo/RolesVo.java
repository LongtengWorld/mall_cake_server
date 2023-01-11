package com.junbaobao.mall.store.user.entity.vo;

import lombok.Data;

/**
 * @Classname RolesVo
 * @Description
 * @Date: Created in 2022/9/19 21:52
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class RolesVo {
    private Integer isSuper;
    private String[] permissions;
}
