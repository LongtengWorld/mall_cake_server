package com.junbaobao.mall.store.goods.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import com.junbaobao.mall.store.file.mapper.CakeUploadFileMapper;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsDo;
import com.junbaobao.mall.store.goods.entity.vo.CakePageGoodsList;
import com.junbaobao.mall.store.goods.mapper.CakeGoodsMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品记录表 服务实现类
 * </p>
 *
 * @author junbaobao
 * @since 2022-09-24
 */
@Service
@Slf4j
public class CakeGoodsStoreServiceImpl extends ServiceImpl<CakeGoodsMapper, CakeGoodsDo> implements CakeGoodsService {

    @Resource
    private CakeGoodsMapper cakeGoodsMapper;


    @Resource
    private CakeUploadFileMapper cakeUploadFileMapper;

    @Override
    public List<CakeGoodsDo> getGoodsList(Integer goodsId,String goodsName,int categoryId) {
        return cakeGoodsMapper.getGoodsList(goodsId,goodsName,categoryId);
    }

    @Override
    public CakeGoodsDo updByIdGoods(CakeGoodsDo cakeGoodsDo) {

        if (this.updateById(cakeGoodsDo)) {
            return cakeGoodsMapper.selectById(cakeGoodsDo.getGoodsId());
        }
        return null;
    }

    @Override
    public CakeGoodsDo addGoods(CakeGoodsDo cakeGoodsDo) {
        if (cakeGoodsMapper.insert(cakeGoodsDo) > 0) {
            return cakeGoodsMapper.selectById(cakeGoodsDo.getGoodsId());
        }
        return null;
    }

    @Override
    public void delGoods(int[] goodsIds) {
        for (int goodsId : goodsIds) {
            cakeGoodsMapper.deleteById(goodsId);
        }


    }

    @Override
    public List<CakePageGoodsList> getPageGoodsList(JSONObject jsonObject) {
        log.info("jsonObject{}", jsonObject);

        String source = jsonObject.getJSONObject("params").getString("source");
        if (StrUtil.equals(source, "choice")) {
            //手动选择数据
            return jsonObject.getJSONArray("data").toJavaList(CakePageGoodsList.class);
        } else {
            //自动选择数据
            //显示条数
            Integer showNum = jsonObject.getJSONObject("params").getJSONObject("auto").getInteger("showNum");
            //排序
            String goodsSort = jsonObject.getJSONObject("params").getJSONObject("auto").getString("goodsSort");
            //分类
            String category = jsonObject.getJSONObject("params").getJSONObject("auto").getString("category");

            List<CakeGoodsDo> pageGoodsList = cakeGoodsMapper.getPageGoodsList(showNum, goodsSort, category);

            List<CakePageGoodsList> cakePageGoodsLists = BeanUtil.copyToList(pageGoodsList, CakePageGoodsList.class);


            for (CakePageGoodsList cakePageGoodsList : cakePageGoodsLists) {
                List<CakeUploadFileDo> goodsFileDo = cakeUploadFileMapper.getByGoodsId(cakePageGoodsList.getGoods_id());
                if (ObjectUtil.isNotEmpty(goodsFileDo)) {
                    cakePageGoodsList.setGoods_image(goodsFileDo.get(0).getPreviewUrl());
                }
            }
            return cakePageGoodsLists;
        }
    }


}
