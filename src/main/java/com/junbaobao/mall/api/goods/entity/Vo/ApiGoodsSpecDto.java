package com.junbaobao.mall.api.goods.entity.Vo;

import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreSpecVo;
import lombok.Data;

import java.util.List;

/**
 * @Classname ApiGoodsSpecDto
 * @Description
 * @Date: Created in 2023/1/5 12:20
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class ApiGoodsSpecDto {
    private List<CakeStoreGoodsSkuVo> skuList;

    private List<CakeStoreSpecVo> specList;
}
