package com.sushma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI nrsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NRS Integration APIs")
                        .description("Enterprise Banking Integration APIs")
                        .version("1.0.0"));
    }
}
