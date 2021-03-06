package com.yang.springbootmybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: Yang
 * @date: 2019/2/19 23:21
 * @description:
 */
@Data
public class Menu {

    private Integer id;

    private String name;

    private List<Button> buttonList;

}
