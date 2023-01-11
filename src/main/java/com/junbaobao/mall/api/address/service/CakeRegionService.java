package com.junbaobao.mall.api.address.service;

import com.junbaobao.mall.api.address.entity.Vo.RegionTreeVo;

import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-09 22:40:29
 *
 * @description 省市区数据表
 */
public interface CakeRegionService {

    Map<Integer, RegionTreeVo> getRegionTree();


}

