package com.cognizant.emergencyHelpline.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cognizant.emergencyHelpline.service.AuthenticationFacadeService;

@Component
public class AuthenticationFacadeServiceImpl implements AuthenticationFacadeService {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
