package com.cognizant.emergencyHelpline.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.model.User;

@Repository
public interface UserDao extends MongoRepository<User, Long> {

    User findByUsername(String username);    
}
