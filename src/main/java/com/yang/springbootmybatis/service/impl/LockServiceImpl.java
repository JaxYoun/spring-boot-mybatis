package com.yang.springbootmybatis.service.impl;

import com.yang.springbootmybatis.domain.User;
import com.yang.springbootmybatis.mapper.RowLockMapper;
import com.yang.springbootmybatis.service.LockUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yang
 * @date: 2019/8/25 13:25
 * @description:
 */
@Service
public class LockServiceImpl implements LockUserService {

    @Resource
    private RowLockMapper rowLockMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User lock(Integer id) {
        this.rowLockMapper.lock(id);
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update(Integer id) {
        return this.rowLockMapper.update(id);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void lockForUpdate(Integer id) {
        User user = this.rowLockMapper.lock(id);
        try {
            TimeUnit.SECONDS.sleep(40L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.rowLockMapper.update(id);
    }

}
