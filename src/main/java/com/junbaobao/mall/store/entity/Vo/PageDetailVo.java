package com.junbaobao.mall.store.entity.Vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Classname PageDetailVo
 * @Description
 * @Date: Created in 2022/12/27 15:45
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageDetailVo {
    private String create_time;

    private int is_delete;


    private JSONObject page_data;

    private int page_id;


    private String page_name;


    private int page_type;


    private int store_id;

    private String update_time;

}
