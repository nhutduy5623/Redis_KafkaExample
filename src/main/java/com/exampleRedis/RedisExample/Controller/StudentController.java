package com.exampleRedis.RedisExample.Controller;

import com.exampleRedis.RedisExample.Model.Student;
import com.exampleRedis.RedisExample.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentService.save(student);
        kafkaTemplate.send("add_student", student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findOneById(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody Student student) {
        studentService.save(student);
    }

}
