package com.junbaobao.mall.store.entity.Vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;

/**
 * @Classname CakeStoreVo
 * @Description
 * @Date: Created in 2022/12/30 17:32
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class CakeStoreVo {

    @Alias("storeId")
    private int store_id;

    @Alias("describe")
    private String describe;

    private String image_url;

    private String logoImage;

    @Alias("logoImageId")
    private int logo_image_id;

    @Alias("storeName")
    private String store_name;


}
