package com.wtf.codewarehouse.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: WTF
 * @Date: 2020/12/31 15:26
 */
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        RedisTemplate redisTemplate=new RedisTemplate();
        if(redisTemplate.hasKey("test")){
            System.out.println(redisTemplate.hasKey("test"));
            redisTemplate.delete("test");
        }
    }

}
