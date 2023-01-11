package com.junbaobao.mall.api.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.user.entity.Do.CakeUserOauthDo;
import com.junbaobao.mall.api.user.mapper.CakeUserOauthMapper;
import com.junbaobao.mall.api.user.service.CakeUserOauthService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author junbaobao
 * @date 2023-01-03 22:49:44
 * @description 第三方用户信息表
 */
@Service
public class CakeUserOauthServiceImpl extends ServiceImpl<CakeUserOauthMapper, CakeUserOauthDo> implements CakeUserOauthService {


    @Resource
    private CakeUserOauthMapper cakeUserOauthMapper;

    @Override
    public CakeUserOauthDo getUserIdByOauthIdAndOauthType(String openId, String oauthType) {
        QueryWrapper<CakeUserOauthDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("oauth_id", openId);
        queryWrapper.eq("oauth_type", oauthType);
        return cakeUserOauthMapper.selectOne(queryWrapper);
    }

    @Override
    public int addUserOauth(CakeUserOauthDo cakeUserOauthDo) {
        return cakeUserOauthMapper.insert(cakeUserOauthDo);
    }

    @Override
    public CakeUserOauthDo getCakeUserOauthDoByUserId(int userId) {
        QueryWrapper<CakeUserOauthDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return cakeUserOauthMapper.selectOne(queryWrapper);
    }
}
