package com.doucodeur.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doucodeur.entity.Course;
import com.doucodeur.entity.CourseDto;
import com.doucodeur.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository CR;


    public List<Course> getCouresA(){

        return CR.findAll();
    }


    public Course saveCourse(Course course) {
        return CR.save(course);
    }


    public List<CourseDto> getCourses(){
        List<Course> courses = CR.findAll();
        List<CourseDto> courseDTOS = new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            CourseDto courseDtos = new CourseDto();
            courseDtos.setId(courses.get(i).getId());
            courseDtos.setName(courses.get(i).getName());
            courseDtos.setCost(courses.get(i).getCost());
            courseDTOS.add(courseDtos);
        }
        return courseDTOS;
    }

    public Course getCourse(Long id) {
        return CR.findById(id).orElse(new Course());
    }

}