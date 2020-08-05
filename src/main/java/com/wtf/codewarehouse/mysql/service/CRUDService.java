package com.wtf.codewarehouse.mysql.service;

import com.github.pagehelper.PageInfo;
import com.wtf.codewarehouse.mysql.po.User;

import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/7/22 9:55
 */
public interface CRUDService {

    /**
     * 新增
     * @param user
     * @return
     */
    int insertBySelective(User user);

    /**
     * 批量新增
     * @return
     */
    int batchInsert(List<User> users);

    /**
     * 批量新增，有则更新，无则新增
     * 判断的条件必须是表重主键或者unique的
     * @param users
     * @return
     */
    int batchInsertOrUpdate(List<User> users);

    /**
     * 条件查询
     * @return
     */
    PageInfo selectBySelective(Integer pageNum, Integer pageSize);

    int updateBySelective();

    int getMaxId();
}
