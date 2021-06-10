package bueno.ezandro.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bueno.ezandro.todo.model.dto.TodoDTO;
import bueno.ezandro.todo.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/todos")
public class TodoController {

	private TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TodoDTO create(@RequestBody TodoDTO todoDTO) {
		todoDTO = this.todoService.create(todoDTO);
		return todoDTO;
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TodoDTO findById(@PathVariable Long id) {
		return this.todoService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoDTO> findByAll() {
		return this.todoService.findAll();
	}

}
