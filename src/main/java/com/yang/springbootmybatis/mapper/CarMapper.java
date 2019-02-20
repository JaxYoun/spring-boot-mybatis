package com.yang.springbootmybatis.mapper;

import com.yang.springbootmybatis.domain.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

}
