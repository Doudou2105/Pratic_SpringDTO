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

import com.doucodeur.entity.Course;
import com.doucodeur.service.CourseService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/c1/course")
public class CourseController {
    
    private final CourseService service;

    @GetMapping("/all")
    public List<Course> getAllCourses(){

        return service.getCouresA();
    }
    
    @PostMapping("/add")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(service.saveCourse(course), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCourse(id));
    }
}