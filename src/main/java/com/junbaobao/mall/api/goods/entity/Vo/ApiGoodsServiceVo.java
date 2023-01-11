package com.junbaobao.mall.api.goods.entity.Vo;

import lombok.Data;

/**
 * @Classname StoreGoodsServiceVo
 * @Description
 * @Date: Created in 2023/1/3 17:47
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiGoodsServiceVo {
    private String create_time;

    private int is_default;

    private int is_delete;
    private String name;

    private int service_id;

    private int sort;
    private int status;
    private int store_id;
    private String summary;
    private String update_time;
}
