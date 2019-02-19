package com.yang.springbootmybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: Yang
 * @date: 2019/2/19 23:21
 * @description: 角色实体类
 */
@Data
public class Role {

    private Integer id;

    private String name;

    private List<Menu> menuList;

}
