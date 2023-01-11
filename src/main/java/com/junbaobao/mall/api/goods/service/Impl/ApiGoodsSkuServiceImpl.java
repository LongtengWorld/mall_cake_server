package com.junbaobao.mall.api.goods.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.goods.entity.Vo.ApiCartGoodsSkuVo;
import com.junbaobao.mall.api.goods.service.ApiGoodsSkuService;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;
import com.junbaobao.mall.store.goods.entity.vo.GoodsPropsVo;
import com.junbaobao.mall.store.goods.mapper.CakeGoodsSkuMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname ApiGoodsSkuService
 * @Description
 * @Date: Created in 2023/1/5 15:27
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Service
public class ApiGoodsSkuServiceImpl extends ServiceImpl<CakeGoodsSkuMapper, CakeGoodsSkuDo> implements ApiGoodsSkuService {

    @Resource
    private CakeGoodsSkuMapper cakeGoodsSkuMapper;

    @Override
    public ApiCartGoodsSkuVo getGoodsSkuByGoodsIdAndSkuId(int goodsId, String skuId) {
        QueryWrapper<CakeGoodsSkuDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goodsId);
        queryWrapper.eq("goods_sku_id", skuId);
        CakeGoodsSkuDo cakeGoodsSkuDo = cakeGoodsSkuMapper.selectOne(queryWrapper);
        ApiCartGoodsSkuVo apiCartGoodsSkuVo = BeanUtil.toBean(cakeGoodsSkuDo, ApiCartGoodsSkuVo.class);

        if (ObjectUtil.isNotEmpty(cakeGoodsSkuDo.getSpecValueIds())){
            apiCartGoodsSkuVo.setSpec_value_ids(JSONUtil.toList(JSONUtil.parseArray(cakeGoodsSkuDo.getSpecValueIds()), Integer.class));
        }
        //单规格是不没有这个数据
        if (StrUtil.isNotEmpty(cakeGoodsSkuDo.getGoodsProps())){
            //设置goodsPropsVo字段
            apiCartGoodsSkuVo.setGoods_props( JSONUtil.toList(cakeGoodsSkuDo.getGoodsProps(), GoodsPropsVo.class));
        }
        return apiCartGoodsSkuVo;
    }
}
