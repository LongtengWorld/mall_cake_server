package com.junbaobao.mall.store.entity.Vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname StorePageListVO
 * @Description
 * @Date: Created in 2022/12/27 10:41
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StorePageListVo {

    private  int current_page;


    private List<StorePageVo> data;


    private  int last_page;
    private  int per_page;
    private  int total;

}
