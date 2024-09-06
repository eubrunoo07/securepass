package com.eubrunoo07.securepass.controller;

import com.eubrunoo07.securepass.dto.UserLoginRequestDTO;
import com.eubrunoo07.securepass.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/securepass/auth")
@CrossOrigin(originPatterns = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> login(@RequestBody UserLoginRequestDTO dto){
        var authenticationUserToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        authenticationManager.authenticate(authenticationUserToken);
        var token = authService.generateToken(dto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

}
