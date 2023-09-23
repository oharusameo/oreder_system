package com.quxue.orderSystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quxue.orderSystem.mapper.GoodsMapper;
import com.quxue.orderSystem.mapper.MenuMapper;
import com.quxue.orderSystem.mapper.OrderMapper;
import com.quxue.orderSystem.mapper.UserMapper;
import com.quxue.orderSystem.pojo.Goods;
import com.quxue.orderSystem.pojo.Menu;
import com.quxue.orderSystem.pojo.User;
import com.quxue.orderSystem.service.MenuService;
import com.quxue.orderSystem.service.OrderService;
import com.quxue.orderSystem.service.UserService;
import com.quxue.orderSystem.vo.MenuVo;
import com.quxue.orderSystem.vo.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class OrderSystemApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuService menuService;

    @Test
    public void testMenu() {
        List<MenuVo> list = menuService.selectMenuByRole(1);
        System.out.println("list = " + list);
    }


    @Test
    public void testOrder() {
        IPage<OrderVo> orderVoIPage = orderService.selectOrderByPage(1, 5);
        System.out.println("orderVoIPage = " + orderVoIPage);
        IPage<OrderVo> orderVoIPage1 = orderService.selectMyOrderByPage(1, 5, 3);
        System.out.println("orderVoIPage1 = " + orderVoIPage1);

    }


}
