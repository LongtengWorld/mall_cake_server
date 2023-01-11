package com.junbaobao.mall.store.goods.entity.dto.goodsAddDto;

import com.junbaobao.mall.store.goods.entity.dto.CakeGoodsSkuDto;
import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;
import lombok.Data;

import java.util.List;

/**
 * @Classname StoreGoodsEditFormSpecDataDto
 * @Description
 * @Date: Created in 2022/10/6 18:03
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class GoodsAddFormSpecDataDto {

    private List<CakeSpecDto> specList;


    private  List<CakeGoodsSkuDto> skuList;
}
