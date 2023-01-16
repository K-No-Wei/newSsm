package cn.knowei.ssm.controller;

import cn.knowei.ssm.bean.User;
import cn.knowei.ssm.common.domain.Result;
import cn.knowei.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: knowei
 * @Description:
 * @Date: Create in 19:41 2023/1/6
 */
// @Controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public String findAll(Model model){
        System.out.println("success");
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

    @PostMapping("insert")
    @ResponseBody
    public String insert(@RequestBody User user){
        userService.insert(user);
        return "success";
    }

    @PutMapping("update")
    @ResponseBody
    public String update(@RequestBody User user){
        userService.update(user);
        return "success";
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "success";
    }

    @RequestMapping("findOne")
    public Result findOne(String name, String gender, String email){
        User user = userService.findOne(name, gender, email);
        return Result.success().data("user", user);
    }
}
