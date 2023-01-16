package cn.knowei.ssm.service.impl;

import cn.knowei.ssm.bean.User;
import cn.knowei.ssm.mapper.UserMapper;
import cn.knowei.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 19:19 2023/1/6
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll(){
        System.out.println("查询所有用户");
        return userMapper.findAll();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public User findOne(String name, String gender, String email) {
        return userMapper.findOne(name, gender, email);
    }
}
