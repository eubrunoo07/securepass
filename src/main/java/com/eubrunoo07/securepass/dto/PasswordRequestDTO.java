package com.eubrunoo07.securepass.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequestDTO {

    @NotBlank(message = "User id field is missing")
    private String user_id;
    @NotBlank(message = "Email field is missing")
    @Email(message = "Email is invalid")
    private String email;
    @NotBlank(message = "Keyword field is missing")
    private String keyword;
    @NotBlank(message = "Platform field is missing")
    private String platform;
    @NotNull(message = "Special Characters field is missing")
    private boolean useSpecialCharacters;
    @NotNull(message = "Characters quantity field is missing")
    @Min(1)
    private Integer charactersQuantity;

    @NotBlank(message = "Level field is missing")
    private String level;


}
