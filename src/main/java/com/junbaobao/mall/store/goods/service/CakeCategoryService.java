package com.junbaobao.mall.store.goods.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.junbaobao.mall.store.goods.entity.Do.CakeCategoryDo;

import java.util.List;

/**
 * @Classname CategoryService
 * @Description
 * @Date: Created in 2022/7/13 16:07
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public interface CakeCategoryService {


    /**
     * 获取分类list
     *
     * @return
     */
    List<CakeCategoryDo> getCategoryList();


    /**
     * 获取当前商品所属的分类ID
     * @param goodsId
     * @return
     */
    int[] getGoodsCategoryId(int goodsId);





}
