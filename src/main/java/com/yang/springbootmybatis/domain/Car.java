package com.yang.springbootmybatis.domain;

import lombok.Data;

import java.util.Set;

/**
 * @author: Yang
 * @date: 2019/2/20 23:02
 * @description:
 */
@Data
public class Car {

    private Integer id;

    private String name;

    private Steer steer;

    private Set<Wheel> wheelSet;

}
