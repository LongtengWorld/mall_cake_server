package com.junbaobao.mall.api.order.entity.Vo.CheckoutOrder;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.junbaobao.mall.api.address.entity.Vo.CakeUserAddressVo;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCheckOutOrderGoodsInfoLIstVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Classname CheckoutOrderVo
 * @Description
 * @Date: Created in 2023/1/7 10:40
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

public class CheckoutOrderVo {


    /**
     * goodsList : [{"goods_id":10007,"goods_name":"节日蛋糕211","goods_no":"1231221311123","video_id":10042,"video_cover_id":10051,"selling_point":"12321321321321","spec_type":20,"goods_price_min":"119.00","goods_price_max":"3123123.00","line_price_min":"12.00","line_price_max":"12321.00","stock_total":12327028,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_alone_points_discount":0,"points_discount_config":"","is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":[],"status":10,"goods_images":[{"file_id":10051,"group_id":0,"channel":10,"storage":"qcloud","domain":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com","file_type":10,"file_name":"1645452835(1).jpeg","file_path":"10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg","file_size":254789,"file_ext":"jpeg","cover":"","uploader_id":0,"is_recycle":0,"is_delete":0,"update_time":"2022-12-18 13:46:52","preview_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg","external_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg"},{"file_id":10050,"group_id":0,"channel":10,"storage":"qcloud","domain":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com","file_type":10,"file_name":"src=http___pic2.zhimg.com_v2-0726d82f1ec776c5805ffa9eade09644_1440w.jpg_source=172ae18b&refer=http___pic2.zhimg.JPG","file_path":"10001/20221218/8d14352e5f214f39971782e886c673fe.JPG","file_size":10744,"file_ext":"jpg","cover":"","uploader_id":0,"is_recycle":0,"is_delete":0,"update_time":"2022-12-18 13:46:45","preview_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/8d14352e5f214f39971782e886c673fe.JPG","external_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/8d14352e5f214f39971782e886c673fe.JPG"},{"file_id":10051,"group_id":0,"channel":10,"storage":"qcloud","domain":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com","file_type":10,"file_name":"1645452835(1).jpeg","file_path":"10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg","file_size":254789,"file_ext":"jpeg","cover":"","uploader_id":0,"is_recycle":0,"is_delete":0,"update_time":"2022-12-18 13:46:52","preview_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg","external_url":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg"}],"goods_image":"https://cake-image-1308182381.cos.ap-guangzhou.myqcloud.com/10001/20221218/09402030ad943356c9383a9fdbc963a4.jpeg","goods_sales":0,"skuInfo":{"id":10469,"goods_sku_id":"10069_10067","goods_id":10007,"image_id":10050,"goods_sku_no":"21","goods_price":"211.00","line_price":"321.00","stock_num":123,"goods_weight":12312,"goods_props":[{"group":{"name":"口味B1","id":10028},"value":{"name":"奶油2","id":10069}},{"group":{"name":"大小B","id":10027},"value":{"name":"测试","id":10067}}],"spec_value_ids":[10069,10067],"store_id":10001,"create_time":"2022-12-26 16:49:31","update_time":"2022-12-26 16:49:31"},"goods_price":"211.00","total_num":3,"goods_sku_id":"10069_10067","total_price":"633.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"coupon_money":0,"max_points_num":0,"pointsNum":0,"points_money":0,"total_pay_price":"633.00","expressPrice":0,"points_bonus":0}]
     * orderTotalNum : 3
     * couponList : []
     * hasError : false
     * errorMsg :
     * delivery : 10
     * address : {"address_id":10003,"name":"a","phone":"13027961340","province_id":1,"city_id":2,"region_id":3,"detail":"1232","user_id":10004,"region":{"province":"北京","city":"北京市","region":"东城区"}}
     * existAddress : true
     * expressPrice : 0.00
     * isIntraRegion : true
     * isAllowPoints : false
     * isUsePoints : 0
     * pointsMoney : 0
     * pointsBonus : 0
     * payType : 10
     * setting : {"deliveryType":[10],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;"}
     * orderTotalPrice : 633.00
     * couponId : 0
     * couponMoney : 0
     * orderPrice : 633.00
     * orderPayPrice : 633.00
     */

    private int orderTotalNum;

    private boolean hasError;

    private String errorMsg;

    private int delivery;

    private CakeUserAddressVo address;

    private boolean existAddress;

    private String expressPrice;


    private boolean isIntraRegion;

    @Alias("isAllowPoints")
    private boolean isAllowPoints;

    private String isUsePoints;

    private int pointsMoney;

    private int pointsBonus;


    private int payType;

    //private SettingVo setting;

    private String orderTotalPrice;

    private int couponId;

    private int couponMoney;

    private String orderPrice;

    private String orderPayPrice;

    private List<ApiCheckOutOrderGoodsInfoLIstVo> goodsList;

    //优惠价列表
    private List<Integer> couponList;


    public int getOrderTotalNum() {
        return orderTotalNum;
    }

    public void setOrderTotalNum(int orderTotalNum) {
        this.orderTotalNum = orderTotalNum;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public CakeUserAddressVo getAddress() {
        return address;
    }

    public void setAddress(CakeUserAddressVo address) {
        this.address = address;
    }

    public boolean isExistAddress() {
        return existAddress;
    }

    public void setExistAddress(boolean existAddress) {
        this.existAddress = existAddress;
    }

    public String getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(String expressPrice) {
        this.expressPrice = expressPrice;
    }

    @JsonProperty(value = "isIntraRegion")
    public boolean isIntraRegion() {
        return isIntraRegion;
    }

    public void setIntraRegion(boolean intraRegion) {
        isIntraRegion = intraRegion;
    }

    @JsonProperty(value = "isAllowPoints")
    public boolean isAllowPoints() {
        return isAllowPoints;
    }

    public void setIsAllowPoints(boolean allowPoints) {
        isAllowPoints = allowPoints;
    }


    public String getIsUsePoints() {
        return isUsePoints;
    }

    public void setIsUsePoints(String isUsePoints) {
        this.isUsePoints = isUsePoints;
    }

    public int getPointsMoney() {
        return pointsMoney;
    }

    public void setPointsMoney(int pointsMoney) {
        this.pointsMoney = pointsMoney;
    }

    public int getPointsBonus() {
        return pointsBonus;
    }

    public void setPointsBonus(int pointsBonus) {
        this.pointsBonus = pointsBonus;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(int couponMoney) {
        this.couponMoney = couponMoney;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPayPrice() {
        return orderPayPrice;
    }

    public void setOrderPayPrice(String orderPayPrice) {
        this.orderPayPrice = orderPayPrice;
    }

    public List<ApiCheckOutOrderGoodsInfoLIstVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ApiCheckOutOrderGoodsInfoLIstVo> goodsList) {
        this.goodsList = goodsList;
    }
}




