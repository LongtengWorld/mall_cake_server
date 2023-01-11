package com.junbaobao.mall.api.comment.controller;

import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ApiCommentController
 * @Description
 * @Date: Created in 2023/1/3 18:01
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/comment")
@Slf4j
public class ApiCommentController {


    //TODO 需要修改
    @GetMapping("/listRows")
    public StoreJsonResult<Map<String,Object>> getGoodsCommentList(int goodsId) {
        Map<String,Object> map = new HashMap<>();
        map.put("list", null);
        map.put("total", 0);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
