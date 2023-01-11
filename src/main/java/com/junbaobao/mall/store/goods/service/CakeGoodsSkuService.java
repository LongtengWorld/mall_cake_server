package com.junbaobao.mall.store.goods.service;

import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import com.junbaobao.mall.store.goods.entity.dto.CakeGoodsSkuDto;
import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;

import java.util.List;

/**
 * @Classname CakeGoodsSkuService
 * @Description
 * @Date: Created in 2022/12/7 22:22
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public interface CakeGoodsSkuService {



    List<CakeStoreGoodsSkuVo>  listGoodsSku(int goodsId);


    /**
     * 修改sku的数据 删除新增操作 多规格
     * @param goodsId
     * @param storeId
     * @param skuDtoList
     */
    void updByGoodsId(int goodsId, int storeId, List<CakeGoodsSkuDto> skuDtoList, List<CakeSpecDto> specList);


    /**
     * 单规格 新增
     * @param cakeGoodsSkuDo
     */
    void addCakeGoodsSku(CakeGoodsSkuDo cakeGoodsSkuDo);




    CakeGoodsSkuDo getGoodsSkuDoByGoodsIdOrSkuId(String skuId,int goodsId,int specType);
}
