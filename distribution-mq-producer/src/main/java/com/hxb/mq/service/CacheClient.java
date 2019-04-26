package com.hxb.mq.service;

import com.hxb.common.model.response.CacheResult;

import java.util.concurrent.TimeUnit;

/**
 * 缓存操作
 * @author Created by huang xiao bao
 * @date 2019-04-26 09:36:04
 */
public interface CacheClient {

    /**
     * 向缓存中存放值
     * @param key key
     * @param value 值对象
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult set(String key,Object value);

    /**
     * 获得key的值
     * @param key key
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult get(String key);

    /**
     * 设置key并设置key的超时时间，若当前缓存库不支持则该操作与set(String key,String value)一样
     * @param key key
     * @param value 值对象
     * @param unit 时间单位
     * @param timeout 超时时间
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult set(String key, Object value, TimeUnit unit,long timeout);

    /**
     * 删除指定key
     * @param key key
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult delete(String key);

    /**
     * 设置值如果该key不存在
     * @param key key
     * @param value 值对象
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult setIfAbsent(String key,Object value);

    /**
     * 设置值如果该key不存在,并设置过期时间
     * @param key key
     * @param value 值对象
     * @param unit 时间单位
     * @param timeout 超时时间
     * @return 若设置操作有结果则返回缓存结果
     */
    CacheResult setIfAbsent(String key,Object value,TimeUnit unit,long timeout);
}
