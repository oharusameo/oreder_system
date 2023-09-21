package com.quxue.orderSystem.service;


import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.vo.OrderVo;

import java.util.List;

public interface OrderService {
    List<OrderVo> selectAll();

    List<OrderVo> selectMyOrder(Integer id);

    Integer addOrder(Order order);
}
