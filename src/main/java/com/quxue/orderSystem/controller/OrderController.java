package com.quxue.orderSystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.pojo.Result;
import com.quxue.orderSystem.service.OrderService;
import com.quxue.orderSystem.util.CookieUtil;
import com.quxue.orderSystem.vo.OrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

//    @RequestMapping("/viewOrder.do")
//    public Result viewOrder() {
//        List<OrderVo> list = orderService.selectAll();
//        System.out.println("list = " + list);
//        return Result.success(list);
//    }

    @RequestMapping("/viewOrder.do")
    public Result viewOrderByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "5") Integer pageSize) {
        return Result.success(orderService.selectOrderByPage(currentPage, pageSize));
    }

    @RequestMapping("/viewMyOrder.do")
    public Result viewMyOrderByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "5") Integer pageSize, HttpServletRequest req) {
        String userId = CookieUtil.getCookieValue(req, "userId");
        String username = CookieUtil.getCookieValue(req, "username");
        System.out.println("userId = " + userId);
        System.out.println("username = " + username);
        if (userId != null) {
            return Result.success(orderService.selectMyOrderByPage(currentPage, pageSize, Integer.valueOf(userId)));
        }
        return Result.error("没有获取到cookie");
    }


//    @RequestMapping("/viewMyOrder.do")
//    public Result viewMyOrder(@Param("userId") Integer userId) {
//        List<OrderVo> list = orderService.selectMyOrder(userId);
//        System.out.println("list = " + list);
//        return Result.success(list);
//    }


    @RequestMapping("/addOrder.do")
    public Result addOrder(@RequestBody Order order) {
        System.out.println("order = " + order);
        if (orderService.addOrder(order) == 1) {
            return Result.success("添加订单成功");
        }
        return Result.error("添加订单失败");

    }


}
