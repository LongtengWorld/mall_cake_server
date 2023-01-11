package com.junbaobao.mall.store.goods.entity.vo.searchGoodsListVo;

import com.junbaobao.mall.store.goods.entity.vo.StoreGoodsInfoVo;
import lombok.Data;

import java.util.List;

/**
 * @Classname SearchGoodsVO
 * @Description
 * @Date: Created in 2022/9/22 21:55
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class SearchGoodsVo {

    private int current_page;

    private List<StoreGoodsInfoVo> data;


    private int last_page;


    private int per_page;


    private int total;







}
