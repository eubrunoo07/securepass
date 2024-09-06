package com.eubrunoo07.securepass.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequestDTO {
    @NotBlank(message = "Email field is missing")
    @Email(message = "Email is invalid")
    private String email;
    @NotBlank(message = "Password field is missing")
    private String password;
}
