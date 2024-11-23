package com.exampleRedis.RedisExample.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private int age;
    private boolean saveRedis = false;
}