package com.junbaobao.mall.api.user.UserController;

import com.junbaobao.mall.api.user.entity.Dto.WxUserLoginDto;
import com.junbaobao.mall.api.user.entity.Vo.UserAssetsVo;
import com.junbaobao.mall.api.user.service.CakeUserService;
import com.junbaobao.mall.util.RedisUtil;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ApiUserController
 * @Description
 * @Date: Created in 2023/1/4 16:40
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api/user")
@Slf4j
public class ApiUserController {
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private CakeUserService cakeUserService;

    @ApiOperation("wx登录获取user信息")
    @GetMapping("/info")
    public StoreJsonResult<Map<String, Object>> loginMpWx(@RequestHeader(value = "Access-Token") String accessToken) {
        log.info("Token{}", accessToken);
        Map<String, Object> map = new HashMap<>();
        Integer userId = (Integer) redisUtil.get(accessToken);

        map.put("userInfo", cakeUserService.getUserDoByUserId(userId));
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    //assets
    @ApiOperation("user资产")
    @GetMapping("/assets")
    public StoreJsonResult<Map<String, Object>> getUserAssets() {
        Map<String, Object> map = new HashMap<>();
        UserAssetsVo userAssetsVo = new UserAssetsVo();
        userAssetsVo.setBalance("0.00");
        userAssetsVo.setCoupon(0);
        userAssetsVo.setPoints(0);
        map.put("assets",userAssetsVo);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

}
