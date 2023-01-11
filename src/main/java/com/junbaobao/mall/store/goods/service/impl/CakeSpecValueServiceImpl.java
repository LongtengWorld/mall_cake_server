package com.junbaobao.mall.store.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSpecRelDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecValueDo;
import com.junbaobao.mall.store.goods.mapper.CakeSpecValueMapper;
import com.junbaobao.mall.store.goods.service.CakeSpecValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author junbaobao
 * @date 2022-12-11 15:34:46
 * @description 商品规格值记录表
 */
@Service
public class CakeSpecValueServiceImpl extends ServiceImpl<CakeSpecValueMapper, CakeSpecValueDo> implements CakeSpecValueService {


    @Resource
    CakeSpecValueMapper cakeSpecValueMapper;

    @Override
    public CakeSpecValueDo getByValueAndSpecId(int specId, String specName) {
        QueryWrapper<CakeSpecValueDo> getByValueAndSpecIdWrapper = new QueryWrapper<>();
        getByValueAndSpecIdWrapper.eq("spec_value", specName);
        getByValueAndSpecIdWrapper.eq("spec_id", specId);
        return cakeSpecValueMapper.selectOne(getByValueAndSpecIdWrapper);
    }

    @Override
    public int addCakeSpecValue(CakeSpecValueDo cakeSpecValueDo) {
        return cakeSpecValueMapper.insert(cakeSpecValueDo);
    }


}
