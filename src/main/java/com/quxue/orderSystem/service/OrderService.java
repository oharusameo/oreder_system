package com.quxue.orderSystem.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.vo.OrderVo;

import java.util.List;

public interface OrderService {
    List<OrderVo> selectAll();

    List<OrderVo> selectMyOrder(Integer id);

    Integer addOrder(Order order);

    IPage<OrderVo> selectOrderByPage(Integer pageNum,Integer pageSize);
    IPage<OrderVo> selectMyOrderByPage(Integer pageNum,Integer pageSize,Integer id);

}
