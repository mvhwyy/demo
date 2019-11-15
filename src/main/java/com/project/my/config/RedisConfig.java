package com.project.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.serializer.DefaultSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisConfig
 * @Description redis配置
 * @Author mawei
 * @Date 2019/11/15 7:09 下午
 * @Version 1.0
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redis = new StringRedisTemplate();

        redis.setConnectionFactory(redisConnectionFactory);

        // 设置redis的String/value的默认序列化方式
//        DefaultSerializer stringRedisSerializer = new DefaultSerializer();
//        redis.setKeySerializer(stringRedisSerializer);
//        redis.setValueSerializer(stringRedisSerializer);
//        redis.setHashKeySerializer(stringRedisSerializer);
//        redis.setHashValueSerializer(stringRedisSerializer);

        redis.afterPropertiesSet();

        return redis;
    }
}
