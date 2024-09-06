package com.eubrunoo07.securepass.service;

import com.eubrunoo07.securepass.dto.UserLoginRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    String generateToken(UserLoginRequestDTO dto);
    String validateToken(String token);

}
