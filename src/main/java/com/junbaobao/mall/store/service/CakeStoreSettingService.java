package com.junbaobao.mall.store.service;

import com.junbaobao.mall.store.entity.Do.CakeStoreSettingDo;

import java.util.Map;

/**
 * @author junbaobao
 * @date 2022-12-28 17:22:25
 *
 * @description 商家设置记录表
 */
public interface CakeStoreSettingService {


    /**
     * 根据key获取对于的设置
     * @param key
     * @return
     */
    CakeStoreSettingDo getSettingDoByKey(String key);


    /**
     * 根据key修改对应配置
     * @param cakeStoreSettingDo
     * @param key
     * @return
     */
    int updSettingDoByKey(CakeStoreSettingDo cakeStoreSettingDo,String key);



    Map<String,Object> getSettingDefaultData();


}

