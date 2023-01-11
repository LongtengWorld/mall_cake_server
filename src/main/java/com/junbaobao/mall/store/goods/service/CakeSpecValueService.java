package com.junbaobao.mall.store.goods.service;


import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecValueDo;

/**
 * @author junbaobao
 * @date 2022-12-11 15:34:46
 *
 * @description 商品规格值记录表
 */
public interface CakeSpecValueService {


    /**
     * 根据specId And specName 查询 是否存在数据 如果存在取 specValueId
     * @param specId
     * @param specName
     * @return
     */
    CakeSpecValueDo getByValueAndSpecId(int specId,String specName);


    int addCakeSpecValue(CakeSpecValueDo cakeSpecValueDo);
}

