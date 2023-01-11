package com.junbaobao.mall.store.file.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junbaobao.mall.store.file.entity.Do.CakeGoodsImageDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname CakeUploadFileMapper
 * @Description
 * @Date: Created in 2022/12/7 23:05
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

public interface CakeGoodsImageService{


    /**
     *  修改图片关联
     * @param goodsId
     * @param imageIds
     * @return
     */
    void updByGoodsId(int goodsId, int[] imageIds,int storeId);

}
