package com.quxue.orderSystem.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quxue.orderSystem.mapper.OrderMapper;
import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.service.OrderService;
import com.quxue.orderSystem.vo.OrderVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Transactional
    public Integer addOrder(Order order) {
        Date date = new Date();
        String orderId = String.valueOf(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String orderTime = sdf.format(date);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsId", order.getGoodsId());
        map.put("goodsNum", order.getGoodsNum());
        map.put("userId", order.getUserId());
        map.put("orderId", orderId);
        map.put("orderTime", orderTime);

        return orderMapper.insertOrder(map);

    }

    public List<OrderVo> selectAll() {
        QueryWrapper<Integer> wrapper = new QueryWrapper<>();
       return orderMapper.queryOrder(wrapper);
    }

    public List<OrderVo> selectMyOrder(Integer id) {
        QueryWrapper<Integer> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",id);
        return orderMapper.queryOrder(wrapper);
    }

    public IPage<OrderVo> selectOrderByPage(Integer pageNum,Integer pageSize){
        Page<OrderVo> page = new Page<>(pageNum, pageSize);
        Wrapper<Integer> wrapper = new QueryWrapper<>();
        return orderMapper.queryOrderByPage(page,wrapper);
    }

    public IPage<OrderVo> selectMyOrderByPage(Integer pageNum,Integer pageSize,Integer id){
        Page<OrderVo> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Integer> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",id);
        return orderMapper.queryOrderByPage(page,wrapper);
    }

}
