package com.quxue.orderSystem.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class OrderVo implements Serializable {
    private BigDecimal orderId;
    private String goodsName;
    private Integer goodsNum;
    private String orderTime;

    @TableField(exist = false)
    private Integer goodsPrice;
    @TableField(exist = false)
    private Integer totalPrice;
    @TableField(exist = false)
    private String username;


}
