package com.junbaobao.mall.store.goods.service;


import com.alibaba.fastjson.JSONObject;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.store.goods.entity.vo.CakePageGoodsList;

import java.util.List;

/**
 * <p>
 * 商品记录表 服务类
 * </p>
 *
 * @author didiplus
 * @since 2022-09-24
 */
public interface CakeGoodsService {

    List<CakeGoodsDo> getGoodsList(Integer goodsId,String goodsName,int categoryId);


    /**
     * 修改商品信息
     * @param cakeGoodsDo
     * @return
     */
    CakeGoodsDo  updByIdGoods(CakeGoodsDo cakeGoodsDo);


    /**
     * 新增商品数据
     * @param cakeGoodsDo
     * @return
     */
    CakeGoodsDo addGoods(CakeGoodsDo cakeGoodsDo);


    /**
     * 删除商品数据
     */
    void delGoods(int[] goodsIds);


    /**
     * page页面获取商品
     * @param jsonObject
     */
    List<CakePageGoodsList> getPageGoodsList(JSONObject jsonObject);
}
