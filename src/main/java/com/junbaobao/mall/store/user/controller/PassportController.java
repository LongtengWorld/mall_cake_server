package com.junbaobao.mall.store.user.controller;

import com.junbaobao.mall.store.user.entity.dto.LoginDto;
import com.junbaobao.mall.store.user.entity.vo.LoginVo;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import com.junbaobao.mall.util.annotation.AllowAnonymous;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/store/passport")
@Slf4j
public class PassportController {

    @PostMapping("/login")
    @AllowAnonymous
    public StoreJsonResult<LoginVo> login(@RequestBody LoginDto loginDto){
        LoginVo loginVo  = new LoginVo();
        loginVo.setToken("e020d732f23be28f13b34456a208c281");
        loginVo.setUserId(1001);


        return Result.storeSuccess(loginVo, ResultCode.STORE_LOGIN_ACCESS);
    }

    @PostMapping("/logout")
    @AllowAnonymous
    public void logout(){


    }
}
