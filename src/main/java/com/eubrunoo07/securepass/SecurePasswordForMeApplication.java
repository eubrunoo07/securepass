package com.eubrunoo07.securepass;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Secure Password for Me", version = "1.0.0v", description = "Secure password generator API"))
public class SecurePasswordForMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurePasswordForMeApplication.class, args);
	}

}
