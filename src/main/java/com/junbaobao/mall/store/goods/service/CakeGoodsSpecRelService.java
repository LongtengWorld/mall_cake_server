package com.junbaobao.mall.store.goods.service;


import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-24 17:14:11
 *
 * @description 商品与规格值关系记录表
 */
public interface CakeGoodsSpecRelService {




    List<CakeSpecDto> updByGoodsId(int goodsId,int storeId, List<CakeSpecDto> specList);


}

