package com.hxb.mq.service;

import com.hxb.common.model.OrderPayMsgModel;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:35:46
 */
public interface BusinessService {
    /**
     * 发送消息
     */
    void sendMsg(OrderPayMsgModel msgModel);
}
