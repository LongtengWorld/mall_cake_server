package com.junbaobao.mall.store.goods.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSpecRelDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecValueDo;
import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;
import com.junbaobao.mall.store.goods.entity.dto.goodsEditDto.CakeSpecValueDto;
import com.junbaobao.mall.store.goods.mapper.CakeGoodsSpecRelMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsSpecRelService;
import com.junbaobao.mall.store.goods.service.CakeSpecService;
import com.junbaobao.mall.store.goods.service.CakeSpecValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-24 17:14:11
 * @description 商品与规格值关系记录表
 */
@Service
public class CakeGoodsSpecRelServiceImpl extends ServiceImpl<CakeGoodsSpecRelMapper, CakeGoodsSpecRelDo> implements CakeGoodsSpecRelService {


    @Resource
    private CakeGoodsSpecRelMapper cakeGoodsSpecRelMapper;

    @Resource
    private CakeSpecService cakeSpecService;


    @Resource
    private CakeSpecValueService cakeSpecValueService;


    @Override
    public List<CakeSpecDto> updByGoodsId(int goodsId, int storeId, List<CakeSpecDto> specList) {
        //删除cake_store_goods_spec_rel表的数据
        QueryWrapper<CakeGoodsSpecRelDo> delByGoodsIdCakeGoodsSpecRel = new QueryWrapper<>();
        delByGoodsIdCakeGoodsSpecRel.eq("goods_id", goodsId);
        cakeGoodsSpecRelMapper.delete(delByGoodsIdCakeGoodsSpecRel);

        for (CakeSpecDto cakeStoreSpec : specList) {
            String specName = cakeStoreSpec.getSpec_name();
            CakeSpecDo getBySpecNameDo = cakeSpecService.getBySpecName(specName);

            Integer specId = null;
            Integer specValueId = null;
            if (ObjectUtil.isNotEmpty(getBySpecNameDo)) {
                specId = getBySpecNameDo.getSpecId();
            } else {
                CakeSpecDo cakeSpecDo = new CakeSpecDo();
                cakeSpecDo.setSpecName(specName);
                cakeSpecDo.setStoreId(storeId);
                cakeSpecService.addCakeSpec(cakeSpecDo);
                specId = cakeSpecDo.getSpecId();
            }
            cakeStoreSpec.setSpec_id(specId);

            for (CakeSpecValueDto specValueDto : cakeStoreSpec.getValueList()) {
                String specValue = specValueDto.getSpec_value();
                CakeSpecValueDo getByValueAndSpecIdDo = cakeSpecValueService.getByValueAndSpecId(specId, specValue);
                if (ObjectUtil.isNotEmpty(getByValueAndSpecIdDo)) {
                    specValueId = getByValueAndSpecIdDo.getSpecValueId();
                } else {
                    CakeSpecValueDo cakeSpecValueDo = new CakeSpecValueDo();
                    cakeSpecValueDo.setSpecValue(specValue);
                    cakeSpecValueDo.setStoreId(storeId);
                    cakeSpecValueDo.setSpecId(specId);
                    cakeSpecValueService.addCakeSpecValue(cakeSpecValueDo);
                    specValueId = cakeSpecValueDo.getSpecValueId();

                }
                //赋值给list 防止新增后面操作出现确实id的情况
                specValueDto.setSpec_value_id(specValueId);

                //新增CakeGoodsSpecRelDo
                CakeGoodsSpecRelDo cakeGoodsSpecRelDo = new CakeGoodsSpecRelDo();
                cakeGoodsSpecRelDo.setSpecId(specId);
                cakeGoodsSpecRelDo.setGoodsId(goodsId);
                cakeGoodsSpecRelDo.setSpecValueId(specValueId);
                cakeGoodsSpecRelDo.setStoreId(storeId);
                cakeGoodsSpecRelMapper.insert(cakeGoodsSpecRelDo);
            }


        }

        return specList;
    }
}
