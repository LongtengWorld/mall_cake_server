package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

import java.util.List;

/**
 * @Classname PageLinkDataVo
 * @Description
 * @Date: Created in 2022/9/18 15:41
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageLinkDataVo {
    private String id;

    private String title;

    private String type;

    private List<PageFormDataVo> pageFormDataVo;

    private PageItemsDataLinkParamVo pageItemsDataLinkParamVo;
}
