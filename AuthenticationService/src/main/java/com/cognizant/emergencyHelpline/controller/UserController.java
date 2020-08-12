package com.cognizant.emergencyHelpline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.emergencyHelpline.dto.UserDto;
import com.cognizant.emergencyHelpline.model.User;
import com.cognizant.emergencyHelpline.service.AuthenticationFacadeService;
import com.cognizant.emergencyHelpline.service.UserService;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;

    @Secured({ROLE_ADMIN})	
    @GetMapping(value = "/getAllPatientsHospitalsForAnalytics")
    public ResponseEntity<Object> listUser(){
        log.info(String.format("received request to list user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        List<UserDto> userDetails = userService.findAll();
        return CollectionUtils.isEmpty(userDetails) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto user){   
    	 log.info(String.format("received request to register user"));
        UserDto saveUser = userService.save(user);
        return ObjectUtils.isEmpty(saveUser) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(saveUser, HttpStatus.OK);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @GetMapping(value = "/getUserData/{userName}")
    public ResponseEntity<Object> getUserData(@PathVariable String userName){
        log.info(String.format("received request to get user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        User userDetails = userService.findOne(userName);
        return ObjectUtils.isEmpty(userDetails) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
 
}
