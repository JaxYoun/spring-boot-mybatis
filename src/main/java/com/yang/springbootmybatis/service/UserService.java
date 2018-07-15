package com.yang.springbootmybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yang.springbootmybatis.domain.User;

public interface UserService {

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    boolean addUser(User user);

    boolean updateUser(User user);

    PageInfo<User> getUserByPageInfo(Integer page, Integer size);

    Page<User> getUserByPage(Integer page, Integer size);

}
