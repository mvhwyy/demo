package com.project.my.keyexpirenotice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RedisMessageListener
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/23 10:57
 * @Version 1.0
 */
@Configuration
public class RedisMessageListener extends KeyExpirationEventMessageListener {

    public RedisMessageListener(@Qualifier("keyExpire") RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        SimpleDateFormat df  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(df.format(new Date())+"收到key过期事件，开始业务处理，过期key:"+message.toString());
    }
}
