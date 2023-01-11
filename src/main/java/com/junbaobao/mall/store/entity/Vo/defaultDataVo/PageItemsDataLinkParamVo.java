package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

/**
 * @Classname PageItemsDataLinkParamVo
 * @Description
 * @Date: Created in 2022/9/18 15:48
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageItemsDataLinkParamVo {
    private String path;

    private  String url;

    private PageQueryDataVo pageQueryDataVo;
}
