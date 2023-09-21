package com.quxue.orderSystem.controller;


import com.quxue.orderSystem.pojo.Result;
import com.quxue.orderSystem.pojo.User;
import com.quxue.orderSystem.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/listAllUser.do")
    public Result viewAllUser() {
        List<User> list = userService.selectAll();
        System.out.println("list = " + list);
        return Result.success(list);
    }

    @RequestMapping("/listUser.do")
    public Result viewUser() {
        List<User> list = userService.selectAllUser();
        System.out.println("list = " + list);
        return Result.success(list);
    }


    @RequestMapping("/login.do")
    public Result login(@RequestBody User user) {
        System.out.println("user = " + user);
        User u = userService.selectUser(user);
        System.out.println("u = " + u);
        Result result;
        if (u != null) {
            result = Result.success(u);
        } else {
            result = Result.error("账户名或密码错误");
        }
        return result;
    }

    @RequestMapping("/register.do")
    public Result register(@RequestBody User user) {
        System.out.println("user = " + user);
        if (userService.insertUser(user) == 1) {
            return Result.success("注册成功");
        }
        return Result.error("注册失败");
    }


    @RequestMapping("/delUser.do")
    public Result delUser(@RequestBody User user) {
        System.out.println("user = " + user);
        if (userService.delUser(Integer.valueOf(user.getUserId())) == 1) {
            return Result.success("用户删除成功");
        }
        return Result.error("用户删除失败");
    }

}
