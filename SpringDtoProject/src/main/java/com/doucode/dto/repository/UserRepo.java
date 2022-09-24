package com.doucode.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doucode.dto.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    
}