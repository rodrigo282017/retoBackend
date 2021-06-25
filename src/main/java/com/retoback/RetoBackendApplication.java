package com.retoback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class RetoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoBackendApplication.class, args);
	}

}
