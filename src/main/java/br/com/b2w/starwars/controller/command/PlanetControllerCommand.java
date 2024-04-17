package br.com.b2w.starwars.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.starwars.annotation.PlanetDeleteCodeStandard;
import br.com.b2w.starwars.annotation.PlanetSaveCodeStandard;
import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.service.command.PlanetServiceCommand;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RequestMapping("/planets")
@AllArgsConstructor
@RestController
@Tag(name = "Planetaas")
public class PlanetControllerCommand {

    private PlanetServiceCommand command;

    @PlanetSaveCodeStandard
    @PostMapping
    public ResponseEntity<PlanetResponse> save(@RequestBody PlanetRequest planetRequest) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(command.save(planetRequest));
    }

    @PlanetDeleteCodeStandard
    @DeleteMapping("/{planetCode}")
    public ResponseEntity<Void> delete(@PathVariable("planetCode") String planetCode) throws Exception {

        command.delete(planetCode);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
