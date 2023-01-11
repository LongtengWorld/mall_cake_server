package com.junbaobao.mall.store.service;

import com.junbaobao.mall.store.entity.Do.CakeStoreDo;

/**
 * @author junbaobao
 * @date 2022-12-30 17:04:51
 *
 * @description 商家(商户)记录表
 */
public interface CakeStoreService {



    CakeStoreDo getByStoreId(int storeId);


}

