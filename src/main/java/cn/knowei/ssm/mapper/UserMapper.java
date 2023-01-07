package cn.knowei.ssm.mapper;

import cn.knowei.ssm.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 19:18 2023/1/6
 */
// @Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert user(name,gender,email) values(#{name},#{gender},#{email})")
    void insert(User user);

    @Update("update user set gender=#{gender},email=#{email} where name=#{name}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Integer id);
}
