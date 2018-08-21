package br.com.todomvc.controllers;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import br.com.todomvc.models.TaskModel;
import br.com.todomvc.repositories.TaskRespository;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@Configuration
public class RoutesConfiguration {

	@Bean
	RouterFunction<?> routesRestaurante(TaskRespository taskRespository) {
		return nest(path("/task"),

				route(RequestPredicates.GET("/{id}"),
						request -> ok().body(taskRespository.findById(request.pathVariable("id")), TaskModel.class))

				.andRoute(RequestPredicates.GET("/alterar/{valor}/{id}"), 
						request -> {
							taskRespository.findById(request.pathVariable("id")).subscribe(
								task -> {
									task.setCompleta(Boolean.valueOf(request.pathVariable("valor")));
									taskRespository.save(task).subscribe();
								}
							);
							return ok().build();
						})
				
				.andRoute(RequestPredicates.GET("/alterar-muitos/{valor}/{ids}"), 
						request -> {
							List<String> ids = Arrays.asList(request.pathVariable("ids").split(","));
							ids.forEach (
								id -> taskRespository.findById(id).subscribe(
									task -> {
										task.setCompleta(Boolean.valueOf(request.pathVariable("valor")));
										taskRespository.save(task).subscribe();
									}
								)
							);
							return ok().build();
						})
				
				.andRoute(RequestPredicates.GET("/remover/{id}"), 
						request -> {
							taskRespository.deleteById(request.pathVariable("id")).subscribe();
							return ok().build();
						})
				
				.andRoute(RequestPredicates.GET("/remover-muitos/{ids}"), 
						request -> {
							List<String> ids = Arrays.asList(request.pathVariable("ids").split(","));
							ids.forEach(id -> taskRespository.deleteById(id).subscribe());
							return ok().build();
						})
				
				.andRoute(method(HttpMethod.POST),
						request -> {
							taskRespository.insert(request.bodyToMono(TaskModel.class)).subscribe();
							return ok().build();
						})
				);
	}

}
