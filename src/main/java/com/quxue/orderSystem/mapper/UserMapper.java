package com.quxue.orderSystem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quxue.orderSystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    User selectUser(User user);
//    int insertUser(User user);
//
//    List<User> selectAll();
//    List<User> selectAllUser();
//    int delUser(Integer id);
}
