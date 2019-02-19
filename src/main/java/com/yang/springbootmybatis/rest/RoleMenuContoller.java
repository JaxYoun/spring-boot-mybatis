package com.yang.springbootmybatis.rest;

import com.yang.springbootmybatis.domain.Role;
import com.yang.springbootmybatis.mapper.RoleMenuMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/2/20 00:05
 * @description:
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuContoller {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @GetMapping("/getRoleWithNestedSql")
    public List<Role> getRoleWithNestedSql() {
        return this.roleMenuMapper.getRoleWithNestedSql();
    }

}
