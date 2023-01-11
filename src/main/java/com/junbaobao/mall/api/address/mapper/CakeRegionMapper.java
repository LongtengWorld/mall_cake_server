package com.junbaobao.mall.api.address.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.address.entity.Do.CakeRegionDo;
import com.junbaobao.mall.api.address.entity.Vo.RegionCityVo;
import com.junbaobao.mall.api.address.entity.Vo.RegionTreeVo;
import com.junbaobao.mall.api.address.entity.Vo.RegionVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-09 22:40:29
 * @description 省市区数据表
 */
@Mapper
public interface CakeRegionMapper extends BaseMapper<CakeRegionDo> {


    @MapKey("id")
    Map<Integer, RegionTreeVo> getRegionTree(@Param("id") Integer id);


    @MapKey("id")
    Map<Integer, RegionCityVo> getRegionCity(@Param("id") Integer id);


    @MapKey("id")
    Map<Integer, RegionVo> getRegion(@Param("id") Integer id);
}

