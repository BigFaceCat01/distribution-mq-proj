package com.hxb.mq.config;

import com.hxb.smart.rpcv2.RpcFactory;
import com.hxb.smart.rpcv2.configuration.RpcConfig;
import com.hxb.smart.rpcv2.core.invoker.router.impl.RandomRouter;
import com.hxb.smart.rpcv2.core.net.NetType;
import com.hxb.smart.rpcv2.registry.impl.LocalServiceRegistry;
import com.hxb.smart.rpcv2.serializer.impl.HessianSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by huang xiao bao
 * @date 2019-05-13 16:41:39
 */
@Configuration
public class RpcFactoryConfig {
    @Bean
    public RpcFactory rpcFactory(){
        RpcConfig config = RpcConfig.builder()
                .basePackage("com.hxb")
                .netType(NetType.NETTY)
                .registryCenterAddress("0.0.0.0")
                .router(new RandomRouter())
                .serviceRegistry(new LocalServiceRegistry())
                .serializer(new HessianSerializer())
                .build();
        return RpcFactory.builder().config(config).build();
    }
}
