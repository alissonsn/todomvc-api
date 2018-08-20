package br.com.todomvc.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.todomvc.models.TaskModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Alisson Nascimento
 *
 */
public interface TaskRespository extends ReactiveMongoRepository<TaskModel, String> {
    Flux<TaskModel> findByNome(String nome);
    
    Mono<Void> deleteById(String[] id);
}
