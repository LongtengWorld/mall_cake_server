package com.junbaobao.mall.api.address.entity.Vo;

import lombok.Data;

/**
 * @Classname RegionVo
 * @Description
 * @Date: Created in 2023/1/9 22:54
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class RegionVo {
    private int id;
    private int level;
    private String name;
    private int pid;
}
