package com.junbaobao.mall.store.goods.entity.vo;

import lombok.Data;

/**
 * @Classname GoodsProps
 * @Description
 * @Date: Created in 2022/8/31 21:08
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class GoodsPropsVo {


    /**
     * 当前商品分组
     */
    private GroupVo group;


    /**
     * 当前商品规格Value
     */
    private GroupVo value;

}
