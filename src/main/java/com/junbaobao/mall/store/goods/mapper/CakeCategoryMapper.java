package com.junbaobao.mall.store.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeCategoryDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CategoryMapper
 * @Description
 * @Date: Created in 2022/7/13 16:07
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Mapper
public interface CakeCategoryMapper extends BaseMapper<CakeCategoryDo> {


    List<CakeCategoryDo> getCategoryList();


    int[] getGoodsCategoryId(@Param("goodsId") int goodsId);
}
