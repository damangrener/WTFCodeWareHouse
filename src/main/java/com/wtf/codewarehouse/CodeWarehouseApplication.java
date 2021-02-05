package com.wtf.codewarehouse;

import com.wtf.codewarehouse.spring.batch.democonsole.config.ConsoleBatchConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value = "com.wtf.codewarehouse.mysql.mapper")
@RefreshScope
public class CodeWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeWarehouseApplication.class, args);
    }

    @Bean
    public ConsoleBatchConfig config(){
        return new ConsoleBatchConfig();
    }


}
