package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import lombok.Data;

import java.util.List;

/**
 * @Classname StoreGoodsDetailInfoVo
 * @Description
 * @Date: Created in 2022/9/24 16:41
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StoreGoodsDetailInfoVo {

    @Alias("goodsId")
    private int goods_id;

    @Alias("goodsName")
    private String goods_name;

    @Alias("goodsNo")
    private String goods_no;

    @Alias("videoId")
    private int video_id;

    @Alias("videoCoverId")
    private int video_cover_id;


    @Alias("sellingPoint")
    private String selling_point;

    @Alias("specType")
    private int spec_type;

    @Alias("goodsPriceMin")
    private String goods_price_min;

    @Alias("goodsPriceMax")
    private String goods_price_max;

    @Alias("linePriceMin")
    private String line_price_min;

    @Alias("linePriceMax")
    private String line_price_max;

    @Alias("stockTotal")
    private int stock_total;

    @Alias("deductStockType")
    private int deduct_stock_type;

    private String content;

    @Alias("salesInitial")
    private String sales_initial;

    @Alias("salesActual")
    private String sales_actual;

    @Alias("deliveryId")
    private int delivery_id;

    @Alias("isPointsGift")
    private int is_points_gift;

    @Alias("isPointsDiscount")
    private int is_points_discount;

    @Alias("isAlonePointsDiscount")
    private int is_alone_points_discount;

    @Alias("pointsDiscountConfig")
    private String points_discount_config;

    @Alias("isEnableGrade")
    private int is_enable_grade;


    @Alias("isAloneGrade")
    private int is_alone_grade;


    private String[] alone_grade_equity;


    private int status;

    private int sort;





    @Alias("storeId")
    private int store_id;

    @Alias("createTime")
    private String create_time;


    @Alias("updateTime")
    private String update_time;

    @Alias("goodsImages")
    private List<FileInfoVo> goods_images;

    private String goods_image;

    private int goods_sales;


    private int[] categoryIds;


    private Boolean isSpecLocked;


    private  int is_delete;

    private  List<CakeStoreGoodsSkuVo> skuList;

    private  List<CakeStoreSpecVo> specList;

    private FileInfoVo video;


    private FileInfoVo videoCover;

    private int[] serviceIds;


}
