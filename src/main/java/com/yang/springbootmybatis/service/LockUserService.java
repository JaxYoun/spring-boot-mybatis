package com.yang.springbootmybatis.service;

import com.yang.springbootmybatis.domain.User;

/**
 * @author: Yang
 * @date: 2019/8/25 13:23
 * @description:
 */
public interface LockUserService {

    User lock(Integer id);

    int update(Integer id);

    void lockForUpdate(Integer id);

}
