package com.junbaobao.mall.store.user.controller;

import com.junbaobao.mall.store.user.entity.vo.StoreUserGradeVo;
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
 * @Classname StoreUserGradeController
 * @Description
 * @Date: Created in 2022/9/24 16:24
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/user.grade")
@Slf4j
public class StoreUserGradeController {

    @GetMapping("/all")
    public StoreJsonResult<Map<String,Object>> all(int status) {
        Map<String,Object> resultMap = new HashMap<>();
        List<StoreUserGradeVo> storeUserGradeVoList = new ArrayList<>();

        StoreUserGradeVo StoreUserGradeVo = new StoreUserGradeVo();
        StoreUserGradeVo.setCreate_time("2021-03-01 08:00:00");

        Map<String,Object> mapDiscount = new HashMap<>();
        mapDiscount.put("discount","9.8");
        StoreUserGradeVo.setEquity(mapDiscount);
        StoreUserGradeVo.setGrade_id(10001);
        StoreUserGradeVo.setIs_delete(0);
        StoreUserGradeVo.setName("黄金会员");
        StoreUserGradeVo.setUpdate_time("2021-03-01 08:00:00");
        Map<String,Object> mapUpgrade = new HashMap<>();
        mapUpgrade.put("expend_money","10000");
        StoreUserGradeVo.setUpgrade(mapUpgrade);
        StoreUserGradeVo.setWeight(1);
        StoreUserGradeVo StoreUserGradeVo2 = new StoreUserGradeVo();
        StoreUserGradeVo2.setCreate_time("2021-03-01 08:00:00");



        Map<String,Object> mapDiscount2 = new HashMap<>();
        mapDiscount2.put("discount","9.6");
        StoreUserGradeVo2.setEquity(mapDiscount);

        StoreUserGradeVo2.setGrade_id(10002);
        StoreUserGradeVo2.setIs_delete(0);
        StoreUserGradeVo2.setName("铂金会员");
        StoreUserGradeVo2.setUpdate_time("2021-03-01 08:00:00");
        Map<String,Object> mapUpgrade2 = new HashMap<>();
        mapUpgrade2.put("expend_money","20000");
        StoreUserGradeVo2.setUpgrade(mapUpgrade);
        StoreUserGradeVo2.setWeight(2);


        StoreUserGradeVo StoreUserGradeVo3 = new StoreUserGradeVo();
        StoreUserGradeVo.setCreate_time("2021-03-01 08:00:00");
        Map<String,Object> mapDiscount3 = new HashMap<>();
        mapDiscount3.put("discount","9.8");
        StoreUserGradeVo3.setEquity(mapDiscount);
        StoreUserGradeVo3.setGrade_id(10003);
        StoreUserGradeVo3.setIs_delete(0);
        StoreUserGradeVo3.setName("钻石会员");
        StoreUserGradeVo3.setUpdate_time("2021-03-01 08:00:00");
        Map<String,Object> mapUpgrade3 = new HashMap<>();
        mapUpgrade3.put("expend_money","30000");
        StoreUserGradeVo3.setUpgrade(mapUpgrade);
        StoreUserGradeVo3.setWeight(3);

        storeUserGradeVoList.add(StoreUserGradeVo);
        storeUserGradeVoList.add(StoreUserGradeVo2);
        storeUserGradeVoList.add(StoreUserGradeVo3);
        resultMap.put("list",storeUserGradeVoList);
        return Result.storeSuccess(resultMap, ResultCode.STORE_ACCESS);
    }
}
