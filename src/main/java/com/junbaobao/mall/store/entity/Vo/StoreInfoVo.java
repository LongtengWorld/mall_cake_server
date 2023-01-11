package com.junbaobao.mall.store.entity.Vo;

import lombok.Data;

/**
 * @Classname StoreInfoVo
 * @Description
 * @Date: Created in 2022/9/28 22:30
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StoreInfoVo {
    private String create_time;

    private String describe;

    private int is_delete;

    private int is_recycle;

    private String logoImage;

    private int logo_image_id;

    private int sort;

    private int store_id;

    private String store_name;

    private String update_time;

}
