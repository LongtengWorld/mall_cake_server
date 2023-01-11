package com.junbaobao.mall.store.goods.entity.dto;

import cn.hutool.core.annotation.Alias;
import com.junbaobao.mall.store.goods.entity.dto.goodsEditDto.CakeSpecValueDto;
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
public class CakeSpecDto {




    private Integer key;

    @Alias("specName")
    private String spec_name;




    @Alias("specValueList")
    private List<CakeSpecValueDto> valueList;

    @Alias("specId")
    private Integer spec_id;
}
