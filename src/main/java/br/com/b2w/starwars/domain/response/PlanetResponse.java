package br.com.b2w.starwars.domain.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlanetResponse {
    
    
    private String planetCode;
       
    private String name;
    
    private List<String> climate;
   
    private List<String> terrain;

    private Integer filmAppearances;
}
