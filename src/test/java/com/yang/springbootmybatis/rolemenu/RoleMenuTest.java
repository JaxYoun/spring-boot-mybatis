package com.yang.springbootmybatis.rolemenu;

import com.yang.springbootmybatis.mapper.RoleMenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/2/19 23:56
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.yang.springbootmybatis.SpringBootMybatisApplication.class)
public class RoleMenuTest {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void nestedSqlTest() {
        this.roleMenuMapper.getRoleWithNestedSql().forEach(it -> System.out.println(it.getMenuList().size()));
    }

}
