package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecValueDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-11 15:34:46
 *
 * @description 商品规格值记录表
 */
@Mapper
public interface CakeSpecValueMapper extends BaseMapper<CakeSpecValueDo> {


    List<CakeSpecValueDo> getCakeSpecValueList(@Param("specId") int specId,@Param("goodsId")int goodsId);

}

