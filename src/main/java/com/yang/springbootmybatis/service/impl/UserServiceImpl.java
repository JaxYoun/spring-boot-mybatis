package com.yang.springbootmybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.springbootmybatis.domain.User;
import com.yang.springbootmybatis.mapper.UserMapper;
import com.yang.springbootmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return this.userMapper.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        return this.userMapper.addUser(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return this.userMapper.updateUser(user) > 0;
    }

    @Override
    public PageInfo<User> getUserByPageInfo(Integer page, Integer size) {
        User user = new User();
        user.setId(2);
        PageInfo<User> userPageInfo = PageHelper  //保留了全面的分页参数
                .startPage(page, size)
                .setOrderBy("id")
                .doSelectPageInfo(() -> this.userMapper.getUserByPage(user));
        return userPageInfo;
    }

    @Override
    public Page<User> getUserByPage(Integer page, Integer size) {
        User user = new User();
        user.setId(1);
        Page<User> userPage = PageHelper  //只保留了有限的几个关键分页参数
                .startPage(page, size)
                .setOrderBy("age")
                .doSelectPage(() -> this.userMapper.getUserByPage(user));
        int kk = userPage.getPageNum();
        long total = userPage.getTotal();
        return userPage;
    }

    /**
     * 【注意】只要你可以保证在 PageHelper 方法调用后【紧跟】 MyBatis 查询方法，这就是安全的。
     * 因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象。
     * 一次静态方法调用只能对应一次MyBatis查询，如果有多次查询就需要调用多次静态方法
     *
     * @param page
     * @param size
     * @return
     */
    public Page<User> getUserPage(Integer page, Integer size) {
        User user = new User();
        user.setId(1);
        Page<User> userPage = PageHelper.startPage(page, size);
        this.userMapper.getUserByPage(user);
        int kk = userPage.getPageNum();
        long total = userPage.getTotal();
        return userPage;
    }
}
