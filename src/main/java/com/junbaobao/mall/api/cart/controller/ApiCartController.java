package com.junbaobao.mall.api.cart.controller;

import com.junbaobao.mall.api.cart.entity.Dto.AddUserCartDto;
import com.junbaobao.mall.api.cart.entity.Dto.ApiClearCartDto;
import com.junbaobao.mall.api.cart.service.CakeCartService;
import com.junbaobao.mall.util.RedisUtil;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ApiCartController
 * @Description
 * @Date: Created in 2023/1/3 17:36
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/cart")
@Slf4j
public class ApiCartController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private CakeCartService cakeCartService;

    /**
     * 获取购物车数量
     *
     * @return
     */
    @GetMapping("/total")
    public StoreJsonResult<Map<String, Object>> getUserCartTotal() {
        Map<String, Object> map = new HashMap<>();

        map.put("cartTotal", 0);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }


    @ApiOperation("新增购物车")
    @PostMapping("/add")
    @Transactional
    public StoreJsonResult<Map<String, Object>> addUserCart(@RequestHeader(value = "Access-Token") String accessToken, @RequestBody AddUserCartDto addUserCartDto) {
        log.info("Token{}", accessToken);
        Integer userId = (Integer) redisUtil.get(accessToken);
        int goodsNum = addUserCartDto.getGoodsNum();
        int goodsId = addUserCartDto.getGoodsId();
        String goodsSkuId = addUserCartDto.getGoodsSkuId();
        Map<String, Object> map = cakeCartService.addUserCart(goodsId, goodsSkuId, goodsNum, userId);

        return Result.storeSuccess(map, ResultCode.API_ADD_CART);
    }

    @ApiOperation("购物车List")
    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> getUserCartList(@RequestHeader(value = "Access-Token") String accessToken) {
        log.info("Token{}", accessToken);
        Integer userId = (Integer) redisUtil.get(accessToken);


        Map<String, Object> map = cakeCartService.getUserCartList(userId);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }

    @ApiOperation("修改购物车数量")
    @PostMapping("/update")
    @Transactional
    public StoreJsonResult<Map<String, Object>> userCartUpd(@RequestHeader(value = "Access-Token") String accessToken, @RequestBody AddUserCartDto addUserCartDto) {
        Integer userId = (Integer) redisUtil.get(accessToken);
        int goodsNum = addUserCartDto.getGoodsNum();
        int goodsId = addUserCartDto.getGoodsId();
        String goodsSkuId = addUserCartDto.getGoodsSkuId();
        Map<String, Object> map = cakeCartService.updUserCart(goodsId, goodsSkuId, goodsNum, userId);

        return Result.storeSuccess(map, ResultCode.API_ADD_CART);
    }

    @ApiOperation("删除购物车")
    @PostMapping("/clear")
    @Transactional
    public StoreJsonResult<Map<String, Object>> userClearCart(@RequestHeader(value = "Access-Token") String accessToken, @RequestBody ApiClearCartDto apiClearCartDto) {
        Integer userId = (Integer) redisUtil.get(accessToken);

        Map<String, Object> map = cakeCartService.userClearCart(apiClearCartDto.getCartIds(), userId);

        return Result.storeSuccess(map, ResultCode.STORE_UPDATE_ACCESS);
    }
}
