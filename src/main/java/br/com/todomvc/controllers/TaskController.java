package br.com.todomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todomvc.models.TaskModel;
import br.com.todomvc.repositories.TaskRespository;
import reactor.core.publisher.Flux;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRespository taskRespository;

    @GetMapping
    public Flux<TaskModel> index() {
        return taskRespository.findAll();
    }
}
