package com.quxue.orderSystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("t_user")

public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private String userId;

    @TableField("user_name")
    @NotBlank(message = "账号不能为空")
    private String username;

    @TableField("user_role")
    private String role;

    @TableField("user_pwd")
//    @JsonIgnore //设置响应时忽略此字段
    @NotBlank(message = "用户名不能为空")
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
