package br.com.b2w.starwars.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.repository.command.PlanetCommandRepository;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = "spring.config.location=classpath:application-test.yml")
public class PlanetStartScenario extends AbstractSteps{


    @Autowired
    private PlanetCommandRepository repository;
    
    @Autowired
    private PlanetQueryRepository repositoryQuery;

    @Before("@save")
    public void before(Scenario scenario){
       
        if(testContext().get(scenario.getId())==null){
            testContext().set(scenario.getId(),null);
            
            try {
                log.info("Init - beforeEverthing");
                
                repository.save(StarWarsScenarioFactory.PLANET_BDD);
                repository.save(StarWarsScenarioFactory.PLANET_BDD_TWO);

                log.info("End - beforeEverthing");
                
            } catch (Exception e) {
                log.error("error={}", e.getCause());
            }
        }
    }

    @After("@delete")
    public void after(Scenario scenario){

        try {
            log.info("Init - after");

            repository.deleteByPlanetCode(StarWarsScenarioFactory.PLANET_BDD.getPlanetCode());
            repository.deleteByPlanetCode(StarWarsScenarioFactory.PLANET_BDD_TWO.getPlanetCode());
            Planet planet = repositoryQuery.findByName(StarWarsScenarioFactory.PLANET_REQUEST_BDD.getName()).get();
            repository.deleteByPlanetCode(planet.getPlanetCode());
            
            log.info("End - after");

        } catch (Exception e) {
            log.error("error={}", e.getCause());
        }
    }

}
