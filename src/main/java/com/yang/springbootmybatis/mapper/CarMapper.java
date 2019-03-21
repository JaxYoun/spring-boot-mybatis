package com.yang.springbootmybatis.mapper;

import com.yang.springbootmybatis.domain.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: Yang
 * @date: 2019/2/20 23:14
 * @description:
 */
@Mapper
public interface CarMapper {

    /**
     * 查询整车
     *
     * @return
     */
    List<Car> getWholeCar();

    /**
     * 在动态条件sql中，当where之后无满足的条件时用and exception可以避免语法和逻辑错误
     *
     * @return
     */
    List<Map<String, Object>> exceptionTest();

    /**
     * 测试association-嵌套结果集用法
     * @return
     */
    List<Car> associationNestedResultMapTest();
}
