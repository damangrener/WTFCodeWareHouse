package com.wtf.codewarehouse.mysql.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wtf.codewarehouse.mysql.mapper.UserMapper;
import com.wtf.codewarehouse.mysql.po.User;
import com.wtf.codewarehouse.mysql.po.UserExample;
import com.wtf.codewarehouse.mysql.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/7/22 9:56
 */
@Service
/**
 * @RequiredArgsConstructor
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CRUDServiceImpl implements CRUDService {

    private final UserMapper userMapper;

    @Override
    public int insertBySelective(User user) {
        user.setName("WTF");
        user.setAccount("TF-002");
//        user.setAge(21);
        return userMapper.insertSelective(user);
    }

    @Override
    public int batchInsert(List<User> users) {
        for (int i = 0; i < 5; i++) {
            User user=new User();
            user.setAge(i);
            user.setName("WTF_"+i);
            user.setAccount("TF-"+i);
            users.add(user);
        }
        return userMapper.batchInsert(users);
    }

    @Override
    public int batchInsertOrUpdate(List<User> users) {
        for (int i = 0; i < 5; i++) {
            User user=new User();
            user.setAge(i+2);
            user.setName("WTF_-_"+i);
            user.setAccount("TF-"+i);
            users.add(user);
        }
        return userMapper.batchInsertOrUpdate(users);
    }

    /**
     * PageHelper只对PageHelper.startPage下的第一条sql生效
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return 分页对象
     */
    @Override
    public PageInfo<User> selectBySelective(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample example=new UserExample();
        example.createCriteria().andNameLike(likeStr("T"));
        List<User> users=userMapper.selectByExample(example);
        return new PageInfo<>(users);
    }

    @Override
    public int updateBySelective() {
        //更新条件
        UserExample example=new UserExample();
        example.createCriteria().andAccountEqualTo("TF-002");
        //更新内容
        User user=new User();
        user.setName("王");
        user.setAge(99);
        return userMapper.updateByExampleSelective(user,example);
    }

    /**
     * 使用mybatis的模糊查询时，需手动拼接%
     * @param str
     * @return
     */
    private String likeStr(String str){
        return "%"+str+"%";
    }
}
