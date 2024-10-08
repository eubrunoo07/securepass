package com.eubrunoo07.securepass.service.implementation;

import com.eubrunoo07.securepass.dto.PasswordRequestDTO;
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
import java.time.LocalDate;
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
        String keyword = dto.getKeyword();
        Password password = new Password();
        String pass;

        int length = dto.getCharactersQuantity();
        if (length < 6) {
            length = 6;
        }

        String baseString;
        if (dto.isUseSpecialCharacters()) {
            baseString = firstName.substring(0, firstName.length()/2) + "#" + LocalDate.now().getDayOfMonth() + keyword + new Random().nextInt(10000, 50000);
        } else {
            baseString = firstName.substring(0, firstName.length()/2) + LocalDate.now().getDayOfMonth() + keyword + new Random().nextInt(10000, 50000);
        }

        baseString = baseString.replace(" ", "");
        if (baseString.length() < length) {
            while (baseString.length() < length) {
                baseString += new Random().nextInt(10);
            }
        } else if (baseString.length() > length) {
            baseString = baseString.substring(0, length);
        }

        pass = baseString.replace(" ", "");
        if (pass.length() < length) {
            while (pass.length() < length) {
                pass += new Random().nextInt(10);
            }
        } else if (pass.length() > length) {
            pass = pass.substring(0, length);
        }

        password.setPassword(pass);
        password.setEmail(dto.getEmail());
        password.setPlatform(dto.getPlatform());
        passwordRepository.save(password);
        return password.getId();
    }

    @Override
    public Optional<Password> findById(String id) {
        return passwordRepository.findById(id);
    }

    public static String hashPassword(String password, byte[] salt, boolean useSpecialCharacters) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        byte[] truncatedHash = new byte[hashedPassword.length / 2];
        System.arraycopy(hashedPassword, 0, truncatedHash, 0, truncatedHash.length);
        String encodedHash = Base64.getEncoder().encodeToString(truncatedHash);

        if (!useSpecialCharacters) {
            encodedHash = encodedHash.replaceAll("[^a-zA-Z0-9]", "");
        }

        return encodedHash;
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

}
