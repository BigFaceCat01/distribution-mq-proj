package com.hxb.mq.service;

import com.hxb.common.model.mq.OrderPayMsgModel;

/**
 * @author create by huang xiao bao
 * @date 2019-04-20 15:59:18
 */
public interface SendService {
    /**
     * 发送订单支付消息到其他服务
     * @param msgModel
     */
    void sendMessage(OrderPayMsgModel msgModel);
}
