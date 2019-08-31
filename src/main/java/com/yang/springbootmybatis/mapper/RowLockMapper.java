package com.yang.springbootmybatis.mapper;

import com.yang.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: Yang
 * @date: 2019/8/25 13:18
 * @description:
 */
@Mapper
public interface RowLockMapper {

    @Select("select t.id as `id`, t.age as `age`from t_user t where t.id = ${id} for update")
    User lock(@Param("id") Integer id);

    @Update("update t_user set age = age + 1 where id = ${id}")
    int update(@Param("id") Integer id);

}
