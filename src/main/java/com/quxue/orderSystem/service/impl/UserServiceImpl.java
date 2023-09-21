package com.quxue.orderSystem.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quxue.orderSystem.mapper.UserMapper;
import com.quxue.orderSystem.pojo.User;
import com.quxue.orderSystem.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUsername());
        wrapper.eq("user_pwd", user.getPassword());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public List<User> selectAll() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectList(wrapper);
    }

    @Override
    public List<User> selectAllUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_role", 1);//设置查询role==1的用户
        return userMapper.selectList(wrapper);
    }

    @Transactional
    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    @Override
    public int delUser(Integer id) {
        return userMapper.deleteById(id);
    }
}
