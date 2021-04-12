package br.com.b2w.starwars.service.query;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.b2w.starwars.domain.response.PlanetResponse;
import br.com.b2w.starwars.exception.BusinessException;
import br.com.b2w.starwars.feature.StarWarsScenarioFactory;
import br.com.b2w.starwars.repository.query.PlanetQueryRepository;

@RunWith(MockitoJUnitRunner.class)
public class PlanetServiceQueryTest {
    
    @InjectMocks
    private PlanetServiceQuery service;

    @Mock
    private PlanetQueryRepository repository;

    
    @Test
    public void findAll(){
        when(repository.findAll(any(Pageable.class))).thenReturn(StarWarsScenarioFactory.PLANET_ALL);
        Page<PlanetResponse> planet = service.findAll(StarWarsScenarioFactory.OFFSET, StarWarsScenarioFactory.LIMIT);
        assertNotNull(planet);
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    public void findById_WhenIdIsValid_ExpectedOk() throws Exception{
        when(repository.findById(any())).thenReturn(Optional.of(StarWarsScenarioFactory.PLANET));
        PlanetResponse planet = service.findById(StarWarsScenarioFactory.ID_VALID);
        assertNotNull(planet);
        verify(repository).findById(any());
    }

    @Test(expected = BusinessException.class)
    public void findById_WhenIdIsInvalid_ExpectedNotOk() throws Exception{
        when(repository.findById(any())).thenThrow(BusinessException.class);
        service.findById(StarWarsScenarioFactory.NOT_VALID);
    }

    @Test
    public void findByName_WhenIsValid_ExpectedOk() throws Exception{
        when(repository.findByName(any())).thenReturn(Optional.of(StarWarsScenarioFactory.PLANET));
        PlanetResponse planet = service.findByName(StarWarsScenarioFactory.NAME_VALID);
        assertNotNull(planet);
        verify(repository).findByName(any());
    }

    @Test(expected = BusinessException.class)
    public void findByName_WhenIsInvalid_ExpectedNotOk() throws Exception{
        when(repository.findById(any())).thenThrow(BusinessException.class);
        service.findById(StarWarsScenarioFactory.NAME_INVALID);
    }

}
