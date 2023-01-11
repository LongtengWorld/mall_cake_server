package com.junbaobao.mall.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.entity.Do.CakeStoreDo;
import com.junbaobao.mall.store.mapper.CakeStoreMapper;
import com.junbaobao.mall.store.service.CakeStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author junbaobao
 * @date 2022-12-30 17:04:51
 * @description 商家(商户)记录表
 */
@Service
public class CakeStoreServiceImpl extends ServiceImpl<CakeStoreMapper, CakeStoreDo> implements CakeStoreService {


    @Resource
    CakeStoreMapper cakeStoreMapper;

    @Override
    public CakeStoreDo getByStoreId(int storeId) {
        QueryWrapper<CakeStoreDo> query = new QueryWrapper<>();
        query.eq("store_id", storeId);
        return cakeStoreMapper.selectOne(query);
    }
}
