package com.project.my.keyexpirenotice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @ClassName PubsubConfiguration
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/23 10:59
 * @Version 1.0
 */

@Configuration
public class PubsubConfiguration {

    @Bean(name="keyExpire")
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }
}
