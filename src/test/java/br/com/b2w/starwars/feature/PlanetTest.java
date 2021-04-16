package br.com.b2w.starwars.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PlanetTest extends AbstractSteps {

	String name;

	String climate;

	String terrainOne;

	String terrainTwo;

	String id;

	@Quando("realizar uma consulta de todos os planetas e informo o {string} e o {string}")
	public void realizar_uma_consulta_de_todos_os_planetas_e_informo_o_e_o(String string, String string2)
			throws Exception {

		ResponseEntity<String> planets = findAll(string, string2);

		this.testContext().setResponse(planets);
		this.testContext().set(HTTP_CODE_RESPONSE, planets.getStatusCode().value());
	}

	@Entao("a API deve me retornar o código da operação {string} e os dados apresentados no corpo da solicitação")
	public void a_API_deve_me_retornar_o_código_da_operação_e_os_dados_apresentados_no_corpo_da_solicitação(
			String string) {
		assertEquals(Integer.parseInt(string), this.testContext().getResponse().getStatusCodeValue());
	}

	@Dado("que vou realizar um consulta por nome {string}")
	public void que_vou_realizar_um_consulta_por_nome(String string) throws Exception {

		this.name = string;
	}

	@Quando("realizar uma consulta")
	public void realizar_uma_consulta() throws Exception {

		ResponseEntity<String> planet = getName(name);
		this.testContext().setResponse(planet);
		this.testContext().set(HTTP_CODE_RESPONSE, planet.getStatusCode().value());
	}

	@Dado("que vou realizar um consulta por id {string}")
	public void que_vou_realizar_um_consulta_por_id(String string) {
		this.id = string;
	}

	@Quando("realizar uma consulta por id")
	public void realizar_uma_consulta_por_id() throws Exception {

		ResponseEntity<String> planet = getId(id);
		this.testContext().setResponse(planet);
		this.testContext().set(HTTP_CODE_RESPONSE, planet.getStatusCode().value());
	}

	@Dado("que vou cadastrar um planet com  {string}, {string},{string},{string}")
	public void que_vou_cadastrar_um_planet_com(String string, String string2, String string3, String string4) {
		this.name = string;
		this.climate = string2;
		this.terrainOne = string3;
		this.terrainTwo = string4;

	}

	@Quando("realizar o cadastro")
	public void realizar_o_cadastro() throws Exception {

		List<String> climates = new ArrayList<>();
		climates.add(climate);

		List<String> terrains = new ArrayList<>();
		terrains.add(terrainOne);
		terrains.add(terrainTwo);

		PlanetRequest planetRequest = new PlanetRequest(name, climates, terrains);

		ResponseEntity<PlanetResponse> planet = save(planetRequest);

		this.testContext().setResponse(planet);
		this.testContext().set(HTTP_CODE_RESPONSE, planet.getStatusCode().value());
	}
	
	@Dado("que vou excluir um planeta no banco")
	public void que_vou_excluir_um_planeta_no_banco() throws Exception {
	   ResponseEntity<PlanetResponse> response = save(StarWarsScenarioFactory.PLANET_REQUEST_BDD);
	   this.testContext().setResponse(response);
	   ResponseEntity<PlanetResponse> response2 = this.testContext().getResponse();
	   this.id=response2.getBody().getPlanetCode();
	}

	@Quando("realizar a deleção")
	public void realizar_a_deleção() throws Exception {
		
	    ResponseEntity<Void> planet=delete(id);
	    this.testContext().setResponse(planet);
		this.testContext().set(HTTP_CODE_RESPONSE, planet.getStatusCode().value());
	    
	}
	
	@Dado("que vou excluir um planeta no banco com id invalido")
	public void que_vou_excluir_um_planeta_no_banco_com_id_invalido() {
	    this.id="1423748324";
	}

	@Quando("realizar a deleção com id invalido")
	public void realizar_a_deleção_com_id_invalido() throws Exception {
		
		ResponseEntity<Void> planet=delete(id);
	    this.testContext().setResponse(planet);
		this.testContext().set(HTTP_CODE_RESPONSE, planet.getStatusCode().value());
	}


}
