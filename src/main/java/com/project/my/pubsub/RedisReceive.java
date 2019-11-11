package com.project.my.pubsub;

import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
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

    public void reveiveMessage(String message){
        SimpleDateFormat df  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(new Date()+"redis消息订阅"+message.toString());
    }
}
