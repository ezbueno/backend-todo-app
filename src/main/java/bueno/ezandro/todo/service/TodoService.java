package bueno.ezandro.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bueno.ezandro.todo.mapper.TodoMapper;
import bueno.ezandro.todo.model.dto.TodoDTO;
import bueno.ezandro.todo.repository.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;
	private static final TodoMapper todoMapper = TodoMapper.INSTANCE;

	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Transactional
	public TodoDTO create(TodoDTO todoDTO) {
		todoDTO.setId(null);
		var todoToSave = todoMapper.toModel(todoDTO);
		var savedTodo = this.todoRepository.save(todoToSave);
		return todoMapper.toDTO(savedTodo);
	}

}
