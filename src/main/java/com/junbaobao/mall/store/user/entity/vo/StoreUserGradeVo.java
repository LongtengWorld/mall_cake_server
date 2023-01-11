package com.junbaobao.mall.store.user.entity.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname StoreUserGradeVo
 * @Description
 * @Date: Created in 2022/9/26 22:10
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class StoreUserGradeVo {

    private  String create_time;

    private Map<String,Object> equity;

    private  int grade_id;


    private  int is_delete;


    private  String name;


    private  int status;


    private  int store_id;


    private Map<String,Object> upgrade;


    private  String update_time;


    private  int weight;



}
