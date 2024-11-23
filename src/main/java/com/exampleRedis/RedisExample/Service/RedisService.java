package com.exampleRedis.RedisExample.Service;


import com.exampleRedis.RedisExample.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisService<T> {
    protected String HASH_KEY = "Normal";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private HashOperations<Object, String, T> hashOperations;


    @Autowired
    public RedisService(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(String key, T model) {
        hashOperations.put(HASH_KEY, key, model);
    }

    public Map<String, T> findAll() {
        return hashOperations.entries(HASH_KEY);
    }

    public T findByKey(String id) {
        return hashOperations.get(HASH_KEY, id);
    }

    public void update(String key, T model) {
        save(key, model);
    }

    public void delete(String key) {
        hashOperations.delete(HASH_KEY, key);
    }
}