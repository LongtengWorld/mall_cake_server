package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSpecRelDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junbaobao
 * @date 2022-12-24 17:14:11
 *
 * @description 商品与规格值关系记录表
 */
@Mapper
public interface CakeGoodsSpecRelMapper extends BaseMapper<CakeGoodsSpecRelDo> {

}

