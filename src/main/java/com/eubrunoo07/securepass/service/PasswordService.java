package com.eubrunoo07.securepass.service;

import com.eubrunoo07.securepass.dto.PasswordRequestDTO;
import com.eubrunoo07.securepass.dto.UserRequestDTO;
import com.eubrunoo07.securepass.model.Password;
import com.eubrunoo07.securepass.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface PasswordService {
    void verifyId(String id);

    String createPassword(PasswordRequestDTO user) throws NoSuchAlgorithmException;

    Optional<Password> findById(String id);
}
