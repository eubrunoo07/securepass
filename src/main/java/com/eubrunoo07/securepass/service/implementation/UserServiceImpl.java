package com.eubrunoo07.securepass.service.implementation;

import com.eubrunoo07.securepass.dto.UserRequestDTO;
import com.eubrunoo07.securepass.exception.exceptions.EmailAlreadyExistsException;
import com.eubrunoo07.securepass.exception.exceptions.EmailAndUsernameAlreadyExistsException;
import com.eubrunoo07.securepass.exception.exceptions.PasswordFormatIsInvalidException;
import com.eubrunoo07.securepass.exception.exceptions.UsernameAlreadyExistsException;
import com.eubrunoo07.securepass.model.User;
import com.eubrunoo07.securepass.repository.UserRepository;
import com.eubrunoo07.securepass.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User dataToEntity(UserRequestDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        else if(userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists");
        }
        else if(userRepository.existsByEmail(user.getEmail()) && userRepository.existsByUsername(user.getUsername())){
            throw new EmailAndUsernameAlreadyExistsException("Email and Username already exists");
        }
        else{
            String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{8,}$";
            if(user.getPassword().matches(REGEX_PASSWORD)){
                this.save(user);
            }
            else{
                throw new PasswordFormatIsInvalidException("Password format is invalid");
            }
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
