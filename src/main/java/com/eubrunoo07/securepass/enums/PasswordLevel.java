package com.eubrunoo07.securepass.enums;

import lombok.Getter;

@Getter
public enum PasswordLevel {
    SAFE("Safe"),
    VERY_SAFE("Very safe"),
    HARD_PASS("Hard Pass");

    private final String passLevel;

    PasswordLevel(String passLevel) {
        this.passLevel = passLevel;
    }
}
