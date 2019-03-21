package com.yang.springbootmybatis.rest;

import com.yang.springbootmybatis.domain.Car;
import com.yang.springbootmybatis.domain.Wheel;
import com.yang.springbootmybatis.mapper.CarMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: Yang
 * @date: 2019/2/20 23:32
 * @description: 用于测试嵌套结果集方式查询一对（association）、一和一对多（collection）
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Resource
    private CarMapper carMapper;

    @GetMapping("getWholeCar")
    public List<Car> getWholeCar() {
        return this.carMapper.getWholeCar();
    }

    @GetMapping("/exceptionTest")
    public List<Map<String, Object>> exceptionTest() {
        return this.carMapper.exceptionTest();
    }

    @GetMapping("/associationNestedResultMapTest")
    public List<Car> associationNestedResultMapTest() {
        List<Car> kk = this.carMapper.associationNestedResultMapTest();
        return kk;
    }

}
