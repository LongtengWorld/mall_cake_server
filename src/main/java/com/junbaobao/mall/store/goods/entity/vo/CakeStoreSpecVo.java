package com.junbaobao.mall.store.goods.entity.vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.util.List;


/**
 * <p>
 * 商品规格组记录表
 * </p>
 *
 * @author junbaobao
 * @since 2022-09-25
 */
@Data
public class CakeStoreSpecVo {




    private Integer key;

    @Alias("specName")
    private String spec_name;




    @Alias("specValueList")
    private List<CakeSpecValueVo> valueList;

    @Alias("specId")
    private Integer spec_id;
}
