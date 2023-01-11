package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品记录表 Mapper 接口
 * </p>
 *
 * @author junbaobao
 * @since 2022-09-24
 */
@Mapper
public interface CakeGoodsMapper extends BaseMapper<CakeGoodsDo> {

    List<CakeGoodsDo> getGoodsList(@Param("goodsId") int goodsId, @Param("goodsName") String goodsName, @Param("categoryId") int categoryId);


    List<CakeGoodsDo> getPageGoodsList(@Param("showNum") int showNum, @Param("goodsSort") String goodsSort, @Param("category") String category);

}
