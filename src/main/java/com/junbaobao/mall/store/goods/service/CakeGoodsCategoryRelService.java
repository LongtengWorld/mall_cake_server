package com.junbaobao.mall.store.goods.service;




/**
 * @author junbaobao
 * @date 2022-12-18 14:49:26
 *
 * @description 商品与分类关系记录表
 */
public interface CakeGoodsCategoryRelService {


    /**
     *  修改分类关联
     * @param goodsId
     * @param categoryIds
     * @return
     */
    void updByGoodsId(int goodsId,int[] categoryIds,int storeId);


}

