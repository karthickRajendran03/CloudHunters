package com.cognizant.emergencyHelpline.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacadeService {

    Authentication getAuthentication();
}
