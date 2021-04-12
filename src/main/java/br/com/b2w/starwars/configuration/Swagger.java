package br.com.b2w.starwars.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
@OpenAPIDefinition(
		  info = @Info(
		  title = "Api dos planetas de Star Wars",
		  description = " May the force be with you! ",
		  contact = @Contact(
		    name = "Fábio Kopezinski",  
		    email = "fabiokopezinski@gmail.com"
		  ),
          version = "1.0.0",
          license = @License(
		    url = "https://github.com/fabiokopezinski/starwars")))
public class Swagger {
    
	@Value("${server.port}")
	private String port;

	@Value("${server.servlet.context-path}")
	private String path;

	@Bean
	public OpenAPI customOpenAPI() {
		Server server=new Server();
		server.setUrl("https://star-wars-api-b2w.herokuapp.com/v1:"+port+path);
		server.setDescription("Local");
		return new OpenAPI()

				.components(new Components())
				.servers(Arrays.asList(server));

	}
}
