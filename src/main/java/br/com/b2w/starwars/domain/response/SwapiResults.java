package br.com.b2w.starwars.domain.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SwapiResults {
    
    private List<SwapiResponse>results;
}
