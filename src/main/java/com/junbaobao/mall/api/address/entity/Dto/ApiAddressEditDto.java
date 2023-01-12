package com.junbaobao.mall.api.address.entity.Dto;

import lombok.Data;

/**
 * @Classname ApiAddressEditDto
 * @Description
 * @Date: Created in 2023/1/12 21:49
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiAddressEditDto {
    private String addressId;
    private ApiAddressFormDto form;
}
