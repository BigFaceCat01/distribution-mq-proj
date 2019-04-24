package com.hxb.mq.service.impl;

import com.alibaba.fastjson.JSON;
import com.hxb.common.constant.MqConstants;
import com.hxb.common.model.mq.OrderPayMsgModel;
import com.hxb.mq.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author create by huang xiao bao
 * @date 2019-04-20 16:01:54
 */
@Service
@Slf4j
public class SendServiceImpl implements SendService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(OrderPayMsgModel msgModel) {
        String msg = JSON.toJSONString(msgModel);
        log.info("发送订单支付消息:{}",msg);
        rabbitTemplate.convertAndSend(MqConstants.CONSUME_EXCHANGE,MqConstants.CONSUME_ROUTING_KEY,msg);
    }
}
