package com.junbaobao.mall.api.user.service.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.api.user.entity.Do.CakeUserDo;
import com.junbaobao.mall.api.user.entity.Do.CakeUserOauthDo;
import com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobile.WxLoginMpMobileFormDto;
import com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobileDto;
import com.junbaobao.mall.api.user.entity.Dto.WxUserPartyDto;
import com.junbaobao.mall.api.user.entity.Vo.CurrentOauthVo;
import com.junbaobao.mall.api.user.entity.Vo.UserInfoVo;
import com.junbaobao.mall.api.user.mapper.CakeUserMapper;
import com.junbaobao.mall.api.user.service.CakeUserOauthService;
import com.junbaobao.mall.api.user.service.CakeUserService;
import com.junbaobao.mall.store.entity.Do.CakeStoreSettingDo;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.file.service.CakeFileService;
import com.junbaobao.mall.store.service.CakeStoreSettingService;
import com.junbaobao.mall.util.*;
import com.junbaobao.mall.util.enums.SettingEnum;
import com.junbaobao.mall.util.txyun.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author junbaobao
 * @date 2023-01-03 22:28:06
 * @description 用户记录表
 */
@Service
@Slf4j
public class CakeUserServiceImpl extends ServiceImpl<CakeUserMapper, CakeUserDo> implements CakeUserService {


    @Resource
    private CakeUserMapper cakeUserMapper;


    @Resource
    private WxMaService wxMaService;

    @Resource
    private CakeUserOauthService cakeUserOauthService;

    @Resource
    private CakeStoreSettingService cakeStoreSettingService;

    @Resource
    private FileUploadService fileUploadService;

    @Value("${myapplication.storage.txyun.bucket}")
    private String BlogBucketName;

    @Value("${myapplication.storage.txyun.baseUrl}")
    private String baseUrl;

    @Resource
    private CakeFileService cakeFileService;


    @Override
    public StoreJsonResult<Map<String, Object>> loginWx(WxUserPartyDto partyData) {
        WxMaJscode2SessionResult sessionInfo = null;
        Map<String, Object> map = new HashMap<>();
        try {
            //获取wxUser信息
            sessionInfo = wxMaService.getUserService().getSessionInfo(partyData.getCode());
            log.info("sessionInfo{}", sessionInfo);
            String openid = sessionInfo.getOpenid();
            //判断openId是否注册过
            CakeUserOauthDo userIdByOauthId = cakeUserOauthService.getUserIdByOauthIdAndOauthType(openid, "MP-WEIXIN");
            CakeUserDo cakeUserDo = null;

            if (ObjectUtil.isNotEmpty(userIdByOauthId)) {
                //获取用户信息
                QueryWrapper<CakeUserDo> getUserDataByUserId = new QueryWrapper<>();
                getUserDataByUserId.eq("user_id", userIdByOauthId.getUserId());
                cakeUserDo = cakeUserMapper.selectOne(getUserDataByUserId);
            }


            if (ObjectUtil.isNotEmpty(cakeUserDo)) {
                //TODO 如果当前User 不等空 修改数据 登录数据
                //如果当前User 不等空 修改数据
            }
            //根据后台设置的登录设置进行判断
            CakeStoreSettingDo cakeStoreSettingDo = cakeStoreSettingService.getSettingDoByKey(SettingEnum.REGISTER.getCode());
            JSONObject values = JSON.parseObject(cakeStoreSettingDo.getValues());
            String isForceBindMpweixin = values.getString("isForceBindMpweixin");
            if (StrUtil.isNotEmpty(isForceBindMpweixin)) {
                map.put("isBindMobile", true);
                return Result.storeSuccess(map, ResultCode.BINDING_MOBILE_NUMBERS);
            }
            //TODO 进行返回Token操作


        } catch (Exception e) {

        }
        return Result.storeSuccess(null, ResultCode.STORE_ACCESS);
    }

    @Override

    public Map<String, Object> loginMpWxMobile(WxLoginMpMobileFormDto wxLoginMpMobileFormDto, String platform) {
        int storeId = 10001;
        WxMaJscode2SessionResult sessionInfo = null;
        Map<String, Object> map = new HashMap<>();
        try {
            //头像URL
            String avatarUrl = wxLoginMpMobileFormDto.getPartyData().getUserInfo().getAvatarUrl();
            //获取sessionInfo信息
            sessionInfo = wxMaService.getUserService().getSessionInfo(wxLoginMpMobileFormDto.getCode());
            log.info("sessionInfo{}", sessionInfo);
            //获取phoneNoInfo信息
            WxMaPhoneNumberInfo phoneNoInfo = wxMaService.getUserService().getPhoneNoInfo(sessionInfo.getSessionKey(), wxLoginMpMobileFormDto.getEncryptedData(), wxLoginMpMobileFormDto.getIv());

            WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionInfo.getSessionKey(), wxLoginMpMobileFormDto.getEncryptedData(), wxLoginMpMobileFormDto.getIv());
            //根据手机号查询 当前是否存在 如果存在进行更新 反之则进行install
            //手机号码
            String phoneNumber = phoneNoInfo.getPhoneNumber();
            //openId
            String openid = userInfo.getOpenId();
            //unionId 用来公众号或者其他的程序
            String unionId = userInfo.getUnionId();
            //获取用户信息
            QueryWrapper<CakeUserDo> getUserDataByUserId = new QueryWrapper<>();
            getUserDataByUserId.eq("mobile", phoneNumber);
            CakeUserDo getUserDoByMobile = cakeUserMapper.selectOne(getUserDataByUserId);

            //上传头像
            String fileName = "avatar_" + UUID.randomUUID() + ".png";
            String filePath = storeId + "/" + DateUtil.getDate() + "/" + fileName;
            fileUploadService.uploadFileByUrl(avatarUrl, BlogBucketName, filePath);
            CakeUploadFileDo cakeUploadFileDo = new CakeUploadFileDo();
            cakeUploadFileDo.setChannel(20);
            cakeUploadFileDo.setStorage("qcloud");
            cakeUploadFileDo.setDomain(baseUrl);
            cakeUploadFileDo.setFileType(10);
            cakeUploadFileDo.setFileName(fileName);
            cakeUploadFileDo.setFilePath(filePath);
            cakeUploadFileDo.setFileExt("png");
            cakeFileService.addFileDo(cakeUploadFileDo);

            if (ObjectUtil.isNotEmpty(getUserDoByMobile)) {
                //TODO 更新user信息 然后返回 Token 和UserId
                CakeUserDo CakeUserDo = BeanUtil.toBean(wxLoginMpMobileFormDto.getPartyData().getUserInfo(), CakeUserDo.class);
                CakeUserDo.setUserId(getUserDoByMobile.getUserId());
                CakeUserDo.setMobile(phoneNumber);
                CakeUserDo.setPlatform(platform);
                CakeUserDo.setStoreId(storeId);
                CakeUserDo.setAvatarId(cakeUploadFileDo.getFileId());
                cakeUserMapper.updateById(CakeUserDo);

                map.put("userId", getUserDoByMobile.getUserId());
                return map;
            }

            //TODO 修改上传User用户头像
            CakeUserDo cakeUserDo = BeanUtil.toBean(wxLoginMpMobileFormDto.getPartyData().getUserInfo(), CakeUserDo.class);
            cakeUserDo.setMobile(phoneNumber);
            cakeUserDo.setPlatform(platform);
            cakeUserDo.setStoreId(storeId);
            cakeUserDo.setAvatarId(cakeUploadFileDo.getFileId());
            cakeUserMapper.insert(cakeUserDo);

            Integer userId = cakeUserDo.getUserId();
            //新增userAuth数据
            CakeUserOauthDo cakeUserOauthDo = new CakeUserOauthDo();
            cakeUserOauthDo.setUserId(userId);
            cakeUserOauthDo.setOauthType(platform);
            cakeUserOauthDo.setOauthId(openid);
            cakeUserOauthDo.setUnionid(unionId);
            //TODO 修改商城ID
            cakeUserOauthDo.setStoreId(storeId);
            cakeUserOauthService.addUserOauth(cakeUserOauthDo);

            log.info("userInfo{}", phoneNoInfo);
            map.put("userId", userId);
            return map;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public UserInfoVo getUserDoByUserId(int userId) {
        CakeUserDo cakeUserDo = cakeUserMapper.selectById(userId);
        UserInfoVo userInfoVo = BeanUtil.toBean(cakeUserDo, UserInfoVo.class);
        userInfoVo.setMobile(DesensitizedUtil.mobilePhone(userInfoVo.getMobile()));

        userInfoVo.setCurrentOauth(BeanUtil.toBean(cakeUserOauthService.getCakeUserOauthDoByUserId(userId), CurrentOauthVo.class));


        userInfoVo.setAvatar(BeanUtil.toBean(cakeFileService.getByFileIdUploadFileDo(cakeUserDo.getAvatarId()), FileInfoVo.class));
        log.info("userInfoVo{}", userInfoVo);

        return userInfoVo;
    }

    @Override
    public CakeUserDo getUserInfoByUserId(int userId) {
        return cakeUserMapper.selectById(userId);
    }

    @Override
    public int updUserDefaultAddress(int userId, int addressId) {
        CakeUserDo cakeUserDo = new CakeUserDo();
        cakeUserDo.setAddressId(addressId);
        cakeUserDo.setUserId(userId);
        return cakeUserMapper.updateById(cakeUserDo);
    }
}
