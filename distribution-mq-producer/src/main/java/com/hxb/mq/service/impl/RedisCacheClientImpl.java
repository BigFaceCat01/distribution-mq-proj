package com.hxb.mq.service.impl;

import com.hxb.common.model.response.CacheResult;
import com.hxb.mq.service.CacheClient;
import com.hxb.mq.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 09:57:24
 */
@Component
@Slf4j
public class RedisCacheClientImpl implements CacheClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public CacheResult set(String key, Object value) {
        return set(key,value,Expiration.persistent(),RedisStringCommands.SetOption.UPSERT);
    }

    @Override
    public CacheResult get(String key) {
        try {
            String value =stringRedisTemplate.opsForValue().get(key);
            return CacheResult.success(value);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return CacheResult.fail();
        }
    }

    @Override
    public CacheResult set(String key, Object value, TimeUnit unit, long timeout) {
        return set(key,value,Expiration.persistent(),RedisStringCommands.SetOption.UPSERT);
    }

    @Override
    public CacheResult delete(String key) {
        try {
            Boolean res = stringRedisTemplate.delete(key);
            return CacheResult.success(res);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return CacheResult.fail();
        }
    }

    @Override
    public CacheResult setIfAbsent(String key, Object value, TimeUnit unit, long timeout) {
        return set(key, value, Expiration.seconds(unit.toSeconds(timeout)), RedisStringCommands.SetOption.SET_IF_ABSENT);
    }

    @Override
    public CacheResult setIfAbsent(String key, Object value) {
        return set(key,value,Expiration.persistent(),RedisStringCommands.SetOption.SET_IF_ABSENT);
    }

    /**
     * 内部set命令
     * @param key key
     * @param value value
     * @param expiration 过期时间
     * @param setOption 操作类型 "nx" or "ex"
     * @return 若设置操作有结果则返回缓存结果
     */
    private CacheResult set(String key, Object value, Expiration expiration, RedisStringCommands.SetOption setOption){
        try {
            boolean r = (boolean)stringRedisTemplate.execute((RedisCallback<Object>) redisConnection ->
                    redisConnection.set(
                            stringRedisTemplate.getStringSerializer().serialize(key),
                            stringRedisTemplate.getStringSerializer().serialize(JsonUtil.toJsonString(value)),
                            expiration,
                            setOption)
            );
            return CacheResult.success(r);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return CacheResult.fail();
        }
    }
}
