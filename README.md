[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/fabiokopezinski/starwars)


# Projeto Star Wars Planets

# Objetivo

Nossos associados são aficionados por Star Wars e com isso, queremos criar um jogo com algumas informações da franquia.
Para possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.

# Requisitos:

- A API deve ser REST

- Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente:

+ Nome
+ Clima
+ Terreno

- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.dev/about

# Funcionalidades desejadas:

+ Adicionar um planeta (com nome, clima e terreno)

+ Listar planetas

+ Buscar por nome

+ Buscar por ID

+ Remover planeta

# Ferramentas 
  + Java 8
  + Spring boot
  + MongoDb (atlas)
  
# Executando o projeto
 + [Heroku](https://star-wars-api-b2w.herokuapp.com/v1/swagger)
 + Docker: docker-compose up -d
 + Docker url: http://localhost:8081/v1/swagger
 + Ao usar o docker entrando no Swagger selecionar no Servers o http://localhost:8081/v1 
