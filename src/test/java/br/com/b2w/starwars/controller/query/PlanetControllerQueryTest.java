package br.com.b2w.starwars.controller.query;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.b2w.starwars.feature.StarWarsScenarioFactory;
import br.com.b2w.starwars.service.query.PlanetServiceQuery;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetControllerQuery.class)
public class PlanetControllerQueryTest {
    
    @Autowired
	  private MockMvc mockMvc;

    @MockBean
    private PlanetServiceQuery query;

    @Test
    public void findAll_whenOffsetAndLimitDefault_expectedOk() throws Exception{
     when(query.findAll(0, 10)).thenReturn(StarWarsScenarioFactory.PLANET_ALL_RESPONSE);
      mockMvc.perform(get("/planets")
      .param("offset", "0")
      .param("limit", "10")).andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findById_whenIdIsValid_expectedOk() throws Exception{
     when(query.findById(any())).thenReturn(StarWarsScenarioFactory.PLANET_RESPONSE);
      mockMvc.perform(get("/planets/4721384732814")).andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findByName_whenNameIsValid_expectedOk() throws Exception{
     when(query.findByName(any())).thenReturn(StarWarsScenarioFactory.PLANET_RESPONSE);
      mockMvc.perform(get("/planets/names/TESTE")).andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
