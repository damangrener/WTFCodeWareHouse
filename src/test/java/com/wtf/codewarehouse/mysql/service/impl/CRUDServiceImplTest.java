package com.wtf.codewarehouse.mysql.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.wtf.codewarehouse.mysql.po.User;
import com.wtf.codewarehouse.mysql.service.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
}