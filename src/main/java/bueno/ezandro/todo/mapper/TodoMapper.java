package bueno.ezandro.todo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import bueno.ezandro.todo.model.Todo;
import bueno.ezandro.todo.model.dto.TodoDTO;

@Mapper
public interface TodoMapper {

	TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

	Todo toModel(TodoDTO todoDTO);

	TodoDTO toDTO(Todo todo);
	
	List<TodoDTO> toDTO(List<Todo> todos);


}
