package com.eubrunoo07.securepass.service;

import com.eubrunoo07.securepass.dto.UserRequestDTO;
import com.eubrunoo07.securepass.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User dataToEntity(UserRequestDTO dto);
    User save(User user);
    Optional<User> findById(String id);
    void createUser(User user);

    List<User> findAll();
}
