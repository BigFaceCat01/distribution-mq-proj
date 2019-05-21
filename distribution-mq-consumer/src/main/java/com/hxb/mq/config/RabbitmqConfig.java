package com.hxb.mq.config;

import com.hxb.common.constant.MqConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:29:32
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

    @Bean
    public Queue consumeQueue(){
        return new Queue(MqConstants.CONSUME_QUEUE);
    }

    @Bean
    public DirectExchange consumeExchange(){
        return new DirectExchange(MqConstants.CONSUME_EXCHANGE);
    }

    @Bean
    public Binding consumeDirectExchangeBinding(DirectExchange consumeExchange,Queue consumeQueue){
        return BindingBuilder.bind(consumeQueue).to(consumeExchange).with(MqConstants.CONSUME_ROUTING_KEY);
    }
}
