package com.doucode.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doucode.dto.entity.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long>{
    
}