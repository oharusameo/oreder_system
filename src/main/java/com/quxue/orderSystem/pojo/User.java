package com.quxue.orderSystem.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private String userId;
    @TableField("user_name")
    private String username;
    @TableField("user_role")
    private String role;
    @TableField("user_pwd")
//    @JsonIgnore //设置响应时忽略此字段
    private String password;

    public User(String userId, String username, String role, String password) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
}
