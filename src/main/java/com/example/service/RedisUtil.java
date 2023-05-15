package com.example.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil {
    
    @Autowired StringRedisTemplate stringRedisTemplate;

    // key를 통해 value를 return
    public String getData(String key) {

        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);

    }

    // 유효시간 동안 (key, value 저장)
    public void setDataExpire(String key, String value, long duration) {
        
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);

    }

    // Data 삭제
    public void deleteDta(String key) {
        stringRedisTemplate.delete(key);
    }

}
