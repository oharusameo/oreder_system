package com.quxue.orderSystem.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quxue.orderSystem.mapper.GoodsMapper;
import com.quxue.orderSystem.pojo.Goods;
import com.quxue.orderSystem.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Transactional
    @Override
    public Integer addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public IPage<Goods> viewGoods(Integer pageNum, Integer pageSize) {
        IPage<Goods> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        return goodsMapper.selectPage(page,wrapper);
    }

    @Transactional
    @Override
    public Integer deleteGoods(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Transactional
    @Override
    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateById(goods);
    }


}



