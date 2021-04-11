package br.com.b2w.starwars.repository.command;

import org.springframework.stereotype.Repository;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.repository.BaseCommandRepository;

@Repository
public interface PlanetCommandRepository extends BaseCommandRepository<Planet,String> {
    
    void deleteByPlanetCode(String id);
}
