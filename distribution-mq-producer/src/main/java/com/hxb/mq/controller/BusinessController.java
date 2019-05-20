package com.hxb.mq.controller;

import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:02:58
 */
@RestController
public class BusinessController {

    @ApiOperation(value = "测试rpc")
    @GetMapping("test/rpc")
    public Result<Integer> testRpc(Integer a,Integer b){

        return Result.success();
    }
}
