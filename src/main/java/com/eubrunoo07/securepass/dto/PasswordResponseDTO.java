package com.eubrunoo07.securepass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResponseDTO {
    private String id;
    private String email;
    private String password;
    private String platform;
}
