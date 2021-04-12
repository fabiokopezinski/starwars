package br.com.b2w.starwars.feature;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.b2w.starwars.domain.Planet;
import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;

public class StarWarsScenarioFactory {

    public static final int OFFSET=0;
    public static final int LIMIT=10;
    public static final String ID_VALID = "4721384732814";
    public static final String NAME_VALID = "TESTE";
    public static final String NAME_INVALID = "TESwTE";
    public static final String NOT_VALID = "$$$";
    public static final PlanetResponse PLANET_RESPONSE = loadPlanetResponse();
    public static final Planet PLANET = loadPlanet();
    public static final PlanetRequest PLANET_REQUEST = loadPlanetRequest();
    public static final Page<Planet> PLANET_ALL = loadPlanetAll();
    public static final Page<PlanetResponse> PLANET_ALL_RESPONSE = loadPlanetAllResponse();

    public static final Integer FILMS=12;

    private static PlanetResponse loadPlanetResponse() {
        return new PlanetResponse("4721384732814", "TESTE", "desert", "arid", 12);
    }

    private static Page<PlanetResponse> loadPlanetAllResponse() {
        PageRequest page = PageRequest.of(0, 10);

        List<PlanetResponse> list = new ArrayList<>();

        list.add(loadPlanetResponse());

        return new PageImpl<>(list, page, 10);
    }

    private static Page<Planet> loadPlanetAll() {

        PageRequest page = PageRequest.of(0, 10);

        List<Planet> list = new ArrayList<>();

        list.add(loadPlanet());

        return new PageImpl<>(list, page, 10);
    }

    private static Planet loadPlanet() {
        return new Planet("4721384732814", "TESTE", "desert", "arid", 12);
    }

    private static PlanetRequest loadPlanetRequest() {
        return new PlanetRequest("TESTE", "desert", "terrain");
    }
}
