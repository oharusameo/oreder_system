package com.quxue.orderSystem.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.quxue.orderSystem.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {


//    List<Goods> selectList(@Param(Constants.WRAPPER) Wrapper<Goods> queryWrapper);


    List<Goods> queryGoods();
//
//    int insertGoods(Goods goods);
//
//    int delete(Integer id);
//
//    int update(Goods goods);


}
