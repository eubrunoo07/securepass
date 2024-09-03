package com.eubrunoo07.securepass.controller;

import com.eubrunoo07.securepass.dto.PasswordRequestDTO;
import com.eubrunoo07.securepass.dto.PasswordResponseDTO;
import com.eubrunoo07.securepass.exception.exceptions.PasswordNotFoundException;
import com.eubrunoo07.securepass.model.Password;
import com.eubrunoo07.securepass.model.User;
import com.eubrunoo07.securepass.service.PasswordService;
import com.eubrunoo07.securepass.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/securepass/passwords")
@CrossOrigin(originPatterns = "*")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> generatePassword(@RequestBody@Valid PasswordRequestDTO dto) throws NoSuchAlgorithmException {
        passwordService.verifyId(dto.getUser_id());
        String id = passwordService.createPassword(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasswordResponseDTO> password(@PathVariable String id){
        Password password = passwordService.findById(id).orElseThrow(() -> new PasswordNotFoundException("Password not found"));
        return ResponseEntity.status(HttpStatus.OK).body(PasswordResponseDTO
                .builder()
                .password(password.getPassword())
                .id(password.getId())
                .email(password.getEmail())
                .platform(password.getPlatform())
                .build());

    }

}
