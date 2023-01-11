package com.junbaobao.mall.store.file.controller;

import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname StoreFilesGroupController
 * @Description
 * @Date: Created in 2022/10/22 15:13
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/files.group")
@Slf4j
public class FilesGroupController {

    @GetMapping("/list")
    public StoreJsonResult<Map<String,Object>> filesGroupList(){
        Map<String,Object> map = new HashMap<>();
        List<String> storeGoodsServiceVoList = new ArrayList<>();

        map.put("list",storeGoodsServiceVoList);
        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }
}
