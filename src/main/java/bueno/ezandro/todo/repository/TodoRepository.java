package bueno.ezandro.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bueno.ezandro.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
