package com.quxue.orderSystem.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.quxue.orderSystem.pojo.Order;
import com.quxue.orderSystem.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;
import java.util.Map;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<OrderVo> queryMyOrder(Integer UserId);

//    List<OrderVo> queryOrder();

    List<OrderVo> queryOrder(@Param(Constants.WRAPPER) Wrapper<Map<String, Object>> wrapper);

    int insertOrder(Map<String, Object> map);

}
