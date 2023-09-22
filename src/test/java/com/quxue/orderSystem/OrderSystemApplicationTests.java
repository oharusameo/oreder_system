package com.quxue.orderSystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quxue.orderSystem.mapper.GoodsMapper;
import com.quxue.orderSystem.mapper.MenuMapper;
import com.quxue.orderSystem.mapper.OrderMapper;
import com.quxue.orderSystem.mapper.UserMapper;
import com.quxue.orderSystem.pojo.Goods;
import com.quxue.orderSystem.pojo.Menu;
import com.quxue.orderSystem.pojo.User;
import com.quxue.orderSystem.service.UserService;
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
    private MenuMapper menuMapper;

    @Test
    public void testMenu() {
        QueryWrapper<Integer> wrapper = new QueryWrapper<>();
        wrapper.eq("ut.user_role",2);
        List<Menu> menus = menuMapper.queryByRole(wrapper);
        System.out.println("menus = " + menus);

    }


    @Test
    public void testOrder() {
        QueryWrapper<Map<String, Object>> wrapper = new QueryWrapper<>();
        wrapper.eq("ot.goods_name", "应急食品");
        List<OrderVo> orderVos = orderMapper.queryOrder(wrapper);
        System.out.println("orderVos = " + orderVos);
    }


}
