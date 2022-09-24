package com.doucode.dto.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doucode.dto.dto.UserLocationDto;
import com.doucode.dto.entity.Location;
import com.doucode.dto.entity.User;
import com.doucode.dto.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v01/")
public class UserController {

    
    private final UserService userService;


     @GetMapping("/users-location")
     public List<UserLocationDto> getAllUsersLocation(){
         return userService.getAllUsersLocation();
     }

    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }


    @PostMapping("/add-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
      return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
      
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    // that will Controlled the location

    @GetMapping("/locations")
    public List<Location> getAllLocations(){
        return userService.getAllLocations();
    }
    
    @PostMapping("/addLocation")
    public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
        return new ResponseEntity<>(userService.saveLocation(location), HttpStatus.CREATED);
    }

    @GetMapping("/find/location/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getLocation(id));
    }

}