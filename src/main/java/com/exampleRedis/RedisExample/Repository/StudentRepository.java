package com.exampleRedis.RedisExample.Repository;

import com.exampleRedis.RedisExample.Entity.StudentEntity;
import com.exampleRedis.RedisExample.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
