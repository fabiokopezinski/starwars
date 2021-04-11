package br.com.b2w.starwars.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseCommandRepository <T,ID> extends Repository <T,ID> {

    T save(T ID);
    
}
