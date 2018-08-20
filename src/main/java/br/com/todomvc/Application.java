package br.com.todomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableWebFlux
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
