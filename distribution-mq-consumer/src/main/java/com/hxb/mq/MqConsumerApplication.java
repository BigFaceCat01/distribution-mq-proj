package com.hxb.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:09:40
 */
@SpringBootApplication
@ComponentScan("com.hxb")
@MapperScan("com.hxb.dao.mapper")
public class MqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqConsumerApplication.class);
    }
}
