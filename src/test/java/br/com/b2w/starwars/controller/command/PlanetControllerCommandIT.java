package br.com.b2w.starwars.controller.command;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.repository.command.PlanetCommandRepository;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("TEST")
@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlanetControllerCommandIT {

    @Autowired
    private PlanetQueryRepository planetQueryRepository;

    @Autowired
    private PlanetCommandRepository planetCommandRepository;

    @BeforeAll
    public void setup(){

        Planet planet = Planet.builder().name("Teste")
                .climate(List.of("teste"))
                .terrain(List.of("testes"))
                .filmAppearances(1).build();

        this.planetCommandRepository.save(planet);
    }

    @Test
    public void teste(){
        PageRequest page = PageRequest.of(0, 10);
        Page<Planet> planet = this.planetQueryRepository.findAll(page);
        Assertions.assertEquals("Teste",planet.getContent().get(0).getName());
    }
}
