package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

/**
 * @Classname PageItemsDefaultDataVo
 * @Description
 * @Date: Created in 2022/12/27 15:07
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageItemsDefaultDataVo {

    private String image;

    private int show_type;

    private String title;

    private int views_num;


    private  String goods_image;

    private  String goods_name;

    private  String goods_price_min;

    private  double goods_sales;

    private  String line_price_min;

    private  String selling_point;
}
