package com.junbaobao.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Classname CakeAPPlication
 * @Description
 * @Date: Created in 2022/6/16 22:04
 * @Author Name:
 */
@SpringBootApplication
@EnableTransactionManagement
public class CakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CakeApplication.class, args);
    }

}
