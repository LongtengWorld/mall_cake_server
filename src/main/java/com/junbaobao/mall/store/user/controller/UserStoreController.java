package com.junbaobao.mall.store.user.controller;

import com.junbaobao.mall.store.user.entity.vo.RolesVo;
import com.junbaobao.mall.store.user.entity.vo.StoreUserInfoVo;
import com.junbaobao.mall.store.user.entity.vo.UserInfoVo;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PassportController
 * @Description
 * @Date: Created in 2022/9/19 21:10
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/store.user")
@Slf4j
public class UserStoreController {

    @GetMapping("/info")
    public StoreJsonResult<StoreUserInfoVo> info(){
        StoreUserInfoVo storeUserInfoVo = new StoreUserInfoVo();

        RolesVo rolesVo = new RolesVo();
        rolesVo.setIsSuper(1);
        rolesVo.setPermissions(null);
        storeUserInfoVo.setRoles(rolesVo);


        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setCreate_time("create_time");
        userInfoVo.setIs_delete(0);
        userInfoVo.setIs_super(1);
        userInfoVo.setReal_name("系统管理员");
        userInfoVo.setSort(100);
        userInfoVo.setStore_id(10001);
        userInfoVo.setStore_user_id(10001);
        userInfoVo.setUpdate_time("2021-03-01 08:00:00");
        userInfoVo.setUser_name("admin");
        storeUserInfoVo.setUserInfo(userInfoVo);

        return Result.storeSuccess(storeUserInfoVo, ResultCode.STORE_ACCESS);
    }
}
