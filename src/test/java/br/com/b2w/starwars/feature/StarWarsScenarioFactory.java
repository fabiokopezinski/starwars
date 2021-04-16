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
    public static final Planet PLANET_BDD=loadPlanetBDD();
    public static final Planet PLANET_BDD_TWO=loadPlanetBDDTwo();
    public static final PlanetRequest PLANET_REQUEST_BDD=loadPlanetRequestBDD();

    public static final Integer FILMS=12;

    private static PlanetResponse loadPlanetResponse() {
    	
    	List<String> climates=new ArrayList<>();
    	climates.add("desert");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("arid");
    	
        return new PlanetResponse("4721384732814", "TESTE", climates, terrains, 12);
    }

    private static PlanetRequest loadPlanetRequestBDD() {
    	
    	List<String> climates=new ArrayList<>();
    	climates.add("temperate");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("grasslands");
    	terrains.add("mountains");
    	
		return new PlanetRequest("Alderaan",climates,terrains);
	}

	private static Planet loadPlanetBDDTwo() {
		
		List<String> climates=new ArrayList<>();
    	climates.add("murky");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("swamp");
    	terrains.add("jungles");
		
        return new Planet("999", "Dagobah",climates, terrains, 12);
    }

    private static Planet loadPlanetBDD() {
    	
    	List<String> climates=new ArrayList<>();
    	climates.add("temperate");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("forests");
    	terrains.add("mountains");
    	terrains.add("lakes");
    	
        return new Planet("9999", "Endor",climates, terrains, 12);
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
    	
    	List<String> climates=new ArrayList<>();
    	climates.add("desert");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("arid");
    	
        return new Planet("4721384732814", "TESTE", climates, terrains, 12);
    }

    private static PlanetRequest loadPlanetRequest() {
    	
    	List<String> climates=new ArrayList<>();
    	climates.add("desert");
    	
    	List<String> terrains=new ArrayList<>();
    	terrains.add("terrain");
    	
        return new PlanetRequest("TESTE", climates, terrains);
    }
}
