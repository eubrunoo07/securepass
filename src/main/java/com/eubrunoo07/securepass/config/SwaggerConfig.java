package com.eubrunoo07.securepass.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI securePassOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Secure Pass for Me")
                        .version("1.0.0v")
                        .license(new License().name("Secure Pass License")
                                .url("www.github.com/eubrunoo07/securepass")));
    }

}
