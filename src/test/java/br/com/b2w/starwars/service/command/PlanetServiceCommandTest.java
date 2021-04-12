package br.com.b2w.starwars.service.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.exception.BusinessException;
import br.com.b2w.starwars.feature.StarWarsScenarioFactory;
import br.com.b2w.starwars.repository.command.PlanetCommandRepository;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;
import br.com.b2w.starwars.service.SwapiService;

@RunWith(MockitoJUnitRunner.class)
public class PlanetServiceCommandTest {

    @InjectMocks
    private PlanetServiceCommand service;
    
    @Mock
    private PlanetCommandRepository commandRepository;

    @Mock
    private PlanetQueryRepository queryRepository;

    @Mock
    private SwapiService swapiService;

    @Test
    public void save_WhenPlanetRequestIsValid_Expected() throws Exception{
        when(commandRepository.save(any())).thenReturn(StarWarsScenarioFactory.PLANET);
        when(queryRepository.findByName(any())).thenReturn(Optional.empty());
        when(swapiService.getFilms(any())).thenReturn(StarWarsScenarioFactory.FILMS);
        PlanetResponse planet = service.save(StarWarsScenarioFactory.PLANET_REQUEST);
        assertNotNull(planet);
        verify(commandRepository).save(any());
        verify(queryRepository).findByName(any());
    } 

    @Test(expected = BusinessException.class)
    public void save_WhenPlanetExist_ExpectedBusiness() throws Exception{
        when(queryRepository.findByName(any())).thenReturn(Optional.of(StarWarsScenarioFactory.PLANET));
        service.save(StarWarsScenarioFactory.PLANET_REQUEST);
    } 

    @Test
    public void delete_WhenIdIsValid_ExpectedNotContent() throws Exception{
        when(queryRepository.findById(any())).thenReturn(Optional.of(StarWarsScenarioFactory.PLANET));
        service.delete(StarWarsScenarioFactory.ID_VALID);
        verify(commandRepository).deleteByPlanetCode(any());
    }

    @Test(expected = BusinessException.class)
    public void delete_WhenIdIsInvalid_ExpectedNotFound() throws Exception{
        when(queryRepository.findById(any())).thenThrow(BusinessException.class);
        service.delete(StarWarsScenarioFactory.ID_VALID);
    }
}
