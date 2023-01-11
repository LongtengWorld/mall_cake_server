package com.junbaobao.mall.store.goods.service;

import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreSpecVo;

import java.util.List;

/**
 * @Classname CakeSpecService
 * @Description
 * @Date: Created in 2022/12/11 14:55
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public interface CakeSpecService {


    List<CakeStoreSpecVo> getCakeSpecList(int goodsId);


    /**
     * 根据 specName 获取数据 判断当前name是否存在于db中  如果存在使用db中的specId
     * @param specName
     * @return
     */
    CakeSpecDo  getBySpecName(String specName);


    int addCakeSpec(CakeSpecDo cakeSpecDo);
}
