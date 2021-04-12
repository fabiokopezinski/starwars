package br.com.b2w.starwars.controller.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.b2w.starwars.feature.StarWarsScenarioFactory;
import br.com.b2w.starwars.service.command.PlanetServiceCommand;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetControllerCommand.class)
public class PlanetControllerCommandTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetServiceCommand command;


    @Test
    public void save_WhenPlanetRequestIsValid_ExpectedOk() throws Exception{
        when(command.save(any())).thenReturn(StarWarsScenarioFactory.PLANET_RESPONSE);
        mockMvc.perform(post("/planets").contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(StarWarsScenarioFactory.PLANET_REQUEST)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void delete_WhenPlanetRequestIsValid_ExpectedOk()throws Exception{
        mockMvc.perform(delete("/planets/4721384732814")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }


    public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
