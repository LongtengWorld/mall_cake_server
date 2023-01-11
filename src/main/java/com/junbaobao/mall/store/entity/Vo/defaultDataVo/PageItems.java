package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

import java.util.List;

/**
 * @Classname PageItems
 * @Description
 * @Date: Created in 2022/9/18 15:09
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageItems {

    private String name;

    private PageParamsVo params;

    private PageStyleVo style;


    private String type;

    private List<PageItemsDataVo> data;

    private List<PageItemsDefaultDataVo> defaultData;
}
