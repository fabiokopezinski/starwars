package br.com.b2w.starwars.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.b2w.starwars.domain.request.PlanetRequest;
import br.com.b2w.starwars.domain.response.PlanetResponse;

public class AbstractSteps {
    
    public static final String HTTP_CODE_RESPONSE = "httpCodeResponse";
	public static final String PLANET_CODE = "planetCode";

    public static final String SUFFIX = "/planets";

	@Autowired
	protected TestRestTemplate template;

	@LocalServerPort
	private int port;

    @Value("${server.servlet.context-path:/}")
	private String servletPath;

	@Value("${spring.profiles.active:dev}")
	protected String profile;


    public String baseUrl() {
		return String.format("http://localhost:%d%s%s", port, servletPath, SUFFIX);
	}

	public TestContext testContext() {
		return TestContext.CONTEXT;
	}


    protected ResponseEntity<String> findAll (String limit,String offset) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Page<PlanetResponse>> body=new HttpEntity<Page<PlanetResponse>>(headers);

        String url=String.format("%s?offset=%s&limit=%s", baseUrl(),offset,limit);

        return template.exchange(url,HttpMethod.GET,body,String.class);

    }
    
    protected ResponseEntity<String> getName (String name) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PlanetResponse> body=new HttpEntity<PlanetResponse>(headers);

        String url=String.format("%s/names/%s", baseUrl(),name);

        return template.exchange(url,HttpMethod.GET,body,String.class);

    }
    
    protected ResponseEntity<String> getId (String id) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PlanetResponse> body=new HttpEntity<PlanetResponse>(headers);

        String url=String.format("%s/%s", baseUrl(),id);

        return template.exchange(url,HttpMethod.GET,body,String.class);

    }
    
    protected ResponseEntity<PlanetResponse> save (PlanetRequest request) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_JSON);
        

        HttpEntity<PlanetRequest> body=new HttpEntity<PlanetRequest>(request,headers);

        String url=String.format("%s", baseUrl());

        return template.exchange(url,HttpMethod.POST,body,PlanetResponse.class);

    }
    
    protected ResponseEntity<Void> delete (String id) throws Exception{

        HttpHeaders headers = new HttpHeaders();
        
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<PlanetRequest> body=new HttpEntity<PlanetRequest>(headers);

        String url=String.format("%s/%s", baseUrl(),id);

        return template.exchange(url,HttpMethod.DELETE,body,Void.class);

    }
}
