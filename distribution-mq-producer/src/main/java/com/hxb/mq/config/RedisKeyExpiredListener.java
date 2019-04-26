package com.hxb.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 10:38:44
 */
@Component
@Slf4j
public class RedisKeyExpiredListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        log.info("监听到key = {}过期",message.toString());
    }
}
