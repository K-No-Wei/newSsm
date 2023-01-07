package cn.knowei.ssm.service;

import cn.knowei.ssm.bean.User;

import java.util.List;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 19:19 2023/1/6
 */
public interface UserService {
    List<User> findAll();

    void insert(User user);

    void update(User user);

    void delete(Integer id);
}
