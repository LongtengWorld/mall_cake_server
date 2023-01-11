package com.junbaobao.mall.api.category.entity;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Classname ApiCategoryListVo
 * @Description
 * @Date: Created in 2023/1/3 16:04
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiCategoryListVo {

    private int category_id;


    private String image;


    private int image_id;


    private String name;


    @Alias("parentId")
    private int parent_id;


    private int sort;

    private int status;
}
