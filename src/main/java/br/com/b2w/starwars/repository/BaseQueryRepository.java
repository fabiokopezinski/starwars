package br.com.b2w.starwars.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseQueryRepository <T,ID> extends Repository<T,ID> {
    
    List<T> findAll();
}
