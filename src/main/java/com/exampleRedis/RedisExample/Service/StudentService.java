package com.exampleRedis.RedisExample.Service;

import com.exampleRedis.RedisExample.Entity.StudentEntity;
import com.exampleRedis.RedisExample.Model.Student;
import com.exampleRedis.RedisExample.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentRedis studentRedis;

    public Student save(Student student) {
        StudentEntity studentEntity = mapToEntity(student);
        Student result = mapToDto(studentRepository.save(studentEntity));
        result.setSaveRedis(student.isSaveRedis());
        if(result.isSaveRedis())
            result.setName(result.getName()+" SavedRedis");
        studentRedis.save(result.getId()+"", result);
        return result;
    }

    @Override
    public Student findOneById(long id) {
        Student student = studentRedis.findByKey(id+"");
        return student!=null ? student : mapToDto(studentRepository.findById(id).get());
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities.stream().map(this::mapToDto).toList();
    }

    public Student mapToDto(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setAge(studentEntity.getAge());
        return student;
    }

    public StudentEntity mapToEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        return studentEntity;
    }

}
