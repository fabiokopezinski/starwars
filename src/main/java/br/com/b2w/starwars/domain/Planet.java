package br.com.b2w.starwars.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Document(collection="planet")
public class Planet {
    
    @Id
    private String planetCode;

    @Indexed(unique = true)
    @Field(name="NOME")
    private String name;

    @Field(name="CLIMA")
    private String climate;

    @Field(name="TERRENO")
    private String ground;

    @Field(name="APARICOES_FILMES")
    private String filmAppearances;


}
