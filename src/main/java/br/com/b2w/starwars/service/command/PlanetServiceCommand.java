package br.com.b2w.starwars.service.command;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.repository.command.PlanetCommandRepository;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;
import br.com.b2w.starwars.service.SwapiService;
import br.com.b2w.starwars.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
@Validated
public class PlanetServiceCommand {

    private PlanetCommandRepository commandRepository;

    private PlanetQueryRepository queryRepository;

    private SwapiService service;

    public PlanetResponse save(@Valid PlanetRequest planetRequest) throws Exception {

        Planet planet = Planet.of(planetRequest);

        queryRepository.findByName(planet.getName()).ifPresent(m -> {
            throw Message.PLANET_EXIST.asBusinessException();
        });

        planet.setNumberAp(service.getFilms(planet.getName()));

        Planet planetSave = commandRepository.save(planet);

        log.info("method=save planetCode={}", planetSave.getPlanetCode());

        return planetSave.toDto();
    }

    public void delete(String id) throws Exception {

        queryRepository.findById(id).orElseThrow(Message.NOT_FOUND_PLANET::asBusinessException);

        commandRepository.deleteByPlanetCode(id);

        log.info("method=delete planetCode={}", id);

    }
}
