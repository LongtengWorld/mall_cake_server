package com.junbaobao.mall.api.address.entity.Vo;

import io.lettuce.core.dynamic.annotation.Key;
import lombok.Data;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @Classname RegionVo
 * @Description
 * @Date: Created in 2023/1/9 22:43
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class RegionTreeVo {

    private int id;
    private int level;
    private String name;
    private int pid;



    private Map<Integer,RegionCityVo> city;
}
