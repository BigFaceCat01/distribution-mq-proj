package com.hxb.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:09:40
 */
@SpringBootApplication
@ComponentScan("com.hxb")
public class MqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqProducerApplication.class);
    }
}
