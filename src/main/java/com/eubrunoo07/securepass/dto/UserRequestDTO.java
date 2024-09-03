package com.eubrunoo07.securepass.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "Name field is missing")
    private String name;
    @NotBlank(message = "Username field is missing")
    private String username;
    @NotBlank(message = "Email field is missing")
    @Email(message = "Email is invalid")
    private String email;
    @NotBlank(message = "Password field is missing")
    private String password;
}
