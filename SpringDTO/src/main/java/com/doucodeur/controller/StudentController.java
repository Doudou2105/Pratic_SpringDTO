package com.doucodeur.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doucodeur.entity.Student;
import com.doucodeur.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/s1/student")
public class StudentController {
    
    private final StudentService service;

    @GetMapping("/all")
    public List<Student> getAllStudents(){

        return service.getStudentsA();
    }

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudent(id));
    }

}