package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Classname pageData
 * @Description
 * @Date: Created in 2022/9/18 15:05
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageDataVo {


    private pageVo page;

    private Map<String,PageItems> items;
}
