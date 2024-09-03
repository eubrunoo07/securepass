package com.eubrunoo07.securepass.dto;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Level field is missing")
    private String level;
    @NotBlank(message = "Platform field is missing")
    private String platform;

}
