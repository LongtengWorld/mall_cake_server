package com.junbaobao.mall.store.entity.Vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Classname PageEditVo
 * @Description
 * @Date: Created in 2022/12/28 15:34
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageEditVo {
    private JSONObject form;

    private int pageId;
}
