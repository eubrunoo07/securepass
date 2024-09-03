package com.eubrunoo07.securepass.service.implementation;

import com.eubrunoo07.securepass.dto.PasswordRequestDTO;
import com.eubrunoo07.securepass.dto.UserRequestDTO;
import com.eubrunoo07.securepass.enums.PasswordLevel;
import com.eubrunoo07.securepass.exception.exceptions.UserNotFoundException;
import com.eubrunoo07.securepass.model.Password;
import com.eubrunoo07.securepass.model.User;
import com.eubrunoo07.securepass.repository.PasswordRepository;
import com.eubrunoo07.securepass.repository.UserRepository;
import com.eubrunoo07.securepass.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void verifyId(String id) {
        userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public String createPassword(PasswordRequestDTO dto) throws NoSuchAlgorithmException {
        User user = userRepository
                .findById(dto.getUser_id())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        String firstName = user.getName().split(" ")[0];
        String platform = dto.getPlatform();
        PasswordLevel level = PasswordLevel.valueOf(dto.getLevel());
        Password password = new Password();
        password.setUser_email(user.getEmail());
        String pass;
        if(level == PasswordLevel.SAFE){
            pass = (firstName + "#" + platform + new Random().nextInt(10000, 50000)).replace(" ", ".");
        }
        else if(level == PasswordLevel.VERY_SAFE){
            pass = (firstName + "@" + hashPassword(firstName, getSalt())).replace(" ", ".");
        }
        else{
            pass = (hashPassword(firstName.concat(platform), getSalt())).replace(" ", ".");
        }
        password.setPassword(pass);
        password.setPasswordLevel(level);
        passwordRepository.save(password);
        return password.getId();
    }

    @Override
    public Optional<Password> findById(String id) {
        return passwordRepository.findById(id);
    }

    public static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        byte[] truncatedHash = new byte[hashedPassword.length / 4];
        System.arraycopy(hashedPassword, 0, truncatedHash, 0, truncatedHash.length);
        return Base64.getEncoder().encodeToString(truncatedHash);
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

}
