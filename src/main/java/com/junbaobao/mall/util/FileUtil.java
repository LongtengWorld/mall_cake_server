package com.junbaobao.mall.util;

import java.io.*;

/**
 * @Classname FileUtil
 * @Description
 * @Date: Created in 2022/12/27 11:10
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public class FileUtil {

    //把一个文件中的内容读取成一个String字符串
    public static String getStr(File jsonFile){
        String jsonStr = "";
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
