package com.junbaobao.mall.store.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.entity.Do.CakeStoreSettingDo;
import com.junbaobao.mall.store.entity.Vo.defaultDataVo.PageDataVo;
import com.junbaobao.mall.store.mapper.CakeStoreSettingMapper;
import com.junbaobao.mall.store.service.CakeStoreSettingService;
import com.junbaobao.mall.util.FileUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Map;

/**
 * @author junbaobao
 * @date 2022-12-28 17:22:25
 * @description 商家设置记录表
 */
@Service
public class CakeStoreSettingServiceImpl extends ServiceImpl<CakeStoreSettingMapper, CakeStoreSettingDo> implements CakeStoreSettingService {


    @Resource
    CakeStoreSettingMapper cakeStoreSettingMapper;

    @Override
    public CakeStoreSettingDo getSettingDoByKey(String key) {
        QueryWrapper<CakeStoreSettingDo> cakeStoreSettingDoQueryWrapper = new QueryWrapper<>();
        cakeStoreSettingDoQueryWrapper.eq("`key`",key);



        return  cakeStoreSettingMapper.selectOne(cakeStoreSettingDoQueryWrapper);
    }

    @Override
    public int updSettingDoByKey(CakeStoreSettingDo cakeStoreSettingDo, String key) {
        QueryWrapper<CakeStoreSettingDo> cakeStoreSettingDoQueryWrapper = new QueryWrapper<>();
        cakeStoreSettingDoQueryWrapper.eq("`key`",key);
        return cakeStoreSettingMapper.update(cakeStoreSettingDo,cakeStoreSettingDoQueryWrapper);
    }

    @Override
    public Map<String,Object> getSettingDefaultData() {
        String json = "E:\\JavaProject\\mall_cake_server\\src\\main\\resources\\SettingDefaultData.json";
        File jsonFile = new File(json);
        //通过上面那个方法获取json文件的内容
        String jsonData = FileUtil.getStr(jsonFile);
        //转json对象
        return  (JSONObject) JSONObject.parse(jsonData);
    }
}
