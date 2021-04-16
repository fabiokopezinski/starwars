package br.com.b2w.starwars.domain.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PlanetRequest {
    
    @NotBlank(message = "O campo name não pode ser nulo ou vazio")
    private String name;

    @NotNull(message = "O campo climate não pode ser nulo ou vazio")
    private List<String> climate;

    @NotNull(message = "O campo terrain não pode ser nulo ou vazio")
    private List<String> terrain; 
}
