package com.exampleRedis.RedisExample.Service;

import com.exampleRedis.RedisExample.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    public Student save(Student student);
    public Student findOneById(long id);
    public List<Student> findAll();
}
