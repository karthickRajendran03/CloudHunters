package com.cognizant.emergencyHelpline.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.emergencyHelpline.dao.UserDao;
import com.cognizant.emergencyHelpline.dto.UserDto;
import com.cognizant.emergencyHelpline.model.User;
import com.cognizant.emergencyHelpline.service.UserService;


@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

    private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}


    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(user -> users.add(user.toUserDto()));
        return users;
    }

    @Override
    public User findOne(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User userWithDuplicateUsername = userDao.findByUsername(userDto.getUsername());
        if(userWithDuplicateUsername != null && userDto.getUsername() != userWithDuplicateUsername.getUsername()) {
            log.error(String.format("Duplicate username %", userDto.getUsername()));
            throw new RuntimeException("Duplicate username.");
        }        
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));        
        user.setRoles(userDto.getRoles());
        user.setLastUpdatedTime(new Date());
        userDao.save(user);
        return userDto;
    }
}
