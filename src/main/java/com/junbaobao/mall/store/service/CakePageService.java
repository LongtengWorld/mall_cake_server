package com.junbaobao.mall.store.service;

import com.alibaba.fastjson.JSONObject;
import com.junbaobao.mall.store.entity.Do.CakePageDo;
import com.junbaobao.mall.store.entity.Vo.PageDetailVo;
import com.junbaobao.mall.store.entity.Vo.defaultDataVo.PageDataVo;

import java.util.List;

/**
 * @author junbaobao
 * @date 2022-12-27 10:25:24
 *
 * @description 店铺页面记录表
 */
public interface CakePageService  {



    List<CakePageDo> getByPageByNamePageDo(int page,String name);


    /**
     * 获取页面模板数据
     * @return
     */
    JSONObject getPageDefaultData();


    /**
     * 根据pageId 获取详细
     * @param pageId
     * @return
     */
    PageDetailVo getPageDetail(int pageId);


    /**
     * 根据PageId修改内容
     * @param pageId
     * @param pageData
     * @return
     */
    int updPageById(int pageId,CakePageDo cakePageDo);


    /**
     * 新增
     * @param cakePageDo
     * @return
     */
    int addPage(CakePageDo cakePageDo);


    /**
     * 修改所有的Type为10的改成20
     * @return
     */
    int updPageTypeBy();
}

