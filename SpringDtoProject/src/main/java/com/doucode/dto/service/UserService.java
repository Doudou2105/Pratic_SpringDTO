package com.doucode.dto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doucode.dto.dto.UserLocationDto;
import com.doucode.dto.entity.Location;
import com.doucode.dto.entity.User;
import com.doucode.dto.repository.LocationRepo;
import com.doucode.dto.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepo userRepo;

    private final LocationRepo locationRepo;

    public List<UserLocationDto> getAllUsersLocation(){
        return userRepo.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    private UserLocationDto convertEntityToDto(User user){
        UserLocationDto userLocationDTO = new UserLocationDto();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        return userLocationDTO;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(Long id) {
        return userRepo.findById(id).orElse(new User());
    }

// About the Location

    public List<Location> getAllLocations(){
        return locationRepo.findAll();
    }

    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    public Location getLocation(Long id) {
        return locationRepo.findById(id).orElse(new Location());
    }


}