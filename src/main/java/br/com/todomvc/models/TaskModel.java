package br.com.todomvc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskModel {
	@Id
	private String id;
	
    private String nome;
    
    private boolean completa;
}
