package com.quxue.orderSystem.controller;


import com.quxue.orderSystem.pojo.Goods;
import com.quxue.orderSystem.pojo.Result;
import com.quxue.orderSystem.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
@Api(tags = {"商品Api"})
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/addGoods.do")
    @ApiOperation("添加商品")
    public Result addGoods(@RequestBody Goods goods) {
        System.out.println("goods = " + goods);
        if (goodsService.addGoods(goods) == 1) {
            return Result.success("添加商品成功");
        }
        return Result.error("添加商品失败");
    }

    @RequestMapping("/listGoods.do")
    public Result viewGoods(@RequestParam(defaultValue = "1") Integer currentPage,
                            @RequestParam(defaultValue = "5") Integer pageSize) {
        return Result.success(goodsService.viewGoods(currentPage, pageSize));
    }

    @RequestMapping("/delGoods.do")
    public Result delGoods(@Param("goodsId") Integer goodsId) {
        System.out.println("goodsId = " + goodsId);
        if (goodsService.deleteGoods(goodsId) == 1) {
            return Result.success("删除商品成功");
        }
        return Result.error("删除商品失败");
    }


    @RequestMapping("/updateGoods.do")
    public Result updateGoods(@RequestBody Goods goods) {
        System.out.println("goods = " + goods);
        if (goodsService.updateGoods(goods) == 1) {
            return Result.success("更新商品信息成功");
        }
        return Result.error("更新商品信息失败");
    }

    @ApiIgnore//该接口不生成接口文档
    @RequestMapping("/listGoodsByPage.do")
    public Result viewGoodsByPage(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize) {
return null;

    }


}
