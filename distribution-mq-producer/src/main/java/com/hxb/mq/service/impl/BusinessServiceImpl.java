package com.hxb.mq.service.impl;

import com.alibaba.fastjson.JSON;
import com.hxb.common.constant.MqConstants;
import com.hxb.common.model.OrderPayMsgModel;
import com.hxb.mq.service.BusinessService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:36:02
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(OrderPayMsgModel msgModel){
        rabbitTemplate.convertAndSend(MqConstants.CONSUME_EXCHANGE,MqConstants.CONSUME_ROUTING_KEY, JSON.toJSONString(msgModel));
    }
}
