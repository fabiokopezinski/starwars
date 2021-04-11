package br.com.b2w.starwars.controller.query;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.starwars.annotation.PlanetGetIdCodeStandard;
import br.com.b2w.starwars.annotation.PlanetGetNameCodeStandard;
import br.com.b2w.starwars.annotation.PlanetListAllCodeStandard;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.service.query.PlanetServiceQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RequestMapping("/planets")
@AllArgsConstructor
@RestController
@Tag(name = "Planetas")
public class PlanetControllerQuery {

    private PlanetServiceQuery service;

    @PlanetListAllCodeStandard
    @GetMapping
    public ResponseEntity<Page<PlanetResponse>> findAll(
            @RequestParam(required = false, value = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, value = "limit", defaultValue = "10") int limit) {

        return ResponseEntity.ok().body(service.findAll(offset, limit));

    }

    @PlanetGetIdCodeStandard
    @GetMapping("/names/{name}")
    public ResponseEntity<PlanetResponse> findByName(@PathVariable("name") String name) throws Exception {

        return ResponseEntity.ok().body(service.findByName(name));
    }

    @PlanetGetNameCodeStandard
    @GetMapping("/{planetCode}")
    public ResponseEntity<PlanetResponse> findById(@PathVariable("planetCode") String planetCode) throws Exception {

        return ResponseEntity.ok().body(service.findById(planetCode));
    }
}
