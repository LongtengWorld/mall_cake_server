package com.junbaobao.mall.store.goods.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.goods.entity.Do.CakeCategoryDo;
import com.junbaobao.mall.store.goods.mapper.CakeCategoryMapper;
import com.junbaobao.mall.store.goods.service.CakeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Classname CategoryServiceImpl
 * @Description
 * @Date: Created in 2022/7/13 16:08
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Service
public class CakeCategoryServiceImpl extends ServiceImpl<CakeCategoryMapper, CakeCategoryDo> implements CakeCategoryService {

    @Resource
    private CakeCategoryMapper categoryMapper;

    @Override
    public List<CakeCategoryDo> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    @Override
    public int[] getGoodsCategoryId(int goodsId) {


        return categoryMapper.getGoodsCategoryId(goodsId);
    }


}
