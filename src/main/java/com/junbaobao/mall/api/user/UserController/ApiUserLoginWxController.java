package com.junbaobao.mall.api.user.UserController;

import com.junbaobao.mall.api.user.entity.Dto.WxLoginMpMobileDto;
import com.junbaobao.mall.api.user.entity.Dto.WxUserLoginDto;
import com.junbaobao.mall.api.user.service.CakeUserService;
import com.junbaobao.mall.util.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Classname WxController
 * @Description
 * @Date: Created in 2023/1/3 22:00
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/passport")
@Slf4j
public class ApiUserLoginWxController {

    @Resource
    private CakeUserService cakeUserService;

    @Resource
    private RedisUtil redisUtil;

    @ApiOperation("wx登录获取user信息")
    @PostMapping("/loginMpWx")
    public StoreJsonResult<Map<String, Object>> loginMpWx(@RequestBody WxUserLoginDto wxUserLoginDto) {
        log.info("WxUserFormData{}", wxUserLoginDto.getForm());
        return cakeUserService.loginWx(wxUserLoginDto.getForm().getPartyData());
    }

    @ApiOperation("使用手机号进行登录")
    @PostMapping("/loginMpWxMobile")
    @Transactional
    public StoreJsonResult<Map<String, Object>> loginMpWxMobile(@RequestBody WxLoginMpMobileDto wxLoginMpMobileDto, @RequestHeader String platform) {
        log.info("WxUserFormData{}", wxLoginMpMobileDto);
        Map<String, Object> map = cakeUserService.loginMpWxMobile(wxLoginMpMobileDto.getForm(), platform);

        Integer userId = (Integer) map.get("userId");
        String token = SystemUtil.genToken(userId.toString());
        map.put("token",token);
        //缓存30天
        redisUtil.set(token,userId, 86400 * 30);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
