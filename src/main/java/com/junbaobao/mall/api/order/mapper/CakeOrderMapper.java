package com.junbaobao.mall.api.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.api.order.entity.Do.CakeOrderDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junbaobao
 * @date 2023-01-08 14:54:54
 *
 * @description 订单记录表
 */
@Mapper
public interface CakeOrderMapper extends BaseMapper<CakeOrderDo> {

}

