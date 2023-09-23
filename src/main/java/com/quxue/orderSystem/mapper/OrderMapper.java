package com.quxue.orderSystem.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quxue.orderSystem.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface OrderMapper extends BaseMapper<OrderVo> {


    List<OrderVo> queryOrder(@Param(Constants.WRAPPER) Wrapper<Integer> wrapper);

    int insertOrder(Map<String, Object> map);

    IPage<OrderVo> queryOrderByPage(Page<OrderVo> page, @Param(Constants.WRAPPER) Wrapper<Integer> wrapper);

}
