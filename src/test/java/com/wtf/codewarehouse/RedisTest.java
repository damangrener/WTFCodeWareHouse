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
    }
}
