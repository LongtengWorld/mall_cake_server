package com.junbaobao.mall.store.goods.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.goods.entity.Do.CakeGoodsSpecRelDo;
import com.junbaobao.mall.store.goods.entity.Do.CakeSpecDo;
import com.junbaobao.mall.store.goods.entity.vo.CakeSpecValueVo;
import com.junbaobao.mall.store.goods.entity.vo.CakeStoreSpecVo;
import com.junbaobao.mall.store.goods.mapper.CakeSpecMapper;
import com.junbaobao.mall.store.goods.service.CakeGoodsService;
import com.junbaobao.mall.store.goods.service.CakeSpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname CakeSpecServiceImpl
 * @Description
 * @Date: Created in 2022/12/11 14:56
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Service
public class CakeSpecServiceImpl extends ServiceImpl<CakeSpecMapper, CakeSpecDo> implements CakeSpecService {

    @Resource
    private  CakeSpecMapper cakeSpecMapper;
    @Override
    public  List<CakeStoreSpecVo> getCakeSpecList(int goodsId) {
        List<CakeSpecDo> cakeSpecList = cakeSpecMapper.getCakeSpecList(goodsId);

        List<CakeStoreSpecVo> cakeStoreSpecVoList = BeanUtil.copyToList(cakeSpecList, CakeStoreSpecVo.class);

        for (int i = 0; i < cakeStoreSpecVoList.size(); i++) {
            CakeStoreSpecVo cakeStoreSpecVo = cakeStoreSpecVoList.get(i);
            cakeStoreSpecVo.setKey(i);

            List<CakeSpecValueVo> cakeStoreSpecValueVoList = cakeStoreSpecVo.getValueList();
            for (int j = 0; j < cakeStoreSpecValueVoList.size(); j++) {
                CakeSpecValueVo cakeStoreSpecValueVo = cakeStoreSpecValueVoList.get(j);
                cakeStoreSpecValueVo.setGroupKey(i);
                cakeStoreSpecValueVo.setKey(j);
            }

        }

        return cakeStoreSpecVoList;
    }

    @Override
    public CakeSpecDo getBySpecName(String specName) {
        QueryWrapper<CakeSpecDo> getBySpecNameWrapper = new QueryWrapper<>();
        getBySpecNameWrapper.eq("spec_name", specName);
        List<CakeSpecDo> cakeSpecDoList = cakeSpecMapper.selectList(getBySpecNameWrapper);
        if(ObjectUtil.isNotEmpty(cakeSpecDoList)){
            return  cakeSpecDoList.get(0);
        }

        return  null;
    }

    @Override
    public int addCakeSpec(CakeSpecDo cakeSpecDo) {

        return cakeSpecMapper.insert(cakeSpecDo);
    }
}
