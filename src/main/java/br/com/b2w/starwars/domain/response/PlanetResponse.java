package br.com.b2w.starwars.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlanetResponse {
    
    
    private String planetCode;
       
    private String name;
    
    private String climate;
   
    private String terrain;

    private Integer filmAppearances;
}
