package com.doucodeur.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doucodeur.entity.Student;
import com.doucodeur.entity.StudentDto;
import com.doucodeur.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
    
    private final StudentRepository SR;

    public List<Student> getStudentsA(){
        
        return SR.findAll();
    }

    public Student saveStudent(Student student) {
        return SR.save(student);
    }

    public List<StudentDto> getStudents(){
        List<Student> students = SR.findAll();
       
        List<StudentDto> studentDTOS = new ArrayList<>();
        for(int i =0;i<students.size();i++){ 

            StudentDto studentDtos = new StudentDto();

            // StudentDto studentDtos = modelMapper.map(students.get(i),StudentDTO.class);
            studentDtos.setId(students.get(i).getId());
            studentDtos.setFullName(students.get(i).getFullName());
            studentDTOS.add(studentDtos);
        }
        return studentDTOS;
    }


    public Student getStudent(Long id) {
        return SR.findById(id).orElse(new Student());
    }


}