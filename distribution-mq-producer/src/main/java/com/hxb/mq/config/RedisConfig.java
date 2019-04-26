package com.hxb.mq.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.hxb.mq.constants.UserConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 09:59:32
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Value("${spring.redis.topic}")
    private String topic;
    @Value("${redis.listener.executor.pool.core}")
    private int coreSize;
    @Value("${redis.listener.executor.pool.max}")
    private int maxSize;
    @Value("${redis.listener.executor.pool.keepAlive.seconds}")
    private int keepAlive;
    @Value("${redis.key.default.keepAlive.days}")
    private int defaultKeepAlive;
    @Value("${redis.key.userRegister.keepAlive.days}")
    private int userRegisterKeepAlive;

    @Autowired
    private RedisKeyExpiredListener redisKeyExpiredListener;

    /**
     * 配置RedisTemplate
     * @param connectionFactory redis连接工厂
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //key使用String serialize
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        //对象使用fast json serialize
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        return template;
    }

    /**
     * 配置StringRedisTemplate
     * @param redisConnectionFactory redis连接工厂
     * @return StringRedisTemplate
     */
    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 配置过期键监听
     * @param connectionFactory redis连接工厂
     * @return RedisMessageListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer listenerContainer(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(taskExecutor());
        PatternTopic channelTopic = new PatternTopic(topic);
        container.addMessageListener(redisKeyExpiredListener, channelTopic);
        return container;
    }

    /**
     * key过期监听执行线程池
     * @return 执行线程池
     */
    @Primary
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(maxSize);
        executor.setKeepAliveSeconds(keepAlive);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 配置默认key过期时间
     * 配置指定前缀的key默认过期时间
     * @param redisConnectionFactory redis连接工厂
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 默认策略，未配置的 key 会使用这个
        // 指定 key 策略
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                this.getRedisCacheConfigurationWithTtl(defaultKeepAlive*24*3600),
                this.getRedisCacheConfigurationMap()
        );
    }

    /**
     * 配置key自动过期的前缀
     * @return 配置
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(16);
        redisCacheConfigurationMap.put(UserConstants.USER_REGISTER_PREFIX, this.getRedisCacheConfigurationWithTtl(userRegisterKeepAlive*24*3600));
        return redisCacheConfigurationMap;
    }

    /**
     * 配置key默认过期时间
     * @param seconds 时间
     * @return 配置
     */
    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofSeconds(seconds));
        return redisCacheConfiguration;
    }
}