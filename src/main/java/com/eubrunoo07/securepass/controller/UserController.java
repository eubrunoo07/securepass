package com.eubrunoo07.securepass.controller;

import com.eubrunoo07.securepass.dto.UserRequestDTO;
import com.eubrunoo07.securepass.dto.UserResponseDTO;
import com.eubrunoo07.securepass.model.User;
import com.eubrunoo07.securepass.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/securepass/users")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create user", description = "Put all user information's to create your account", tags = "Users")
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequestDTO dto){
        User user = userService.dataToEntity(dto);
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/ok")
    public ResponseEntity<Object> test(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Olá, Mundo!");
    }

    @Operation(summary = "List users", description = "Get all users", tags = "Users")
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDTO>> users(){
        List<User> allUsers = userService.findAll();
        List<UserResponseDTO> response = new ArrayList<>();
        for (User allUser : allUsers) {
            UserResponseDTO responseDTO = new UserResponseDTO();
            BeanUtils.copyProperties(allUser, responseDTO);
            responseDTO.setRole(String.valueOf(allUser.getRole()));
            response.add(responseDTO);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
