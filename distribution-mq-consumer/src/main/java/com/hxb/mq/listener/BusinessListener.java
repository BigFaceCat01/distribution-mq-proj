package com.hxb.mq.listener;

import com.hxb.common.constant.MqConstants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:36:37
 */
@Slf4j
@RabbitListener(queues = MqConstants.CONSUME_QUEUE)
@Component
public class BusinessListener {
    @RabbitHandler
    public void onMessage(String msg,Channel channel,Message message){
        try {
            log.info("\r\n>>>>>>>>>收到消息<<<<<<<<:{}",msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(12);
            arrayBlockingQueue.poll(1,TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
