package br.com.b2w.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.starwars.domain.response.SwapiResults;
import br.com.b2w.starwars.validations.Message;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SwapiService{
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${swapi.url}")
    private String base;

    public Integer getFilms(String name){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SwapiResults> body=new HttpEntity<SwapiResults>(headers);
        String url=String.format("%s?search=%s", base,name);
        ResponseEntity<SwapiResults> exchange = restTemplate.exchange(url, HttpMethod.GET,body,SwapiResults.class);
        if(exchange.getBody().getResults().size()==0){
            throw Message.NOT_FOUND_PLANET.asBusinessException();
        }
        log.info("method=getFilms url={} films={}",url,exchange.getBody().getResults().get(0).getFilms().size());
        return exchange.getBody().getResults().get(0).getFilms().size();
    }
}
