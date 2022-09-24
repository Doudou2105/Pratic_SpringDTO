package com.doucode.dto.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private long id;
    private String place;
    private String description;
    private double longitude;
    private double latitude;
}

