package com.proman.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proman.models.User;
import com.proman.controllers.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}