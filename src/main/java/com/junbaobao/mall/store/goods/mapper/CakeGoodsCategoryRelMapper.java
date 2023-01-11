package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsCategoryRelDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junbaobao
 * @date 2022-12-18 14:49:26
 *
 * @description 商品与分类关系记录表
 */
@Mapper
public interface CakeGoodsCategoryRelMapper extends BaseMapper<CakeGoodsCategoryRelDo> {

}

