package cn.knowei.ssm.mapper;

import cn.knowei.ssm.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author zheng
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-01-08 18:25:05
* @Entity generator.domain.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user")
    List<User> findAll();

    @Update("update user set gender=#{gender},email=#{email} where name=#{name}")
    void update(cn.knowei.ssm.bean.User user);

    @Delete("delete from user where id=#{id}")
    void delete(Integer id);

    User findOne(@Param("name")String name, @Param("gender")String gender, @Param("email") String email);

}
