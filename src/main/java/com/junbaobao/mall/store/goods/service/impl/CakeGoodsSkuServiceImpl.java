package com.junbaobao.mall.store.goods.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.file.service.CakeFileService;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSkuDo;
import com.junbaobao.mall.store.goods.entity.dto.CakeGoodsSkuDto;
import com.junbaobao.mall.store.goods.entity.dto.CakeSpecDto;
import com.junbaobao.mall.store.goods.entity.dto.goodsEditDto.CakeSpecValueDto;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreGoodsSkuVo;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.goods.entity.vo.GoodsPropsVo;
import com.junbaobao.mall.store.goods.entity.vo.GroupVo;
import com.junbaobao.mall.store.goods.mapper.CakeGoodsSkuMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsSkuService;
import com.junbaobao.mall.util.enums.EventTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2022-12-07 22:19:16
 * @description 商品规格表
 */
@Slf4j
@Service
public class CakeGoodsSkuServiceImpl extends ServiceImpl<CakeGoodsSkuMapper, CakeGoodsSkuDo> implements CakeGoodsSkuService {


    @Resource
    private CakeGoodsSkuMapper cakeGoodsSkuMapper;


    @Resource
    private CakeFileService cakeFileService;


    @Override
    public List<CakeStoreGoodsSkuVo> listGoodsSku(int goodsId) {
        List<CakeGoodsSkuDo> cakeGoodsSkuDos = cakeGoodsSkuMapper.listGoodsSku(goodsId);
        List<CakeStoreGoodsSkuVo> cakeStoreGoodsSkuVos = new ArrayList<>();

        for (CakeGoodsSkuDo cakeGoodsSkuInfo : cakeGoodsSkuDos) {
            //设置skuVO
            CakeStoreGoodsSkuVo cakeStoreGoodsSkuVo = BeanUtil.toBean(cakeGoodsSkuInfo, CakeStoreGoodsSkuVo.class);

            //设置图片

            cakeStoreGoodsSkuVo.setImage(BeanUtil.toBean(cakeFileService.getByFileIdUploadFileDo(cakeGoodsSkuInfo.getImageId()), FileInfoVo.class));


            //单规格是不没有这个数据
            if (ObjectUtil.isNotEmpty(cakeGoodsSkuInfo.getSpecValueIds())) {
                cakeStoreGoodsSkuVo.setSpec_value_ids(JSONUtil.toList(JSONUtil.parseArray(cakeGoodsSkuInfo.getSpecValueIds()), Integer.class));
            }
            //单规格是不没有这个数据
            if (StrUtil.isNotEmpty(cakeGoodsSkuInfo.getGoodsProps())) {
                //设置goodsPropsVo字段
                cakeStoreGoodsSkuVo.setGoods_props(JSONUtil.toList(cakeGoodsSkuInfo.getGoodsProps(), GoodsPropsVo.class));
            }

            cakeStoreGoodsSkuVos.add(cakeStoreGoodsSkuVo);
        }


        return cakeStoreGoodsSkuVos;
    }

    @Override
    public void addCakeGoodsSku(CakeGoodsSkuDo cakeGoodsSkuDo) {
        //删除cake_goods_sku的数据
        QueryWrapper<CakeGoodsSkuDo> delByGoodsIdSkuWrapper = new QueryWrapper<>();
        delByGoodsIdSkuWrapper.eq("goods_id", cakeGoodsSkuDo.getGoodsId());
        cakeGoodsSkuMapper.delete(delByGoodsIdSkuWrapper);

        cakeGoodsSkuMapper.insert(cakeGoodsSkuDo);
    }

    @Override
    public CakeGoodsSkuDo getGoodsSkuDoByGoodsIdOrSkuId(String skuId, int goodsId, int specType) {
        CakeGoodsSkuDo cakeGoodsSkuDo = null;
        if (EventTypeEnum.SINGLE.getValue().intValue() == specType) {

            QueryWrapper<CakeGoodsSkuDo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", goodsId);
            cakeGoodsSkuDo = cakeGoodsSkuMapper.selectOne(queryWrapper);
        } else {
            QueryWrapper<CakeGoodsSkuDo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_id", goodsId);
            queryWrapper.eq("goods_sku_id", skuId);
            cakeGoodsSkuDo = cakeGoodsSkuMapper.selectOne(queryWrapper);
        }

        return cakeGoodsSkuDo;
    }

    @Override
    public void updByGoodsId(int goodsId, int storeId, List<CakeGoodsSkuDto> skuDtoList, List<CakeSpecDto> specList) {
        //删除cake_goods_sku的数据
        QueryWrapper<CakeGoodsSkuDo> delByGoodsIdSkuWrapper = new QueryWrapper<>();
        delByGoodsIdSkuWrapper.eq("goods_id", goodsId);
        cakeGoodsSkuMapper.delete(delByGoodsIdSkuWrapper);


        for (CakeGoodsSkuDto cakeStoreSkuDto : skuDtoList) {
            log.info("cakeStoreSku{}", cakeStoreSkuDto);


            CakeGoodsSkuDo cakeGoodsSkuDo = BeanUtil.toBean(cakeStoreSkuDto, CakeGoodsSkuDo.class);

            cakeGoodsSkuDo.setGoodsId(goodsId);
            cakeGoodsSkuDo.setStoreId(storeId);

            Map<String, Object> mapData = getSpecValueIds(specList, cakeStoreSkuDto.getSkuKeys());

            List<String> specValueIds = (List<String>) mapData.get("specValueIdsList");
            String specValueId = StringUtils.join(specValueIds, "_");
            cakeGoodsSkuDo.setGoodsSkuId(specValueId);
            cakeGoodsSkuDo.setSpecValueIds(JSONUtil.toJsonStr(specValueId.split("_")));

            List<GoodsPropsVo> goodsPropsVoList = (List<GoodsPropsVo>) mapData.get("goodsPropsVoList");
            cakeGoodsSkuDo.setGoodsProps(JSONUtil.toJsonStr(goodsPropsVoList));
            log.info("specValueIds{}", specValueId);
            cakeGoodsSkuMapper.insert(cakeGoodsSkuDo);
        }

    }


    public Map<String, Object> getSpecValueIds(List<CakeSpecDto> specList, List<Map<String, Integer>> skuKeys) {
        Map<String, Object> mapData = new HashMap<>();
        List<String> specValueIdsList = new ArrayList<>();
        List<GoodsPropsVo> goodsPropsVoList = new ArrayList<>();
        for (Map<String, Integer> skuKey : skuKeys) {
            GoodsPropsVo goodsPropsVo = new GoodsPropsVo();
            GroupVo group = new GroupVo();
            GroupVo value = new GroupVo();

            Integer groupKey = skuKey.get("groupKey");
            Integer valueKey = skuKey.get("valueKey");

            CakeSpecDto cakeSpecDto = null;
            //两个for判断条件需要同时满足
            for (CakeSpecDto specDto : specList) {
                if (specDto.getKey() == groupKey) {
                    cakeSpecDto = specDto;
                    group.setId(cakeSpecDto.getSpec_id());
                    group.setName(cakeSpecDto.getSpec_name());
                }
            }

            if (ObjectUtil.isNotEmpty(cakeSpecDto)) {
                List<CakeSpecValueDto> valueList = cakeSpecDto.getValueList();
                for (int i = 0; i < valueList.size(); i++) {
                    CakeSpecValueDto valueDto = valueList.get(i);
                    if (valueDto.getKey() == valueKey) {
                        specValueIdsList.add(valueDto.getSpec_value_id() + "");
                        value.setName(valueDto.getSpec_value());
                        value.setId(valueDto.getSpec_value_id());
                    }
                }

                goodsPropsVo.setValue(value);
                goodsPropsVo.setGroup(group);
                goodsPropsVoList.add(goodsPropsVo);
            }

        }

        mapData.put("specValueIdsList", specValueIdsList);
        mapData.put("goodsPropsVoList", goodsPropsVoList);
        return mapData;
    }

}
