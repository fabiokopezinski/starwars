package br.com.b2w.starwars.domain.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SwapiResponse {
    
    private String name;
    private List<String> films;
}
