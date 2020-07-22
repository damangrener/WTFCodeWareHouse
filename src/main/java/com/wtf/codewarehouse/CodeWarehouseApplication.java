package com.wtf.codewarehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.wtf.codewarehouse.mysql.mapper")
public class CodeWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeWarehouseApplication.class, args);
    }

}
