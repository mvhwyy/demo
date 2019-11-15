package com.project.my;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName RedisTest
 * @Description TODO
 * @Author mawei01
 * @Date 2019/10/23 17:48
 * @Version 1.0
 */
public class RedisTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {
         String key = "redis:sort";
        redisTemplate.opsForZSet().add(key,"java",99d);
        redisTemplate.opsForZSet().add(key,"js",85d);
        redisTemplate.opsForZSet().add(key,"php",60d);
        redisTemplate.opsForZSet().add(key,"c",77d);

        Set<ZSetOperations.TypedTuple<String>> set = redisTemplate.opsForZSet().rangeWithScores(key,0,1);
        List<Double> scoreList = Objects.requireNonNull(set).stream().map(ZSetOperations.TypedTuple::getScore).collect(Collectors.toList());
        System.out.println("scoreList:"+scoreList);
    }
}
