package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import lombok.Data;

import java.util.List;

/**
 * @Classname StoreGoodsInfoVo
 * @Description
 * @Date: Created in 2022/9/24 11:02
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StoreGoodsInfoVo {

    private String[] alone_grade_equity;

    private String create_time;

    @Alias("deductStockType")
    private int deduct_stock_type;

    @Alias("deliveryId")
    private int delivery_id;

    @Alias("goodsId")
    private Integer goods_id;

    @Alias("goodsImages")
    private List<FileInfoVo> goods_images;

    private String goods_image;

    @Alias("goodsName")
    private String goods_name;

    @Alias("goodsNo")
    private String goods_no;

    @Alias("goodsPriceMax")
    private String goods_price_max;

    @Alias("goodsPriceMin")
    private String goods_price_min;

    @Alias("goodsSales")
    private int goods_sales;

    @Alias("isAloneGrade")
    private int is_alone_grade;

    @Alias("isAlonePointsDiscount")
    private int is_alone_points_discount;

    private int is_delete;

    @Alias("isEnableGrade")
    private int is_enable_grade;

    @Alias("isPointsDiscount")
    private int is_points_discount;

    @Alias("isPointsGift")
    private int is_points_gift;

    @Alias("linePriceMax")
    private String line_price_max;

    @Alias("linePriceMin")
    private String line_price_min;

    @Alias("pointsDiscountConfig")
    private String points_discount_config;

    @Alias("salesActual")
    private int sales_actual;

    @Alias("salesInitial")
    private int sales_initial;

    @Alias("sellingPoint")
    private String selling_point;

    private int sort;

    @Alias("specType")
    private int spec_type;

    private int status;

    @Alias("stockTotal")
    private int stock_total;

    @Alias("storeId")
    private int store_id;

    private  String update_time;


    private  int video_cover_id;

    private int video_id;


}
