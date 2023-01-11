package com.junbaobao.mall.store.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.JsonObject;
import com.junbaobao.mall.store.entity.Do.CakePageDo;
import com.junbaobao.mall.store.entity.Vo.PageDetailVo;
import com.junbaobao.mall.store.entity.Vo.defaultDataVo.PageDataVo;
import com.junbaobao.mall.store.mapper.CakePageMapper;
import com.junbaobao.mall.store.service.CakePageService;
import com.junbaobao.mall.util.FileUtil;
import com.junbaobao.mall.util.enums.PageType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-27 10:25:24
 * @description 店铺页面记录表
 */
@Service
public class CakePageServiceImpl extends ServiceImpl<CakePageMapper, CakePageDo> implements CakePageService {


    @Resource
    private CakePageMapper cakePageMapper;

    @Override
    public List<CakePageDo> getByPageByNamePageDo(int page, String name) {
        QueryWrapper<CakePageDo> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotEmpty(name)) {
            queryWrapper.eq("page_name", name);
        }

        return cakePageMapper.selectList(queryWrapper);
    }

    @Override
    public JSONObject getPageDefaultData() {
        String json = "E:\\JavaProject\\mall_cake_server\\src\\main\\resources\\PageDefaultData.json";
        File jsonFile = new File(json);
        //通过上面那个方法获取json文件的内容
        String jsonData = FileUtil.getStr(jsonFile);
        //转json对象
        JSONObject parse = (JSONObject) JSONObject.parse(jsonData);
        //获取主要数据
        PageDataVo pageDataVo = parse.toJavaObject(PageDataVo.class);
        return parse;

    }

    @Override
    public PageDetailVo getPageDetail(int pageId) {
        CakePageDo cakePageDo = null;
        if (pageId > 0) {
            cakePageDo = cakePageMapper.selectById(pageId);
        } else {
            QueryWrapper<CakePageDo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("page_type", PageType.HOME.getValue());
            cakePageDo = cakePageMapper.selectOne(queryWrapper);
        }
        if (ObjectUtil.isNotEmpty(cakePageDo)) {
            PageDetailVo pageDetailVo = BeanUtil.toBean(cakePageDo, PageDetailVo.class);
            String pageData = cakePageDo.getPageData();
            JSONObject parse = (JSONObject) JSONObject.parse(pageData);
            pageDetailVo.setPage_data(parse);
            return pageDetailVo;
        }
        return null;
    }

    @Override
    public int updPageById(int pageId, CakePageDo cakePageDo) {
        QueryWrapper<CakePageDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("page_id", pageId);

        return cakePageMapper.update(cakePageDo,queryWrapper);
    }

    @Override
    public int addPage(CakePageDo cakePageDo) {
        return cakePageMapper.insert(cakePageDo);
    }

    @Override
    public int updPageTypeBy() {
        CakePageDo cakePageDo = new CakePageDo();
        cakePageDo.setPageType(20);
        QueryWrapper<CakePageDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("page_type", 10);

        return  cakePageMapper.update(cakePageDo,queryWrapper);
    }
}
