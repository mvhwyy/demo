package com.project.my.pubsub;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedisMessageSchedule
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/24 18:26
 * @Version 1.0
 */
@EnableScheduling
@Component
public class RedisMessageSchedule {

    @Resource
    private StringRedisTemplate redisTemplate;

//    @Scheduled(fixedDelay = 3000)
    public void sendMessage(){
        redisTemplate.convertAndSend("test","result");
        redisTemplate.convertAndSend("test1","result1");
    }
}
