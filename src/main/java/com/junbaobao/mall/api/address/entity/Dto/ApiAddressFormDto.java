package com.junbaobao.mall.api.address.entity.Dto;

import lombok.Data;

import java.util.List;

/**
 * @Classname ApiAddressForm
 * @Description
 * @Date: Created in 2023/1/12 21:50
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiAddressFormDto {
    private String detail;
    private String name;
    private String phone;


    private List<ApiAddressRegionDto> region;
}
