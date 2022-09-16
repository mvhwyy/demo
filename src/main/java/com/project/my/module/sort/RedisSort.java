package com.project.my.module.sort;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RedisSort
 * @Description redis排序
 * @Author mawei
 * @Date 2019/11/14 7:11 下午
 * @Version 1.0
 */
@Service
public class RedisSort {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void sort() {
        String key = "redis:sort";
        Map<String, Double> map = new HashMap<>(10);
        map.put("java", 99d);
        map.put("js", 85d);
        map.put("php", 60d);
        map.put("C", 77d);
        redisTemplate.opsForZSet().add(key,"java",99d);
        redisTemplate.opsForZSet().add(key,"js",85d);
        redisTemplate.opsForZSet().add(key,"php",60d);
        redisTemplate.opsForZSet().add(key,"c",77d);

        redisTemplate.opsForZSet().rangeWithScores(key,0,1);

    }


}
