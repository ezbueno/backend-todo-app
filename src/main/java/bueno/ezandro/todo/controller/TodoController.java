package bueno.ezandro.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bueno.ezandro.todo.model.dto.TodoDTO;
import bueno.ezandro.todo.service.TodoService;

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

}
