FROM openjdk:11-jdk-slim

VOLUME /tmp

ADD target/starwars-1.0.0.jar app.jar

EXPOSE 8080

RUN   bash -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","-Dspring-boot.run.arguments=--spring.config.location=classpath:application.properties", "/app.jar"]