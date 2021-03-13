package com.wtf.codewarehouse;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WTF
 * @Date: 2020/12/31 16:44
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test(){
        System.out.println("111");
//        if(redisTemplate.hasKey("test")){
//            System.out.println(redisTemplate.hasKey("test"));
//            redisTemplate.delete("test");
//        }

        //插入redis并存在文件夹中
//        redisTemplate.opsForValue().set("folder:key_01","kv放在指定文件夹中");
        System.out.println(redisTemplate.opsForValue().get("folder:key_01"));

        if(redisTemplate.hasKey("folder:key_01")){
            System.out.println(1);
        }

    }
}
