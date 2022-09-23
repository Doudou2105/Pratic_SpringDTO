package com.doucodeur.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentDto {
    
    private Long id;

    private String fullName;
}