package com.wtf.codewarehouse.mysql.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.wtf.codewarehouse.excel.DemoData;
import com.wtf.codewarehouse.excel.DemoDataListener;
import com.wtf.codewarehouse.mysql.po.User;
import com.wtf.codewarehouse.mysql.service.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.wtf.codewarehouse.java.CategoryConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangtengfei
 * @since 2020/7/22 14:53
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class CRUDServiceImplTest {

    @Autowired
    private CRUDService crudService;

    @Test
    void insertBySelective() {
        User user=new User();
        crudService.insertBySelective(user);
    }

    @Test
    void batchInsert() {
        List<User> users= Lists.newArrayListWithExpectedSize(5);
        crudService.batchInsert(users);
    }

    @Test
    void batchInsertOrUpdate(){
        List<User> users= Lists.newArrayListWithExpectedSize(5);
        crudService.batchInsertOrUpdate(users);
    }

    @Test
    void selectBySelective(){
        PageInfo pageInfo=crudService.selectBySelective(1,5);
        log.info("分页数据：{}",pageInfo);
    }

    @Test
    void updateBySelective(){
        crudService.updateBySelective();
    }

    @Test
    void getMaxId(){
        System.out.println(crudService.getMaxId());
    }

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test() throws InterruptedException {
//        String json="[\n" +
//                "        {\n" +
//                "            \"categoryCodePrev\":\"0103\",\n" +
//                "            \"categoryNamePrev\":\"高空设备\",\n" +
//                "            \"categoryCode\":\"010302\",\n" +
//                "            \"categoryName\":\"剪叉车\",\n" +
//                "            \"iconPath\":\"https://oss-znlhzl.oss-cn-shanghai.aliyuncs.com/pla/img/category/高空设备.png\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"categoryCodePrev\":\"0102\",\n" +
//                "            \"categoryNamePrev\":\"起重设备\",\n" +
//                "            \"categoryCode\":\"010201\",\n" +
//                "            \"categoryName\":\"汽车起重机\",\n" +
//                "            \"iconPath\":\"https://oss-znlhzl.oss-cn-shanghai.aliyuncs.com/pla/img/category/起重设备.png\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"categoryCodePrev\":\"0104\",\n" +
//                "            \"categoryNamePrev\":\"新增\",\n" +
//                "            \"categoryCode\":\"010401\",\n" +
//                "            \"categoryName\":\"新三级\",\n" +
//                "            \"iconPath\":\"https://oss-znlhzl.oss-cn-shanghai.aliyuncs.com/sit/1307945986081034240.jpg\"\n" +
//                "        }\n" +
//                "    ]";
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.opsForValue().set("categroy",json);
        System.out.println(redisTemplate.opsForValue().get("categroy"));
        List<CategoryConfig> jsonResult= JSONObject.parseArray(redisTemplate.opsForValue().get("categroy").toString(), CategoryConfig.class);
        jsonResult.forEach(x-> System.out.println(x));
//        if(redisTemplate.hasKey("test")){
//            System.out.println(redisTemplate.hasKey("test"));
//            redisTemplate.delete("test");
//        }

        //插入redis并存在文件夹中
//        redisTemplate.opsForValue().set("folder:key_01","kv放在指定文件夹中");
//        System.out.println(redisTemplate.opsForValue().get("folder:key_01"));
//        if(redisTemplate.hasKey("folder:key_01")){
//            System.out.println(1);
//        }

//        redisTemplate.boundValueOps("key_01").set("value_01");
//        redisTemplate.boundValueOps("key_02").set("value_02",10, TimeUnit.SECONDS);

//        redisTemplate.boundValueOps("key_03").set("value_03");
//        redisTemplate.boundValueOps("key_03").expire(10,TimeUnit.SECONDS);
//        redisTemplate.opsForValue().set("key_04","value_4",1,TimeUnit.SECONDS);
//        redisTemplate.opsForValue().get("folder:key_01");
//        redisTemplate.boundValueOps("folder:key_01").get();


//        redisTemplate.opsForValue().set("key_04","value_4",1,TimeUnit.SECONDS);
//        Thread.sleep(5000);
//        redisTemplate.delete("key_04");

//        redisTemplate.boundValueOps("key_05");
//        System.out.println(redisTemplate.boundValueOps("key_05").get());

//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.boundValueOps("key_07").set("2");
//        redisTemplate.boundValueOps("key_07").decrement(3L);
////        System.out.println(redisTemplate.getDefaultSerializer());
//        redisTemplate.opsForValue().decrement("key_07");
//        redisTemplate.setDefaultSerializer(new StringRedisSerializer());

//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("key_01","value_01");
//        hashMap.put("key_02","value_02");
//        hashMap.put("key_03","value_033");
//        hashMap.put("key_05","value_05");
//        redisTemplate.boundHashOps("HashMap").putAll(hashMap);
//        System.out.println(redisTemplate.boundHashOps("HashMap").entries().toString());

//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("id","user02");
//        hashMap.put("name","王贰飞");
//        hashMap.put("sex","1");
//        hashMap.put("age","23");
//        redisTemplate.boundHashOps("user:user02").putAll(hashMap);
//        System.out.println(redisTemplate.boundHashOps("user:user02").entries().toString());
//
//        HashMap<String, String> hashMap2 = new HashMap<>();
//        hashMap.put("id","user03");
//        hashMap.put("name","王3飞");
//        hashMap.put("sex","1");
//        hashMap.put("age","23");
//        redisTemplate.boundHashOps("user:user03").putAll(hashMap);
//        System.out.println(redisTemplate.boundHashOps("user").entries().toString());
//        System.out.println(redisTemplate.opsForValue().get("user"));
//        List<User> users=new ArrayList<>();
//        User user=new User();
//        user.setId(1);
//        user.setName("王一飞");
//        users.add(user);
//        User user1=new User();
//        user1.setId(2);
//        user1.setName("王2飞");
//        users.add(user1);
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////        redisTemplate.setValueSerializer(new StringRedisSerializer());
//       redisTemplate.opsForList().rightPushAll("userList",users);
//        System.out.println(redisTemplate.opsForList().leftPop("userList"));
//        System.out.println(redisTemplate.opsForList().range("userList",0,3));
//        redisTemplate.opsForHash().put();
//        Set keys1 = redisTemplate.boundHashOps("user:user02").keys();
//        keys1.forEach(x-> System.out.println(x.toString()));
//        redisTemplate.boundZSetOps("2021-01-05").add("user_01",99.19681686D);
//        redisTemplate.boundZSetOps("2021-01-05").add("user_02",86.19681686D);
//        redisTemplate.boundZSetOps("2021-01-05").add("user_03",97.19681686D);
//        redisTemplate.boundZSetOps("2021-01-05").add("user_04",0.19681686D);
//
//        Set<String> range = redisTemplate.boundZSetOps("2021-01-05").reverseRange( 0, 2);
//        range.forEach(x-> System.out.println(x.toString()));
//
//
//        Set<String> range1 = redisTemplate.boundZSetOps("2021-01-05").reverseRangeByScore( 97, 99);
//        range1.forEach(x-> System.out.println(x.toString()));

//        Long range2 = redisTemplate.boundZSetOps("2021-01-05").reverseRank("user_01");
//        System.out.println(range2);

//        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.boundZSetOps("2021-01-05").reverseRangeWithScores(0L, 100L);
//        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
//            System.out.println(tuple.getValue() + " : " + tuple.getScore());
//        }
    }

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "C:\\Users\\wangtengfei\\AppData\\Local\\kingsoft\\WPS Cloud Files\\userdata\\qing\\filecache\\1393641661的云文档" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

//        // 写法2：
//        fileName = "C:\\Users\\wangtengfei\\AppData\\Local\\kingsoft\\WPS Cloud Files\\userdata\\qing\\filecache\\1393641661的云文档" + "demo" + File.separator + "demo.xlsx";
//        ExcelReader excelReader = null;
//        try {
//            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            excelReader.read(readSheet);
//        } finally {
//            if (excelReader != null) {
//                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                excelReader.finish();
//            }
//        }
    }


    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job consoleJob;

    public void testJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        JobExecution run = jobLauncher.run(consoleJob, jobParameters);
        ExitStatus exitStatus=run.getExitStatus();
        log.debug(JSON.toJSONString(exitStatus));
    }
}