package com.hxb.mq.controller;

import com.hxb.smart.rpc.api.HelloService;
import com.hxb.smart.rpcv2.RpcFactory;
import com.hxb.smart.rpcv2.core.invoker.reference.InvokerProxyBean;
import com.hxb.structure.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:02:58
 */
@RestController
public class BusinessController {

    @Autowired
    private RpcFactory rpcFactory;



    @ApiOperation(value = "测试rpc")
    @GetMapping("test/rpc")
    public Result<Integer> testRpc(Integer a,Integer b){
        HelloService helloService = (HelloService) (InvokerProxyBean.newProxyBean(HelloService.class,rpcFactory).getObject());
        return Result.success(helloService.plus(a,b));
    }
}
