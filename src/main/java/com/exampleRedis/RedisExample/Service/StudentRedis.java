package com.exampleRedis.RedisExample.Service;

import com.exampleRedis.RedisExample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentRedis extends RedisService<Student>{
    @Autowired
    public StudentRedis(RedisTemplate<Object, Object> redisTemplate) {
        super(redisTemplate);
        super.HASH_KEY = "STUDENT";
    }
}
