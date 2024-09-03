package com.eubrunoo07.securepass.model;

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
    @Column
    private String email;
    @Column
    private String platform;

}
