package br.com.b2w.starwars.domain;

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
    private String climate;

    @Field(name = "TERRENO")
    private String terrain;

    @Field(name = "APARICOES_FILMES")
    private Integer filmAppearances;

    public static Page<PlanetResponse> toPage(Page<Planet> findAll) {

        return findAll.map(m -> {
            return new PlanetResponse(m.getPlanetCode(), m.getName(), m.getClimate(), m.getTerrain(),
                    m.getFilmAppearances());
        });

    }

    public PlanetResponse toDto(){
        return new PlanetResponse(this.planetCode, this.name, this.climate, this.terrain, this.filmAppearances);
    }

    public static Planet of(PlanetRequest planetRequest){
        return Planet.builder()
        .name(planetRequest.getName())
        .climate(planetRequest.getClimate())
        .terrain(planetRequest.getTerrain())
        .build();
    }

    public void setNumberAp(Integer numberAp) {
        this.filmAppearances=numberAp;
    }

}
