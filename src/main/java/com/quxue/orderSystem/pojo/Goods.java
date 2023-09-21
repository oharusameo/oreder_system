package com.quxue.orderSystem.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("t_goods")
public class Goods implements Serializable {

    @TableId(value = "id" ,type = IdType.AUTO)
    private String goodsId;

//    @TableField("goods_name")
    private String goodsName;

    @TableField("goods_price")
    private Integer price;

    public Goods(String goodsName, Integer price) {
        this.goodsName = goodsName;
        this.price = price;
    }

    public Goods(String goodsId, String goodsName, Integer price) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
    }



}
