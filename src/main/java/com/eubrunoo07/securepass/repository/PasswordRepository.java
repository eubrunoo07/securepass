package com.eubrunoo07.securepass.repository;

import com.eubrunoo07.securepass.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, String> {
}
