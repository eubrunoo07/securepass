package com.eubrunoo07.securepass.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_tb")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

}
