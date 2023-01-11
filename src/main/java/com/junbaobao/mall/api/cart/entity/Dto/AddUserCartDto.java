package com.junbaobao.mall.api.cart.entity.Dto;

import lombok.Data;

/**
 * @Classname AddUserCartDto
 * @Description
 * @Date: Created in 2023/1/5 11:46
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class AddUserCartDto {
    private int goodsId;

    private int goodsNum;


    private String goodsSkuId;
}
