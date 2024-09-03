package com.eubrunoo07.securepass.repository;

import com.eubrunoo07.securepass.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
