package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

/**
 * @Classname PageParamsDataVo
 * @Description
 * @Date: Created in 2022/9/18 15:35
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageItemsDataVo {


    private String imgName;
    private String imgUrl;

    private PageLinkDataVo link;

    private String text;


    private int goods_id;
    private String goods_image;
    private String goods_name;
    private String goods_price_max;
    private String goods_price_min;
    private int goods_sales;
    private String line_price_max;
    private String line_price_min;
    private String selling_point;


    private  boolean is_default;

}
