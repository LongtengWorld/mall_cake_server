package com.junbaobao.mall.store.goods.entity.vo;

import lombok.Data;

/**
 * @Classname DeliveryVo
 * @Description
 * @Date: Created in 2022/9/27 21:04
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class DeliveryVo {
    private  String create_time;
    private  int delivery_id;
    private  int is_delete;
    private  int method;
    private  String name;
    private  int sort;
    private  int store_id;
    private  String update_time;
}
