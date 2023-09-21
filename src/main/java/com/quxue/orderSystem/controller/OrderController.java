package com.quxue.orderSystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.pojo.Result;
import com.quxue.orderSystem.service.OrderService;
import com.quxue.orderSystem.vo.OrderVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/viewOrder.do")
    public Result viewOrder() {

        List<OrderVo> list = orderService.selectAll();
        System.out.println("list = " + list);
        return Result.success(list);

    }


    @RequestMapping("/addOrder.do")
    public Result addOrder(@RequestBody Order order){
        System.out.println("order = " + order);
        if (orderService.addOrder(order)==1){
            return Result.success("添加订单成功");
        }
        return Result.error("添加订单失败");

    }


}
