package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Classname CategoryListVo
 * @Description
 * @Date: Created in 2022/9/21 21:29
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CakeCategoryListVo {

    private int category_id;

    @Alias("createTime")
    private String create_time;

    private String image;

    private int image_id;

    private String name;

    @Alias("parentId")
    private int parent_id;

    @Alias("bannersRank")
    private int sort;

    private int status;

    private int store_id;

    @Alias("updateTime")
    private String update_time;


}
