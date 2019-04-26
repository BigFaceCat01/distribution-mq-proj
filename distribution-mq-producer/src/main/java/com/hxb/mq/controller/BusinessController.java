package com.hxb.mq.controller;

import com.hxb.mq.service.CacheClient;
import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:02:58
 */
@RestController
public class BusinessController {

    @Autowired
    private CacheClient cacheClient;



    @ApiOperation(value = "测试幂等性")
    @GetMapping("orders/{orderId}")
    public Result<Void> test(@PathVariable("orderId") Long orderId){
        cacheClient.setIfAbsent("weather","hot");
        return Result.success();
    }
}
