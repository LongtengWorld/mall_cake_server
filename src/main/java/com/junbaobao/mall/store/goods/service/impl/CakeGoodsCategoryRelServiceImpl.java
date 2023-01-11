package com.junbaobao.mall.store.goods.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsCategoryRelDo;
import com.junbaobao.mall.store.goods.mapper.CakeGoodsCategoryRelMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsCategoryRelService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author junbaobao
 * @date 2022-12-18 14:49:26
 * @description 商品与分类关系记录表
 */
@Service
public class CakeGoodsCategoryRelServiceImpl extends ServiceImpl<CakeGoodsCategoryRelMapper, CakeGoodsCategoryRelDo> implements CakeGoodsCategoryRelService {


    @Resource
    CakeGoodsCategoryRelMapper cakeGoodsCategoryRelMapper;

    @Override
    public void updByGoodsId(int goodsId,int[] categoryIds,int storeId) {
        //删除当前goodsId的类型
        QueryWrapper<CakeGoodsCategoryRelDo> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id", goodsId);
        boolean remove = this.remove(wrapper);
        //新增当前goodsId的类型
        for (int categoryId : categoryIds) {
            CakeGoodsCategoryRelDo cakeStoreGoodsCategoryRelDo = new CakeGoodsCategoryRelDo();
            cakeStoreGoodsCategoryRelDo.setCategoryId(categoryId);
            cakeStoreGoodsCategoryRelDo.setGoodsId(goodsId);
            cakeStoreGoodsCategoryRelDo.setStoreId(storeId);
            this.save(cakeStoreGoodsCategoryRelDo);
        }
    }
}
