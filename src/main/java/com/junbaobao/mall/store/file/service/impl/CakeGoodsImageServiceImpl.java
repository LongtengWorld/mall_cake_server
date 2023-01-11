package com.junbaobao.mall.store.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.file.entity.Do.CakeGoodsImageDo;
import com.junbaobao.mall.store.file.mapper.CakeGoodsImageMapper;
import com.junbaobao.mall.store.file.service.CakeGoodsImageService;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsCategoryRelDo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname CakeUploadFileServiceImpl
 * @Description
 * @Date: Created in 2022/12/7 23:04
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Service
public class CakeGoodsImageServiceImpl extends ServiceImpl<CakeGoodsImageMapper, CakeGoodsImageDo> implements CakeGoodsImageService {

    @Resource
    private CakeGoodsImageMapper cakeGoodsImageMapper;


    @Override
    public void updByGoodsId(int goodsId, int[] imageIds, int storeId) {
        //删除当前goodsId的类型
        QueryWrapper<CakeGoodsImageDo> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id", goodsId);
        boolean remove = this.remove(wrapper);
        //新增当前goodsId的类型
        for (int imageId : imageIds) {
            CakeGoodsImageDo cakeGoodsImageDo = new CakeGoodsImageDo();
            cakeGoodsImageDo.setImageId(imageId);
            cakeGoodsImageDo.setGoodsId(goodsId);
            cakeGoodsImageDo.setStoreId(storeId);
            this.save(cakeGoodsImageDo);
        }
    }
}
