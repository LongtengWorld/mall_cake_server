package com.junbaobao.mall.api.goods.entity.Vo;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import lombok.Data;

import java.util.List;

/**
 * @Classname ApiCheckOutOrderGoodsInfoLIstVo
 * @Description
 * @Date: Created in 2023/1/8 15:15
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

public class ApiCheckOutOrderGoodsInfoLIstVo {

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

    private int status;

    private String goods_image;

    @Alias("goodsSales")
    private int goods_sales;

    private ApiCartGoodsSkuVo skuInfo;

    private String goods_price;

    private int total_num;

    private String goods_sku_id;

    private String total_price;


    private boolean is_user_grade;

    private int grade_ratio;

    private int grade_goods_price;

    private int grade_total_money;


    private int coupon_money;

    private int max_points_num;

    private int pointsNum;

    private int points_money;

    private String total_pay_price;

    private int expressPrice;

    private int points_bonus;

    private String[] alone_grade_equity;

    @Alias("goodsImages")
    private List<FileInfoVo> goods_images;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getVideo_cover_id() {
        return video_cover_id;
    }

    public void setVideo_cover_id(int video_cover_id) {
        this.video_cover_id = video_cover_id;
    }

    public String getSelling_point() {
        return selling_point;
    }

    public void setSelling_point(String selling_point) {
        this.selling_point = selling_point;
    }

    public int getSpec_type() {
        return spec_type;
    }

    public void setSpec_type(int spec_type) {
        this.spec_type = spec_type;
    }

    public String getGoods_price_min() {
        return goods_price_min;
    }

    public void setGoods_price_min(String goods_price_min) {
        this.goods_price_min = goods_price_min;
    }

    public String getGoods_price_max() {
        return goods_price_max;
    }

    public void setGoods_price_max(String goods_price_max) {
        this.goods_price_max = goods_price_max;
    }

    public String getLine_price_min() {
        return line_price_min;
    }

    public void setLine_price_min(String line_price_min) {
        this.line_price_min = line_price_min;
    }

    public String getLine_price_max() {
        return line_price_max;
    }

    public void setLine_price_max(String line_price_max) {
        this.line_price_max = line_price_max;
    }

    public int getStock_total() {
        return stock_total;
    }

    public void setStock_total(int stock_total) {
        this.stock_total = stock_total;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getIs_points_gift() {
        return is_points_gift;
    }

    public void setIs_points_gift(int is_points_gift) {
        this.is_points_gift = is_points_gift;
    }

    public int getIs_points_discount() {
        return is_points_discount;
    }

    public void setIs_points_discount(int is_points_discount) {
        this.is_points_discount = is_points_discount;
    }

    public int getIs_alone_points_discount() {
        return is_alone_points_discount;
    }

    public void setIs_alone_points_discount(int is_alone_points_discount) {
        this.is_alone_points_discount = is_alone_points_discount;
    }

    public String getPoints_discount_config() {
        return points_discount_config;
    }

    public void setPoints_discount_config(String points_discount_config) {
        this.points_discount_config = points_discount_config;
    }

    public int getIs_enable_grade() {
        return is_enable_grade;
    }

    public void setIs_enable_grade(int is_enable_grade) {
        this.is_enable_grade = is_enable_grade;
    }

    public int getIs_alone_grade() {
        return is_alone_grade;
    }

    public void setIs_alone_grade(int is_alone_grade) {
        this.is_alone_grade = is_alone_grade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public int getGoods_sales() {
        return goods_sales;
    }

    public void setGoods_sales(int goods_sales) {
        this.goods_sales = goods_sales;
    }

    public ApiCartGoodsSkuVo getSkuInfo() {
        return skuInfo;
    }

    public void setSkuInfo(ApiCartGoodsSkuVo skuInfo) {
        this.skuInfo = skuInfo;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public String getGoods_sku_id() {
        return goods_sku_id;
    }

    public void setGoods_sku_id(String goods_sku_id) {
        this.goods_sku_id = goods_sku_id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }


    @JsonProperty(value = "is_user_grade")
    public boolean isIs_user_grade() {
        return is_user_grade;
    }

    public void setIs_user_grade(boolean is_user_grade) {
        this.is_user_grade = is_user_grade;
    }

    public int getGrade_ratio() {
        return grade_ratio;
    }

    public void setGrade_ratio(int grade_ratio) {
        this.grade_ratio = grade_ratio;
    }

    public int getGrade_goods_price() {
        return grade_goods_price;
    }

    public void setGrade_goods_price(int grade_goods_price) {
        this.grade_goods_price = grade_goods_price;
    }

    public int getGrade_total_money() {
        return grade_total_money;
    }

    public void setGrade_total_money(int grade_total_money) {
        this.grade_total_money = grade_total_money;
    }

    public int getCoupon_money() {
        return coupon_money;
    }

    public void setCoupon_money(int coupon_money) {
        this.coupon_money = coupon_money;
    }

    public int getMax_points_num() {
        return max_points_num;
    }

    public void setMax_points_num(int max_points_num) {
        this.max_points_num = max_points_num;
    }

    public int getPointsNum() {
        return pointsNum;
    }

    public void setPointsNum(int pointsNum) {
        this.pointsNum = pointsNum;
    }

    public int getPoints_money() {
        return points_money;
    }

    public void setPoints_money(int points_money) {
        this.points_money = points_money;
    }

    public String getTotal_pay_price() {
        return total_pay_price;
    }

    public void setTotal_pay_price(String total_pay_price) {
        this.total_pay_price = total_pay_price;
    }

    public int getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(int expressPrice) {
        this.expressPrice = expressPrice;
    }

    public int getPoints_bonus() {
        return points_bonus;
    }

    public void setPoints_bonus(int points_bonus) {
        this.points_bonus = points_bonus;
    }

    public String[] getAlone_grade_equity() {
        return alone_grade_equity;
    }

    public void setAlone_grade_equity(String[] alone_grade_equity) {
        this.alone_grade_equity = alone_grade_equity;
    }

    public List<FileInfoVo> getGoods_images() {
        return goods_images;
    }

    public void setGoods_images(List<FileInfoVo> goods_images) {
        this.goods_images = goods_images;
    }
}
