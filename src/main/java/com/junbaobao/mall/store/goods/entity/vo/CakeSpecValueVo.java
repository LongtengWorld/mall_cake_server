package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * <p>
 * 商品规格值记录表
 * </p>
 *
 * @author junbaobao
 * @since 2022-09-25
 */
@Data
public class CakeSpecValueVo {

    private Integer groupKey;


    private int key;

    @Alias("specValue")
    private String spec_value;

    @Alias("specValueId")
    private Integer spec_value_id;




}
