package com.project.my.module.pubsub;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName RedisReceive
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/24 18:14
 * @Version 1.0
 */
@Configuration
public class RedisReceive {

    public void reveiveMessage(String message) {
        System.out.println(new Date() + "redis消息订阅:" + message + LocalDateTime.now());
    }
}
