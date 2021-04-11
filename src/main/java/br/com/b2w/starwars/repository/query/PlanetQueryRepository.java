package br.com.b2w.starwars.repository.query;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.repository.BaseQueryRepository;

@Repository
public interface PlanetQueryRepository extends BaseQueryRepository<Planet,String> {
    
    Page<Planet> findAll(Pageable page);

    Optional<Planet> findById(String id);

    @Query(" { name: { $regex : '(?i)?0'}} ")
    Optional<Planet> findByName(String name);

    
}
