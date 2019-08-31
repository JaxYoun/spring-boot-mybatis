package com.yang.springbootmybatis.rest;

import com.yang.springbootmybatis.service.LockUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/8/25 13:16
 * @description:
 */
@RestController
@RequestMapping("/rowLock")
public class RowLockController {

    @Resource
    private LockUserService lockUserService;

    @GetMapping("/lock/{id}")
    public void lock(@PathVariable("id") Integer id) {
        this.lockUserService.lock(id);
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    this.lockUserService.update(id);
                }
            }).start();
        }
    }

    @GetMapping("/lockForUpdate/{id}")
    public void lockForUpdate(@PathVariable("id") Integer id) {
        /*for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    this.lockUserService.lockForUpdate(id);
                }
            }).start();
        }*/
        this.lockUserService.lockForUpdate(id);
    }

}
