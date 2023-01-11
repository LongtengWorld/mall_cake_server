package com.junbaobao.mall.api.address.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.address.entity.Do.CakeRegionDo;
import com.junbaobao.mall.api.address.entity.Vo.RegionCityVo;
import com.junbaobao.mall.api.address.entity.Vo.RegionTreeVo;
import com.junbaobao.mall.api.address.entity.Vo.RegionVo;
import com.junbaobao.mall.api.address.mapper.CakeRegionMapper;
import com.junbaobao.mall.api.address.service.CakeRegionService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2023-01-09 22:40:29
 * @description 省市区数据表
 */
@Service
public class CakeRegionServiceImpl extends ServiceImpl<CakeRegionMapper, CakeRegionDo> implements CakeRegionService {


    @Resource
    private CakeRegionMapper cakeRegionMapper;

    @Override
    public  Map<Integer, RegionTreeVo> getRegionTree() {
        Map<Integer, RegionTreeVo> regionTreeMap = cakeRegionMapper.getRegionTree(0);

        for (Map.Entry<Integer, RegionTreeVo> entry : regionTreeMap.entrySet()) {
            Integer key = entry.getKey();
            RegionTreeVo treeVo = entry.getValue();
            Map<Integer, RegionCityVo> regionCity = cakeRegionMapper.getRegionCity(key);
            treeVo.setCity(regionCity);

            for (Map.Entry<Integer, RegionCityVo> city : regionCity.entrySet()) {
                Integer cityId = city.getKey();
                Map<Integer, RegionVo> region = cakeRegionMapper.getRegion(cityId);
                RegionCityVo cityVo = city.getValue();
                cityVo.setRegion(region);
            }

        }



        return regionTreeMap;
    }
}
