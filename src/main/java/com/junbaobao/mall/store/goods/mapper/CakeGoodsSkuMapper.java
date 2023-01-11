package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-07 22:19:16
 *
 * @description 商品规格表
 */
@Mapper
public interface CakeGoodsSkuMapper extends BaseMapper<CakeGoodsSkuDo> {


    List<CakeGoodsSkuDo> listGoodsSku(@Param("goodsId")int goodsId);




}

