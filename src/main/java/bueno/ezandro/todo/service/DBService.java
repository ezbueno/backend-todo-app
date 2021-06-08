package bueno.ezandro.todo.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bueno.ezandro.todo.model.Todo;
import bueno.ezandro.todo.repository.TodoRepository;

@Service
public class DBService {

	private TodoRepository todoRepository;

	@Autowired
	public DBService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public void insertDataForTesting() {
		var t1 = new Todo();
		t1.setDescription("Estudar Java");
		t1.setDone(false);
		t1.setCreatedDate(LocalDateTime.now());

		var t2 = new Todo();
		t2.setDescription("Estudar Spring Boot");
		t2.setDone(false);
		t2.setCreatedDate(LocalDateTime.now());

		this.todoRepository.saveAll(Arrays.asList(t1, t2));
	}

}
