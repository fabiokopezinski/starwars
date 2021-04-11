package br.com.b2w.starwars.domain.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlanetRequest {
    
    @NotBlank(message = "O campo name não pode ser nulo ou vazio")
    private String name;

    @NotBlank(message = "O campo climate não pode ser nulo ou vazio")
    private String climate;

    @NotBlank(message = "O campo ground não pode ser nulo ou vazio")
    private String terrain;
}
