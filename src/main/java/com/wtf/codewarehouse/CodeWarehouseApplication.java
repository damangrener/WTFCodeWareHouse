package com.wtf.codewarehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan(value = "com.wtf.codewarehouse.mysql.mapper")
@RefreshScope
public class CodeWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeWarehouseApplication.class, args);
    }

}
