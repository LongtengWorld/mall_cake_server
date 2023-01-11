package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-11 15:00:10
 *
 * @description 商品规格组记录表
 */
@Mapper
public interface CakeSpecMapper extends BaseMapper<CakeSpecDo> {


    List<CakeSpecDo> getCakeSpecList(@Param("goodsId") int goodsId);

}

