import br.com.b2w.starwars.domain.response.PlanetResponse
import br.com.b2w.starwars.feature.StarWarsScenarioFactory
import br.com.b2w.starwars.repository.query.PlanetQueryRepository
import br.com.b2w.starwars.service.query.PlanetServiceQuery
import org.springframework.data.domain.Page
import spock.lang.Specification

class PlanetServiceSpec extends Specification {

    PlanetQueryRepository repository

    PlanetServiceQuery serviceQuery;

    def setup(){
        repository = Mock(PlanetQueryRepository)
        serviceQuery = new PlanetServiceQuery(repository)
    }

    def "Dado um request para listar planetas, quando passar uma paginacao, então deve retornar uma lista"(){
        given: "Dado um offset e limit"
        int offset = 0
        int limit = 10

        and: "Quando chamar o repositorio"
         1 * repository.findAll(_) >> StarWarsScenarioFactory.PLANET_ALL

        when: "Quando chamar o servico"
        def response = serviceQuery.findAll(offset, limit)

        then: "deve retornar os dados"
        response.getContent().get(0).getClimate().get(0) == "desert"
    }
}