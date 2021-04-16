package br.com.b2w.starwars.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@Configuration
@OpenAPIDefinition(
		  info = @Info(
		  title = "Api dos planetas de Star Wars",
		  description = " May the force be with you! ",
		  contact = @Contact(
		    name = "Fábio Kopezinski",  
		    email = "fabiokopezinski@gmail.com"
		  ),
          version = "1.0.0"),
		  servers={@Server(url="https://star-wars-api-b2w.herokuapp.com/v1"),@Server(url="http://localhost:8081/v1")})
         
public class Swagger {
    
}
