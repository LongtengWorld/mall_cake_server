package com.junbaobao.mall.util;

import cn.hutool.core.util.StrUtil;
import io.netty.util.internal.StringUtil;

/**
 * @Classname StringArrayUtils String工具类
 * @Description
 * @Date: Created in 2022/12/25 16:44
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public class StringArrayUtils {


    /**
     * 在二维数组中查找指定值
     *
     * @param arrays    arrays 二维数组
     * @param searchIdx searchIdx 查找的索引
     * @param searchVal searchVal 查找的值
     * @return bool|mixed
     */
    public static String find(String[] arrays, int searchIdx, String searchVal) {
        for (String array : arrays) {
            if (StrUtil.equals(arrays[searchIdx], searchVal)) {
                return array;
            }
        }
        return "";
    }

}
