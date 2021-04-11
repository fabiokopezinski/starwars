package br.com.b2w.starwars.service.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;
import br.com.b2w.starwars.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PlanetServiceQuery {

    private PlanetQueryRepository repository;

    public Page<PlanetResponse> findAll(int offeset, int limit) {

        PageRequest page = PageRequest.of(offeset, limit);

        Page<Planet> findAll = repository.findAll(page);

        log.info("method=findAll offeset={} limit={}", offeset, limit);

        return Planet.toPage(findAll);
    }

    public PlanetResponse findById(String id) throws Exception{

        Planet planet = repository.findById(id).orElseThrow(Message.NOT_FOUND_PLANET::asBusinessException);

        log.info("method=findById planetCode={}",planet.getPlanetCode());

        return planet.toDto();
    }

    public PlanetResponse findByName(String name)throws Exception {

        Planet planet = repository.findByName(name).orElseThrow(Message.NOT_FOUND_PLANET::asBusinessException);

        log.info("method=findByName name={}",planet.getName());

        return planet.toDto();
    }

}
