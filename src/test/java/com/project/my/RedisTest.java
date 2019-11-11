package com.project.my;

import org.assertj.core.util.DateUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/23 17:48
 * @Version 1.0
 */
public class RedisTest {

    @Test
    public void test() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.setex("key-expire-notice", 2, "过期key通知事件");
        SimpleDateFormat df  =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(df.format(new Date())+"设置key过期");
    }
}
