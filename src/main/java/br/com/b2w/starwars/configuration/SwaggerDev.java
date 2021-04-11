package br.com.b2w.starwars.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@Configuration
@Profile("dev")
@OpenAPIDefinition(
		  info = @Info(
		  title = "Api de Star Wars",
		  description = "Api dos planetas" +
		    "Documentção da api ",
		  contact = @Contact(
		    name = "Fábio Kopezinski",  
		    email = "fabiokopezinski@gmail.com"
		  ),
          version = "1.0.0",
          license = @License(
		    url = "https://github.com/fabiokopezinski/starwars")),
		  servers = @Server(url = "http://localhost:8081/v1"))
public class SwaggerDev {
    
}
