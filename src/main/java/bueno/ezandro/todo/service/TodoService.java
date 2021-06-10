package bueno.ezandro.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bueno.ezandro.todo.exception.TodoNotFoundException;
import bueno.ezandro.todo.mapper.TodoMapper;
import bueno.ezandro.todo.model.Todo;
import bueno.ezandro.todo.model.dto.TodoDTO;
import bueno.ezandro.todo.repository.TodoRepository;
import bueno.ezandro.todo.util.MessageUtil;

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

	@Transactional(readOnly = true)
	public TodoDTO findById(Long id) {
		var optionalTodo = this.todoRepository.findById(id);

		if (optionalTodo.isPresent()) {
			return todoMapper.toDTO(optionalTodo.get());
		}
		throw new TodoNotFoundException(MessageUtil.TODO_NOT_FOUND + id);
	}

	@Transactional(readOnly = true)
	public List<TodoDTO> findAll() {
		List<Todo> todos = this.todoRepository.findAll();
		return todoMapper.toDTO(todos);
	}

}
