package com.quxue.orderSystem.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quxue.orderSystem.pojo.Goods;
import com.quxue.orderSystem.pojo.Result;

import java.util.List;

public interface GoodsService {
    Integer addGoods(Goods goods);
    IPage<Goods> viewGoods(Integer pageNum, Integer pageSize);

    Integer deleteGoods(Integer id);
    Integer updateGoods(Goods goods);

}
