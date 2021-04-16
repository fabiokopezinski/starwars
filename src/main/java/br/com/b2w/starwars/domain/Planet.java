package br.com.b2w.starwars.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Document(collection = "planet")
public class Planet {

	@Id
	private String planetCode;

	@Indexed(unique = true)
	@Field(name = "NOME")
	private String name;

	@Field(name = "CLIMA")
	private List<String> climate;

	@Field(name = "TERRENO")
	private List<String> terrain;

	@Field(name = "APARICOES_FILMES")
	private Integer filmAppearances;

	public static Page<PlanetResponse> toPage(Page<Planet> findAll) {

		return findAll.map(m -> {

			return new PlanetResponse(m.getPlanetCode(), m.getName(), m.getClimate(), m.getTerrain(),
					m.getFilmAppearances());
		});

	}

	public PlanetResponse toDto() {
		return new PlanetResponse(this.planetCode, this.name, this.climate, this.terrain, this.filmAppearances);
	}

	public void of(PlanetRequest planetRequest) {

		this.name = planetRequest.getName();

		if (this.terrain == null) {
			this.terrain = new ArrayList<>();
		}

		this.terrain.addAll(planetRequest.getTerrain());

		if (this.climate == null) {
			this.climate = new ArrayList<>();
		}

		this.climate.addAll(planetRequest.getClimate());

	}

	public void setNumberAp(Integer numberAp) {
		this.filmAppearances = numberAp;
	}

}
