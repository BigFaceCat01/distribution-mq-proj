package com.hxb.mq.config;

import com.yma.rpc.RpcFactory;
import com.yma.rpc.configuration.RpcConfig;
import com.yma.rpc.constant.RpcRole;
import com.yma.rpc.core.net.NetType;
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
                .rpcRole(RpcRole.BOTH)
                .netType(NetType.NETTY)
                .registryCenterAddress("0.0.0.0")
                .build();
        return new RpcFactory(config);
    }
}
