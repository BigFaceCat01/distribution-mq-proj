package com.hxb.mq.controller;

import com.hxb.common.model.request.ProductStockSaveReq;
import com.hxb.common.model.request.ProductStockUpdateReq;
import com.hxb.common.model.response.AllProductStockVO;
import com.hxb.mq.aop.ParamLog;
import com.hxb.mq.service.ProductStockService;
import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-28 14:12:37
 */
@RestController
public class ProductStockController {
    @Autowired
    private ProductStockService productStockService;

    @ApiOperation(value = "新增商品库存信息")
    @PostMapping("product/stock")
    public Result<Void> insertStock(@RequestBody ProductStockSaveReq stockSaveReq){
        productStockService.insert(stockSaveReq);
        return Result.success();
    }

    @ApiOperation(value = "新增商品库存信息")
    @PutMapping("product/stock/{productId}")
    public Result<Void> insertStock(@PathVariable("productId") Long productId, @RequestParam(required = false) String productName,@RequestParam(required = false) BigDecimal amount){
        ProductStockUpdateReq model = ProductStockUpdateReq.builder()
                .amount(amount)
                .productName(productName)
                .productId(productId)
                .build();
        productStockService.update(model);
        return Result.success();
    }

    @ApiOperation("查询所有商品库存信息")
    @GetMapping("product/stock")
    public Result<List<AllProductStockVO>> listAllUser(){
        return Result.success(productStockService.listAllProductStock());
    }

    @ApiOperation("秒杀商品")
    @PutMapping("product/seckill/{productId}")
    public Result<Void> seckill(@PathVariable("productId") Long productId){
        productStockService.seckill(productId);
        return Result.success();
    }
    @ApiOperation("秒杀商品，使用了synchronize关键字")
    @PutMapping("product/seckill/synchronized/{productId}")
    public Result<Void> seckillWithSynchronized(@PathVariable("productId") Long productId){
        productStockService.seckillWithSynchronized(productId);
        return Result.success();
    }
    @ApiOperation("秒杀商品，使用了数据库乐观锁")
    @PutMapping("product/seckill/positive//{productId}")
    public Result<Void> seckillWithPositiveLock(@PathVariable("productId") Long productId){
        productStockService.seckillWithPositiveLock(productId);
        return Result.success();
    }
}
