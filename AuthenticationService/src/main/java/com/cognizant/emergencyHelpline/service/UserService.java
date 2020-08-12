package com.cognizant.emergencyHelpline.service;

import java.util.List;

import com.cognizant.emergencyHelpline.dto.UserDto;
import com.cognizant.emergencyHelpline.model.User;

public interface UserService {

    UserDto save(UserDto user);
    List<UserDto> findAll();
    User findOne(String userName);    
}
