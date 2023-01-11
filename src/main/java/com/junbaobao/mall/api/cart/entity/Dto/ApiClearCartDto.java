package com.junbaobao.mall.api.cart.entity.Dto;

import lombok.Data;

/**
 * @Classname ApiClearCartDto
 * @Description
 * @Date: Created in 2023/1/5 15:56
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiClearCartDto {
    private Integer[] cartIds;
}
