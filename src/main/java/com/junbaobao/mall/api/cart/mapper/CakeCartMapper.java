package com.junbaobao.mall.api.cart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.cart.entity.Do.CakeCartDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author junbaobao
 * @date 2023-01-05 11:15:58
 *
 * @description 购物车记录表
 */
@Mapper
public interface CakeCartMapper extends BaseMapper<CakeCartDo> {

    CakeCartDo getUserCartDoByGoodsIdAndGoodsSkuId(@Param("goodsId") int goodsId,@Param("goodsSkuId") String goodsSkuId);

    Integer countUserGoodsNumByUserId(@Param("userId") int userId);
}

