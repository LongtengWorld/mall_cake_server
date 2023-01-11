package com.junbaobao.mall.util;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Classname SystemUtil
 * @Description
 * @Date: Created in 2023/1/4 15:58
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public class SystemUtil {
    static String TOKEN_SALT = "user_salt";

    public static String genToken(String src) {
        if (StrUtil.isEmpty(src)) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((TOKEN_SALT + src).getBytes());
            return new BigInteger(1, md5.digest()).toString(16);

        } catch (Exception e) {
            return null;
        }

    }

//    public static void main(String[] args) {
//        System.out.println(genToken("1"));
//    }

}
