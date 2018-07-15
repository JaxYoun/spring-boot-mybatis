package com.yang.springbootmybatis.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yang.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Select("select t.id as `id`, t.name as `name`, t.age as `age`, t.is_married as `isMarried` from t_user t where t.id = ${id}")
    User getUserById(@Param("id") Integer id);

    /**
     * 插入，以对象传参
     *
     * @param user
     * @return
     */
    @Insert("insert into t_user (`name`, age, is_married) values (#{user.name}, #{user.age}, #{user.isMarried})")
    int addUser(@Param("user") User user);

    /**
     * 使用Mapper文件
     *
     * @param user
     * @return
     */
    int updateUser(@Param("user") User user);

    @Select("select t.id as `id`, t.name as `name`, t.age as `age`, t.is_married as `isMarried` from t_user t where t.id > #{user.id}")
    List<User> getUserByPage(@Param("user") User user);

}
