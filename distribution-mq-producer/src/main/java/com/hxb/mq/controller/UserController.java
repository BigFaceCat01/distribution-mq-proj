package com.hxb.mq.controller;

import com.hxb.common.model.request.UserSaveReq;
import com.hxb.mq.service.CacheClient;
import com.hxb.mq.service.UserService;
import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:02:58
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户,没有幂等性验证，这里username需要非重复")
    @PostMapping("users")
    public Result<Void> insertUser(@RequestBody UserSaveReq saveReq){
        userService.insertUser(saveReq);
        return Result.success();
    }

    @ApiOperation(value = "新增用户,没有幂等性验证，这里username需要非重复")
    @PostMapping("idempotence/redis/users")
    public Result<Void> insertUserWithRedis(@RequestBody UserSaveReq saveReq){
        userService.insertUserWithRedis(saveReq);
        return Result.success();
    }
}
