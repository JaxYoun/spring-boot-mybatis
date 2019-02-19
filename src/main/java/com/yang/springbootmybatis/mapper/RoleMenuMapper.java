package com.yang.springbootmybatis.mapper;

import com.yang.springbootmybatis.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Yang
 * @date: 2019/2/19 23:32
 * @description:
 */
@Mapper
public interface RoleMenuMapper {

    /**
     * 嵌套查询SQL语句的方式
     * 优点：先主后从分布查询思路清晰，实现简单
     * 缺点：会带来“1+N”次查询的问题，会对数据库造成额外压力，如果数据库抗压能力强这种方式是可行的
     *
     * @return
     */
    List<Role> getRoleWithNestedSql();

    /**
     * 嵌套结果集的方式
     * 优点：只执行一次大查询不会对造成数据库额外压力
     * 缺点：
     *
     * @return
     */
    List<Role> getRoleWithNestedResultMap();

}
