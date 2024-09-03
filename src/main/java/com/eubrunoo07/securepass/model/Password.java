package com.eubrunoo07.securepass.model;

import com.eubrunoo07.securepass.enums.PasswordLevel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "password_tb")
@Data
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private PasswordLevel passwordLevel;
    @Column
    private String user_email;

}
