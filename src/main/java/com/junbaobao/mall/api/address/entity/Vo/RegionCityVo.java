package com.junbaobao.mall.api.address.entity.Vo;

import lombok.Data;

import java.util.Map;

/**
 * @Classname RegionCityVo
 * @Description
 * @Date: Created in 2023/1/9 22:52
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class RegionCityVo {
    private int id;
    private int level;
    private String name;
    private int pid;
    private Map<Integer,RegionVo>  region;


}
