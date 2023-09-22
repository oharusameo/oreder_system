package com.quxue.orderSystem.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_menu")
public class Menu implements Serializable {
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;
    private String menuName;
    private String url;
    private Integer parentId;
    private String menuDesc;

}
