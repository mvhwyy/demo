package com.project.my.pubsub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @ClassName RedisListenerConfig
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/24 18:10
 * @Version 1.0
 */
@Configuration
public class RedisListenerConfig {

    /**
     * redis的消息监听容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息处理器和相应的消息订阅处理器绑定
     * 容器需要连接工厂以及消息处理器，在消息监听器中需要配置消息处理对象以及处理的方法
     *
     * @param redisConnectionFactory 连接工厂
     * @param messageListenerAdapter 消息监听器
     * @return 消息监听容器
     */
    @Bean(name="redisMessageListenerContainer")
    RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        //连接redis消息工厂
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        //订阅topic的topic，可以订阅多个
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("test"));
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("test1"));
        return redisMessageListenerContainer;
    }

    /**
     * redis的消息处理器适配器，绑定了消息处理器，通过反射的方法获取消息处理器的方法
     *
     * @param redisReceive 消息处理器
     * @return 消息处理器适配器
     */
    @Bean
    MessageListenerAdapter messageListenerAdapter(RedisReceive redisReceive) {
        //给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”。也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(redisReceive, "reveiveMessage");
    }

    /**
     * 使用默认的连接工厂初始化 StringRedisTemplate
     * @param connectionFactory 连接工厂
     * @return 初始化结果
     */
    @Bean
    StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }


}
