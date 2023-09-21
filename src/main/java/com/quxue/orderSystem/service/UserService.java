package com.quxue.orderSystem.service;


import com.quxue.orderSystem.pojo.User;

import java.util.List;

public interface UserService {
    User selectUser(User user);

    List<User> selectAll();
    List<User> selectAllUser();

    int insertUser(User user);

    int delUser(Integer id);
}
