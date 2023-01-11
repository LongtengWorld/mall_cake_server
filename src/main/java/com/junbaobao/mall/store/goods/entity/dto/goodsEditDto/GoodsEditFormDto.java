package com.junbaobao.mall.store.goods.entity.dto.goodsEditDto;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.util.Map;

/**
 * @Classname StoreGoodsEditVo
 * @Description
 * @Date: Created in 2022/10/5 20:56
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class GoodsEditFormDto {


    private Map<String, Object> alone_grade_equity;

    private int[] categoryIds;

    private String content;


    @Alias("deductStockType")
    private int deduct_stock_type;

    @Alias("deliveryId")
    private int delivery_id;

    @Alias("goodsName")
    private String goods_name;

    @Alias("goodsNo")
    private String goods_no;


    private String goods_price;

    private double goods_weight;

    private int[] imagesIds;



    @Alias("isAloneGrade")
    private int is_alone_grade;

    @Alias("isEnableGrade")
    private int is_enable_grade;


    @Alias("isPointsDiscount")
    private int is_points_discount;

    @Alias("isPointsGift")
    private int is_points_gift;

    private String line_price;

    @Alias("salesInitial")
    private String sales_initial;


    @Alias("sellingPoint")
    private String selling_point;

    private int[] serviceIds;

    private int sort;

    private int spec_type;

    private int status;

    private int stock_num;


    @Alias("videoCoverId")
    private int video_cover_id;

    @Alias("videoId")
    private  int video_id;

    private GoodsEditFormSpecDataDto specData;



}
