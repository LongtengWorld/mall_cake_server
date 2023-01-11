package com.junbaobao.mall.store.goods.entity.dto;

import com.junbaobao.mall.store.goods.entity.dto.goodsEditDto.GoodsEditFormDto;
import lombok.Data;

/**
 * @Classname StoreGoodsEditVo
 * @Description
 * @Date: Created in 2022/10/5 21:11
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class GoodsEditDto {
    private GoodsEditFormDto form;

    private  int goodsId;
}
