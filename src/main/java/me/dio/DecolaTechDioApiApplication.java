package me.dio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition (servers = {@Server(url = "/", description = "Local Server")})
@SpringBootApplication
public class DecolaTechDioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecolaTechDioApiApplication.class, args);
	}

}
