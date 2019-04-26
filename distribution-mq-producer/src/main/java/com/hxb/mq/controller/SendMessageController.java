package com.hxb.mq.controller;

import com.hxb.common.model.mq.OrderPayMsgModel;
import com.hxb.mq.service.SendService;
import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 16:13:07
 */
@RestController
public class SendMessageController {

    @Autowired
    private SendService sendService;

    @ApiOperation(value = "新增一条订单消息")
    @PostMapping("orders")
    public Result<Void> testSendMq(@RequestBody OrderPayMsgModel msgModel){
        sendService.sendMessage(msgModel);
        return Result.success();
    }
}
